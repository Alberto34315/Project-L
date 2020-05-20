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
public class gameDao extends Game implements DAO{
 enum queries {
        INSERT("INSERT INTO game (codGame) VALUES (NULL)"),
        ALL("SELECT * FROM game"),
        GETBYID("SELECT * FROM game WHERE codGame=?"),
       REMOVE("DELETE FROM game WHERE codGame=?");
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

    public gameDao() {
        super();
         try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gameDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(gameDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        persist = false;
    }

    public gameDao(int codGame) {
        super(codGame);
          try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gameDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(gameDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        persist = false;
    }
    public gameDao(Game g){
    this(g.getCodGame());
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
        gameDao.queries qu = null;

        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();

            if (this.codGame < 0) {
                //INSERT
                String qe = qu.INSERT.getQ();
                PreparedStatement ps = csql.prepareStatement(qe, Statement.RETURN_GENERATED_KEYS);
                result = ps.executeUpdate();
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result = generatedKeys.getInt(1);  //<-- return last id inserted
                    }
                }
                this.codGame = result;

            }
        } catch (SQLException ex) {
            Logger.getLogger(championsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
     public static Game instanceBuilder(ResultSet rs) {
        Game c = new Game();
        if (rs != null) {
            try {
                c.setCodGame(rs.getInt("codGame"));
            } catch (SQLException ex) {
                Dialog.showError("Error SQL", "SQL creando runas", ex.toString());
            }
        }
        return c;
    }

    public static List<Game> getAll(Connection con) {
        List<Game> result = new ArrayList<>();
        gameDao.queries qu = null;
        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();
            String qe = qu.ALL.getQ();
            PreparedStatement ps = csql.prepareStatement(qe);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Game n = gameDao.instanceBuilder(rs);
                    result.add(n);
                }
            }
        } catch (SQLException ex) {
            Dialog.showError("ERRPR", "Error cargando las runas", ex.toString());
        }
        return result;
    }
}
