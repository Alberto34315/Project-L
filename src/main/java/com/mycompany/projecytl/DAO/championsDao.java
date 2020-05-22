/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.DAO;

import static com.mycompany.projecytl.DAO.championsDao.instanceBuilder;
import com.mycompany.projecytl.Utils.ConnectionUtils;
import com.mycompany.projecytl.Utils.Dialog;
import com.mycompany.projecytl.controller.AppController;
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
public class championsDao extends champions implements DAO {

    enum queries {
        INSERT("INSERT INTO champions (codChamp,nombre,description,p,q,w,e,r) VALUES (NULL,?,?,?,?,?,?,?)"),
        ALL("SELECT * FROM champions"),
        GETBYID("SELECT * FROM champions WHERE codChamp=?"),
        UPDATE("UPDATE champions SET nombre = ?, description = ?, p = ?, q = ?, w = ?, e = ?, r = ? WHERE codChamp = ?"),
        REMOVE("DELETE FROM champions WHERE codChamp=?");
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

    public championsDao(int codChamp, String nombre, String description, String p, String q, String w, String e, String r) {
        super(codChamp, nombre, description, p, q, w, e, r);
        try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(championsDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(championsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        persist = false;
    }

    public championsDao() {
        super();
        try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(championsDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(championsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        persist = false;
    }

    public championsDao(champions selected) {
        this(selected.getCodChamp(), selected.getNombre(), selected.getDescription(), selected.getP(), selected.getQ(), selected.getW(), selected.getE(), selected.getR());
    }

    public championsDao(int i) {
        this();
        List<Object> params = new ArrayList<>();
        params.add(i);
        java.sql.Connection csql = ConnectionUtils.getConnection();

        try {
            championsDao.queries qu = null;
            String q = qu.GETBYID.getQ();
            PreparedStatement ps = csql.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    champions r = instanceBuilder(rs);
                    this.codChamp = r.getCodChamp();
                    this.description = r.getDescription();
                    this.p = r.getP();
                    this.q = r.getQ();
                    this.w = r.getW();
                    this.e = r.getE();
                    this.r = r.getR();

                }
            }
        } catch (SQLException ex) {
            Dialog.showError("ERRPR", "Error cargando las runas", ex.toString());
        }
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
    public int remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save() {
        int result = -1;
        championsDao.queries qu = null;

        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();

            if (this.codChamp > 0) {
                //UPDATE
                String qe = qu.UPDATE.getQ();
                PreparedStatement ps = csql.prepareStatement(qe);
                ps.setString(1, nombre);
                ps.setString(2, description);
                ps.setString(3, p);
                ps.setString(4, q);
                ps.setString(5, w);
                ps.setString(6, e);
                ps.setString(7, r);
                ps.setInt(8, codChamp);
                result = ps.executeUpdate();
            } else {
                //INSERT
                String qe = qu.INSERT.getQ();
                PreparedStatement ps = csql.prepareStatement(qe, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, nombre);
                ps.setString(2, description);
                ps.setString(3, p);
                ps.setString(4, q);
                ps.setString(5, w);
                ps.setString(6, e);
                ps.setString(7, r);
                result = ps.executeUpdate();
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result = generatedKeys.getInt(1);  //<-- return last id inserted
                    }
                }
                this.codChamp = result;

            }
        } catch (SQLException ex) {
            Logger.getLogger(championsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static champions instanceBuilder(ResultSet rs) {
        //ojo rs.getMetaData()
        champions c = new champions();
        if (rs != null) {
            try {
                c.setCodChamp(rs.getInt("codChamp"));
                c.setNombre(rs.getString("nombre"));
                c.setDescription(rs.getString("description"));
                c.setP(rs.getString("p"));
                c.setQ(rs.getString("q"));
                c.setW(rs.getString("w"));
                c.setE(rs.getString("e"));
                c.setR(rs.getString("r"));
            } catch (SQLException ex) {
                Dialog.showError("Error SQL", "SQL creando runas", ex.toString());
            }
        }
        return c;
    }

    public static List<champions> getAll(Connection con) {
        List<champions> result = new ArrayList<>();
        championsDao.queries qu = null;
        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();
            String qe = qu.ALL.getQ();
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
}
