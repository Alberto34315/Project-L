/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.DAO;

import com.mycompany.projecytl.Enums.RuneType;
import com.mycompany.projecytl.Enums.RunesPrimary;
import com.mycompany.projecytl.Enums.SlotGeneral;
import com.mycompany.projecytl.Enums.buffsGeneral;
import com.mycompany.projecytl.Utils.ConnectionUtils;
import com.mycompany.projecytl.Utils.Dialog;
import com.mycompany.projecytl.controller.AppController;
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
public class runesDao extends runes implements DAO {
//Modificar ENUMS

    enum queries {
        INSERT("INSERT INTO runes (codRune,name,RuneType,DescriptionType,R1,DescriptionRunesPrimary,S1,DescriptionS1,S2,DescriptionS2,S3,DescriptionS3,R2,DescriptionRunesSecondary,S4,DescriptionS4,S5,DescriptionS5,B1,DescriptionB1,B2,DescriptionB2,B3,DescriptionB3) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"),
        ALL("SELECT * FROM runes"),
        GETBYID("SELECT * FROM runes WHERE codRune=?"),
        UPDATE("UPDATE runes SET RuneType = ?, name = ?, DescriptionType = ?, R1 = ?, DescriptionRunesPrimary = ?, S1 = ?, DescriptionS1 = ?, S2 = ?, DescriptionS2 = ?, S3 = ?, DescriptionS3 = ?, R2 = ?, DescriptionRunesSecondary = ?, S4 = ?, DescriptionS4 = ?, S5 = ?, DescriptionS5 = ?, B1 = ?, DescriptionB1 = ?, B2 = ?, DescriptionB2 = ?, B3 = ?, DescriptionB3 = ?  WHERE codRune = ?"),
        REMOVE("DELETE FROM runes WHERE codRune=?");
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

    public runesDao(int codRune, String name, RuneType type, String descriptionType, RunesPrimary r1, String descriptionRunesPrimary, SlotGeneral s1, String descriptionS1, SlotGeneral s2, String descriptionS2, SlotGeneral s3, String descriptionS3, RuneType r2, String descriptionRunesSecondary, SlotGeneral s4, String descriptionS4, SlotGeneral s5, String descriptionS5, buffsGeneral b1, String descriptionB1, buffsGeneral b2, String descriptionB2, buffsGeneral b3, String descriptionB3) {
        super(codRune, name, type, descriptionType, r1, descriptionRunesPrimary, s1, descriptionS1, s2, descriptionS2, s3, descriptionS3, r2, descriptionRunesSecondary, s4, descriptionS4, s5, descriptionS5, b1, descriptionB1, b2, descriptionB2, b3, descriptionB3);
        try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(runesDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(runesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        persist = false;
    }

    public runesDao() {
        super();
        try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(runesDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(runesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        persist = false;
    }

    public runesDao(runes r) {
        this(r.getCodRune(), r.getName(), r.getType(), r.getDescriptionType(), r.getR1(), r.getDescriptionRunesPrimary(), r.getS1(), r.getDescriptionS1(), r.getS2(), r.getDescriptionS2(), r.getS3(), r.getDescriptionS3(), r.getR2(), r.getDescriptionRunesSecondary(), r.getS4(), r.getDescriptionS4(), r.getS5(), r.getDescriptionS5(), r.getB1(), r.getDescriptionB1(), r.getB2(), r.getDescriptionB2(), r.getB3(), r.getDescriptionB3());
    }

    public runesDao(int i) {
        this();
        List<Object> params = new ArrayList<>();
        params.add(i);
        java.sql.Connection csql = ConnectionUtils.getConnection();

        try {
            queries qu = null;
            String q = qu.GETBYID.getQ();
            PreparedStatement ps = csql.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    runes r = instanceBuilder(rs);
                    this.codRune = r.getCodRune();
                    this.name = r.getName();
                    this.type = r.getType();
                    this.descriptionType = r.getDescriptionType();
                    this.r1 = r.getR1();
                    this.descriptionRunesPrimary = r.getDescriptionRunesPrimary();
                    this.s1 = r.getS1();
                    this.descriptionS1 = r.getDescriptionS1();
                    this.s2 = r.getS2();
                    this.descriptionS2 = r.getDescriptionS2();
                    this.s3 = r.getS3();
                    this.descriptionS3 = r.getDescriptionS3();
                    this.r2 = r.getR2();
                    this.descriptionRunesSecondary = r.getDescriptionRunesSecondary();
                    this.s4 = r.getS4();
                    this.descriptionS4 = r.getDescriptionS4();
                    this.s5 = r.getS5();
                    this.descriptionS5 = r.getDescriptionS5();
                    this.b1 = r.getB1();
                    this.descriptionB1 = r.getDescriptionB1();
                    this.b2 = r.getB2();
                    this.descriptionB2 = r.getDescriptionB2();
                    this.b3 = r.getB3();
                    this.descriptionB3 = r.getDescriptionB3();
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
    public void remove() {
        if (this.codRune != -1) {
            try {
                //Comienza transacción
                con.setAutoCommit(false);
                //Boorando aquellos que no están ya -> coherencia
                //  List<Channel> oldChannels = ChannelDao.getByContact(con, id);

                /* for (Channel oldChannel : oldChannels) {
                    ChannelDao cd = new ChannelDao(oldChannel);
                    cd.remove();
                }*/
                // int rs = ConnectionUtils.execUpdate(con, queries.REMOVE.getQ(), this.codRune, false);
                //Fin de la transacción
                con.commit();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Dialog.showError("ERROR", "Error borrando runas", ex.toString());
            }
        }
    }

    @Override
    public int save() {
        int result = -1;
        queries qu = null;

        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();

            if (this.codRune > 0) {
                //UPDATE
                String q = qu.UPDATE.getQ();
                PreparedStatement ps = csql.prepareStatement(q);
                ps.setString(1, name);
                ps.setString(2, type.getRune());
                ps.setString(3, descriptionType);
                ps.setString(4, r1.getRune());
                ps.setString(5, descriptionRunesPrimary);
                ps.setString(6, s1.getRune());
                ps.setString(7, descriptionS1);
                ps.setString(8, s2.getRune());
                ps.setString(9, descriptionS2);
                ps.setString(10, s3.getRune());
                ps.setString(11, descriptionS3);
                ps.setString(12, r2.getRune());
                ps.setString(13, descriptionRunesSecondary);
                ps.setString(14, s4.getRune());
                ps.setString(15, descriptionS4);
                ps.setString(16, s5.getRune());
                ps.setString(17, descriptionS5);
                ps.setString(18, b1.getRune());
                ps.setString(19, descriptionB1);
                ps.setString(20, b2.getRune());
                ps.setString(21, descriptionB2);
                ps.setString(22, b3.getRune());
                ps.setString(23, descriptionB3);
                ps.setInt(24, codRune);
                result = ps.executeUpdate();
            } else {
                //INSERT
                String q = qu.INSERT.getQ();
                PreparedStatement ps = csql.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, type.getRune());
                ps.setString(3, descriptionType);
                ps.setString(4, r1.getRune());
                ps.setString(5, descriptionRunesPrimary);
                ps.setString(6, s1.getRune());
                ps.setString(7, descriptionS1);
                ps.setString(8, s2.getRune());
                ps.setString(9, descriptionS2);
                ps.setString(10, s3.getRune());
                ps.setString(11, descriptionS3);
                ps.setString(12, r2.getRune());
                ps.setString(13, descriptionRunesSecondary);
                ps.setString(14, s4.getRune());
                ps.setString(15, descriptionS4);
                ps.setString(16, s5.getRune());
                ps.setString(17, descriptionS5);
                ps.setString(18, b1.getRune());
                ps.setString(19, descriptionB1);
                ps.setString(20, b2.getRune());
                ps.setString(21, descriptionB2);
                ps.setString(22, b3.getRune());
                ps.setString(23, descriptionB3);
                result = ps.executeUpdate();
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        result = generatedKeys.getInt(1);  //<-- return last id inserted
                    }
                }
                this.codRune = result;

            }
        } catch (SQLException ex) {
            Logger.getLogger(runesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static runes instanceBuilder(ResultSet rs) {
        //ojo rs.getMetaData()
        runes c = new runes();
        if (rs != null) {
            try {
                c.setCodRune(rs.getInt("codRune"));
                c.setName(rs.getString("name"));
                for (RuneType _type : RuneType.values()) {
                    if (_type.getRune().equals(rs.getString("RuneType"))) {
                        c.setType(_type);
                    }
                }
                c.setDescriptionType(rs.getString("DescriptionType"));
                for (RunesPrimary _type : RunesPrimary.values()) {
                    if (_type.getRune().equals(rs.getString("R1"))) {
                        c.setR1(_type);
                    }
                }
                c.setDescriptionRunesPrimary(rs.getString("DescriptionRunesPrimary"));
                for (SlotGeneral _type : SlotGeneral.values()) {
                    if (_type.getRune().equals(rs.getString("S1"))) {
                        c.setS1(_type);
                    }
                }
                c.setDescriptionS1(rs.getString("DescriptionS1"));
                for (SlotGeneral _type : SlotGeneral.values()) {
                    if (_type.getRune().equals(rs.getString("S2"))) {
                        c.setS2(_type);
                    }
                }
                c.setDescriptionS2(rs.getString("DescriptionS2"));
                for (SlotGeneral _type : SlotGeneral.values()) {
                    if (_type.getRune().equals(rs.getString("S3"))) {
                        c.setS3(_type);
                    }
                }
                c.setDescriptionS3(rs.getString("DescriptionS3"));
                for (RuneType _type : RuneType.values()) {
                    if (_type.getRune().equals(rs.getString("R2"))) {
                        c.setR2(_type);
                    }
                }
                c.setDescriptionRunesSecondary(rs.getString("DescriptionRunesSecondary"));
                for (SlotGeneral _type : SlotGeneral.values()) {
                    if (_type.getRune().equals(rs.getString("S4"))) {
                        c.setS4(_type);
                    }
                }
                c.setDescriptionS4(rs.getString("DescriptionS4"));
                for (SlotGeneral _type : SlotGeneral.values()) {
                    if (_type.getRune().equals(rs.getString("S5"))) {
                        c.setS5(_type);
                    }
                }
                c.setDescriptionS5(rs.getString("DescriptionS5"));
                for (buffsGeneral _type : buffsGeneral.values()) {
                    if (_type.getRune().equals(rs.getString("B1"))) {
                        c.setB1(_type);
                    }
                }
                c.setDescriptionB1(rs.getString("DescriptionB1"));
                for (buffsGeneral _type : buffsGeneral.values()) {
                    if (_type.getRune().equals(rs.getString("B2"))) {
                        c.setB2(_type);
                    }
                }
                c.setDescriptionB2(rs.getString("DescriptionB2"));
                for (buffsGeneral _type : buffsGeneral.values()) {
                    if (_type.getRune().equals(rs.getString("B3"))) {
                        c.setB3(_type);
                    }
                }
                c.setDescriptionB3(rs.getString("DescriptionB3"));
            } catch (SQLException ex) {
                Dialog.showError("Error SQL", "SQL creando runas", ex.toString());
            }
        }
        return c;
    }

    public static List<runes> getAll(Connection con) {
        List<runes> result = new ArrayList<>();
        runesDao.queries qu = null;
        try {
            java.sql.Connection csql = ConnectionUtils.getConnection();
            String qe = qu.ALL.getQ();
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
