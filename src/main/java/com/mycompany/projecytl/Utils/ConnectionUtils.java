/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.Utils;

import com.mycompany.projecytl.controller.AppController;
import com.mycompany.projecytl.model.Connection;
import com.mycompany.projecytl.model.ConnectionsType;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtils {

    private static java.sql.Connection _conn = null;

    public static java.sql.Connection connect(Connection c) throws ClassNotFoundException, SQLException {
        java.sql.Connection conn = null;

        if (c == null) {
            return null;
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://" + c.getHost() + "/" + c.getDb()
                + "?useLegacyDatetimeCode=false&serverTimezone=UTC", c.getUser(), c.getPassword());

        return conn;
    }

    public static java.sql.Connection getConnection() {
        if (_conn == null) {
            Connection c = new Connection();
            c.loadDataXML();
            try {
                _conn = connect(c);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return _conn;
    }

    // cerrar conexión <- falta
    public static ResultSet execQuery(java.sql.Connection con, String q, List<Object> params) throws
            SQLException {
        ResultSet result = null;
        if (con == null) {
            return null;
        }
        PreparedStatement ps = prepareQuery(con, q, params);
        result = ps.executeQuery();
        return result;
    }

    public static ResultSet execQuery(java.sql.Connection con, String q, Object param) throws
            SQLException {
        List<Object> params = new ArrayList<>();
        params.add(param);
        return execQuery(con, q, params);
    }

    public static int execUpdate(java.sql.Connection con, String q, List<Object> params, boolean insert)
            throws SQLException {
        if (con == null) {
            return -1;
        }
        PreparedStatement ps = prepareQuery(con, q, params);
        int result = ps.executeUpdate();
        //check if insert
        if (insert) {
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); //<-- return last id inserted
                } else {
                    return -1;
                }
            }
        } else {
            return result;
        }
    }

    public static int execUpdate(java.sql.Connection con, String q, Object param, boolean insert) throws
            SQLException {
        List<Object> params = new ArrayList<>();
        params.add(param);
        return execUpdate(con, q, params, insert);
    }

    /**
     *
     */
    public static int is(Integer n) {
        return 0;
    }

    public static int is(Float n) {
        return 1;
    }

    public static int is(Double n) {
        return 2;
    }

    public static int is(Boolean n) {
        return 3;
    }

    public static int is(String n) {
        return 4;
    }

    public static int is(Array n) {
        return 5;
    }

    public static int is(Object n) {
        return 6;
    }

    public static PreparedStatement prepareQuery(java.sql.Connection con, String q, List params) throws
            SQLException {
        PreparedStatement ps = null;
        ps = con.prepareStatement(q, Statement.RETURN_GENERATED_KEYS); //<-- solo para insert es útil
        if (params != null) {
            int i = 1;
            for (Object o : params) {
                switch (is(params)) {
                    case 0:
                        ps.setInt(i++, (Integer) o);
                        break;
                    case 1:
                        ps.setFloat(i++, (Float) o);
                        break;
                    case 2:
                        ps.setDouble(i++, (Double) o);
                        break;
                    case 3:
                        ps.setBoolean(i++, (Boolean) o);
                        break;
                    case 4:
                        ps.setString(i++, (String) o);
                        break;
                    case 5:
                        ps.setArray(i++, (Array) o);
                        break;
                    default:
                        ps.setObject(i++, o);
                }
            }
        }
        return ps;
    }

    public static void checkStructure(java.sql.Connection con) {
        try {
            String sql1, sql2;
            if (AppController.currentConnection.getDb().equals(ConnectionsType.MYSQL.getType())) {
                sql1 = "CREATE TABLE IF NOT EXISTS `runes` ("
                        + " `codRune` int(11) NOT NULL AUTO_INCREMENT,"
                        + " `RuneType` Varchar(25) NOT NULL,"
                        + " `DescriptionType` Varchar(500) NOT NULL,"
                        + " `R1` Varchar(25) NOT NULL,"
                        + " `DescriptionRunesPrimary` Varchar(500) NOT NULL,"
                        + " `S1` Varchar(25) NOT NULL,"
                        + " `DescriptionS1` Varchar(500) NOT NULL,"
                        + " `S2` Varchar(25) NOT NULL,"
                        + " `DescriptionS2` Varchar(500) NOT NULL,"
                        + " `S3` Varchar(25) NOT NULL,"
                        + " `DescriptionS3` Varchar(500) NOT NULL,"
                        + " `R2` Varchar(25) NOT NULL,"
                        + " `DescriptionRunesSecondary` Varchar(500) NOT NULL,"
                        + " `S4` Varchar(25) NOT NULL,"
                        + " `DescriptionS4` Varchar(500) NOT NULL,"
                        + " `S5` Varchar(25) NOT NULL,"
                        + " `DescriptionS5` Varchar(500) NOT NULL,"
                        + " `B1` Varchar(25) NOT NULL,"
                        + " `DescriptionB1` Varchar(500) NOT NULL,"
                        + " `B2` Varchar(25) NOT NULL,"
                        + " `DescriptionB2` Varchar(500) NOT NULL,"
                        + " `B3` Varchar(25) NOT NULL,"
                        + " `DescriptionB3` Varchar(500) NOT NULL,"
                        + " PRIMARY KEY (`codRune`)"
                        + ")";
                /* sql2 = "CREATE TABLE IF NOT EXISTS `channel` ("
                        + " `id` int(11) NOT NULL AUTO_INCREMENT,"
                        + " `type` text NOT NULL,"
                        + " `value` text NOT NULL,"
                        + " `id_contact` int(11) NOT NULL,"
                        + " PRIMARY KEY (`id`)"
                        + ")";*/
                // sql3 = "ALTER TABLE `channel`"
                // + " ADD CONSTRAINT `CR` FOREIGN KEY (`id_contact`) REFERENCES `contactos` (`id`);";

            } else {
                sql1 = "CREATE TABLE IF NOT EXISTS contactos (id INT PRIMARY KEY auto_increment, name VARCHAR(255), birthdate VARCHAR(255));";
                //   sql2 = "CREATE TABLE IF NOT EXISTS channel (id INT PRIMARY KEY auto_increment, type VARCHAR(255), value VARCHAR(255), id_contact INT);";
            }
            con.setAutoCommit(
                    false);
            ConnectionUtils.execUpdate(con, sql1, null, false);
            //   ConnectionUtils.execUpdate(con, sql2,null, false);
            con.commit();

            con.setAutoCommit(true);
        } catch (SQLException ex) {
            Dialog.showError("ERROR", "Error creando tablas", ex.toString());
        }
    }
}
