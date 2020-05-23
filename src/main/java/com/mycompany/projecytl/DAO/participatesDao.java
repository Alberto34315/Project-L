/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.DAO;

import com.mycompany.projecytl.Utils.ConnectionUtils;
import com.mycompany.projecytl.Utils.Dialog;
import com.mycompany.projecytl.controller.AppController;
import com.mycompany.projecytl.model.Game;
import com.mycompany.projecytl.model.champions;
import com.mycompany.projecytl.model.participates;
import com.mycompany.projecytl.model.runes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlbertoRS
 */
public class participatesDao extends participates implements DAO {

    enum queries {
        INSERT("INSERT INTO participates (codGame,codRune,codChamp) VALUES (?,?,?)"),
        ALL("SELECT * FROM participates"),
        GETBYID("SELECT * FROM participates WHERE codGame=?, codRune=?,codChamp=?"),
        GETALLCHAMPION("SELECT c.* FROM participates p,champions c WHERE p.codChamp = c.codChamp"),
        GETALLRUNES("SELECT r.* FROM participates p,runes r WHERE p.codRune = r.codRune"),
        UPDATE("UPDATE participates SET codRune=?,codChamp=?  WHERE codGame = ?"),
        REMOVE("DELETE FROM participates WHERE codGame=?, codRune=?,codChamp=?");
        private String q;

        queries(String q) {
            this.q = q;
        }

        public String getQ() {
            return this.q;
        }
    }
    Connection con;
    private boolean persist;

    public participatesDao() {
        super();
        try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(participatesDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(participatesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        persist = false;
    }

    public participatesDao(int codGame, int codRune, int codChamp) {
        super(codGame, codRune, codChamp);
        try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(participatesDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(participatesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        persist = false;
    }

    public participatesDao(participates p) {
        this(p.getCodGame(), p.getCodRune(), p.getCodChamp());
    }

    @Override
    public void persist() {
        this.persist = true;
    }

    @Override
    public void detach() {
        this.persist = false;
    }

    /**
     * Elimina en la tabla el elemento que coincida con esta instancia 
     */
    public int remove() {
        int result = -1;
        if (this.codGame > 0) {

            try {
                java.sql.Connection csql = ConnectionUtils.getConnection();
                String q = "DELETE FROM participates WHERE codGame=" + this.codGame + " and codRune=" + this.codRune + " and codChamp=" + this.codChamp;

                PreparedStatement ps = csql.prepareStatement(q);
                result = ps.executeUpdate();
                if (result > 0) {
                    this.codGame = -1;
                }

            } catch (SQLException ex) {
                Logger.getLogger(participatesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    @Override
    public int save() {
        int result = -1;
        participatesDao.queries qu = null;
        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();

            if (this.codChamp < 0 && this.codRune < 0 && this.codGame < 0) {
                String qe = qu.UPDATE.getQ();
                PreparedStatement ps = csql.prepareStatement(qe);
                ps.setInt(1, codRune);
                ps.setInt(2, codChamp);
                ps.setInt(3, codGame);
                result = ps.executeUpdate();
            } else {
                //INSERT
                String qe = qu.INSERT.getQ();
                PreparedStatement ps = csql.prepareStatement(qe);
                ps.setInt(1, codGame);
                ps.setInt(2, codRune);
                ps.setInt(3, codChamp);
                result = ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(championsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private int searchCodChamp(List<champions> champions) {
        int cod = 0;
        for (champions champion : champions) {
            if (this.codChamp == champion.getCodChamp()) {
                cod = champion.getCodChamp();
            }
        }
        return cod;
    }

    private int searchCodRunes(List<runes> runes) {
        int cod = 0;
        for (runes rune : runes) {
            if (this.codRune == rune.getCodRune()) {
                cod = rune.getCodRune();
            }
        }
        return cod;
    }

    private int searchCodGame(List<Game> games) {
        int cod = 0;
        for (Game game : games) {
            if (this.codChamp == game.getCodGame()) {
                cod = game.getCodGame();
            }
        }
        return cod;
    }

    public static participates instanceBuilder(ResultSet rs) {
        participates c = new participates();
        if (rs != null) {
            try {
                c.setCodGame(rs.getInt("codGame"));
                c.setCodRune(rs.getInt("codRune"));
                c.setCodChamp(rs.getInt("codChamp"));
            } catch (SQLException ex) {
                Dialog.showError("Error SQL", "SQL creando runas", ex.toString());
            }
        }
        return c;
    }

    public static List<participates> getAll(Connection con) {
        List<participates> result = new ArrayList<>();
        participatesDao.queries qu = null;
        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();
            String qe = qu.ALL.getQ();
            PreparedStatement ps = csql.prepareStatement(qe);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    participates n = participatesDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            Dialog.showError("ERRPR", "Error cargando las runas", ex.toString());
        }
        return result;
    }

    public static List<champions> getAllChamp(Connection con) {
        List<champions> result = new ArrayList<>();
        participatesDao.queries qu = null;
        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();
            String qe = qu.GETALLCHAMPION.getQ();
            PreparedStatement ps = csql.prepareStatement(qe);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    champions n = championsDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            Dialog.showError("ERRPR", "Error cargando las runas", ex.toString());
        }
        return result;
    }

    public static List<runes> getAllRunes(Connection con) {
        List<runes> result = new ArrayList<>();
        participatesDao.queries qu = null;
        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();
            String qe = qu.GETALLRUNES.getQ();
            PreparedStatement ps = csql.prepareStatement(qe);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    runes n = runesDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            Dialog.showError("ERRPR", "Error cargando las runas", ex.toString());
        }
        return result;
    }
}
