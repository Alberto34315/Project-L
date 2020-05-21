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
        // UPDATE("UPDATE participates SET nombre = ?, description = ?, p = ?, q = ?, w = ?, e = ?, r = ? WHERE codChamp = ?"),
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

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save() {
        int result = -1;
        participatesDao.queries qu = null;
        List<runes> runes = runesDao.getAll(con);
        List<champions> champions = championsDao.getAll(con);
        List<Game> games = gameDao.getAll(con);
        int codC = searchCodChamp(champions);
        int codR = searchCodRunes(runes);
        int codG = searchCodGame(games);
        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();

            if (codC > 0 && codR > 0 && codG > 0) {
                //INSERT
                String qe = qu.INSERT.getQ();
                PreparedStatement ps = csql.prepareStatement(qe);
                ps.setInt(1, codG);
                ps.setInt(2, codR);
                ps.setInt(3, codC);
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
}