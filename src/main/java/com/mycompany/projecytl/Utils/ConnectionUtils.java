/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.Utils;

import com.mycompany.projecytl.controller.AppController;
import com.mycompany.projecytl.model.Connection;
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

     private static java.sql.Connection _conn=null;
    
    public static java.sql.Connection connect(Connection c) throws ClassNotFoundException, SQLException{
        java.sql.Connection conn=null;
        
        if(c==null){
            return null;
        }
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://"+c.getHost()+"/"+c.getDb()
                +"?useLegacyDatetimeCode=false&serverTimezone=UTC",c.getUser(),c.getPassword());
        
        return conn;
    }
    
    public static java.sql.Connection getConnection(){
        if(_conn==null){
            Connection c=new Connection();
            c.loadDataXML();
            try {
                _conn=connect(c);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return _conn;
    }
    
}