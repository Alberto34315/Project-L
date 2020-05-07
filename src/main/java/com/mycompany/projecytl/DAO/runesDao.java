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
import com.mycompany.projecytl.Utils.ConnectionUtil;
import com.mycompany.projecytl.Utils.Dialog;
import com.mycompany.projecytl.controller.AppController;
import com.mycompany.projecytl.model.runes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlbertoRS
 */
public class runesDao extends runes implements DAO {
//Modificar ENUMS
    enum queries {
        INSERT("INSERT INTO runes (codRune,RuneType,RunesPrimary,S1,S2,S3,S4,S5,B1,B2,B3,Description) VALUES (-1,?,?,?,?,?,?,?,?,?,?,?)"),
        ALL("SELECT * FROM runes"),
        GETBYID("SELECT * FROM runes WHERE codRune=?"),
        UPDATE("UPDATE runes SET RuneType = ?, RunesPrimary = ?, S1 = ?, S2 = ?, S3 = ?, S4 = ?, S5 = ?, B1 = ?,B2 = ?, B3 = ?, Description = ?   WHERE codRune = ?"),
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

    public runesDao(int codRune, RuneType type, String descriptionType, RunesPrimary r1, String descriptionRunesPrimary, SlotGeneral s1, String descriptionS1, SlotGeneral s2, String descriptionS2, SlotGeneral s3, String descriptionS3, RunesPrimary r2, String descriptionRunesSecondary, SlotGeneral s4, String descriptionS4, SlotGeneral s5, String descriptionS5, buffsGeneral b1, String descriptionB1, buffsGeneral b2, String descriptionB2, buffsGeneral b3, String descriptionB3) {
        super(codRune, type, descriptionType, r1, descriptionRunesPrimary, s1, descriptionS1, s2, descriptionS2, s3, descriptionS3, r2, descriptionRunesSecondary, s4, descriptionS4, s5, descriptionS5, b1, descriptionB1, b2, descriptionB2, b3, descriptionB3);
        con = ConnectionUtil.connect(AppController.currentConnection);
        persist = false;
    }

    public runesDao() {
        super();
        con = ConnectionUtil.connect(AppController.currentConnection);
        persist = false;
    }

    public runesDao(runes r) {
        this(r.getCodRune(), r.getType(), r.getDescriptionType(), r.getR1(), r.getDescriptionRunesPrimary(), r.getS1(), r.getDescriptionS1(), r.getS2(), r.getDescriptionS2(), r.getS3(), r.getDescriptionS3(), r.getR2(), r.getDescriptionRunesSecondary(), r.getS4(), r.getDescriptionS4(), r.getS5(), r.getDescriptionS5(), r.getB1(), r.getDescriptionB1(), r.getB2(), r.getDescriptionB2(), r.getB3(), r.getDescriptionB3());
    }

    public runesDao(int i) {
        this();
        List<Object> params = new ArrayList<>();
        params.add(i);
        try {
            ResultSet rs = ConnectionUtil.execQuery(con, queries.GETBYID.getQ(), params);
            if (rs != null) {
                while (rs.next()) {
                    runes r = instanceBuilder(rs);
                    this.codRune = r.getCodRune();
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
                int rs = ConnectionUtil.execUpdate(con, queries.REMOVE.getQ(), this.codRune, false);
                //Fin de la transacción
                con.commit();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                Dialog.showError("ERROR", "Error borrando runas", ex.toString());
            }
        }
    }

    @Override
    public void save() {
        queries q;
        List<Object> params = new ArrayList<>();
        params.add(this.getType());
        params.add(this.getDescriptionType());
        params.add(this.getR1());
        params.add(this.getDescriptionRunesPrimary());
        params.add(this.getS1());
        params.add(this.getDescriptionS1());
        params.add(this.getS2());
        params.add(this.getDescriptionS2());
        params.add(this.getS3());
        params.add(this.getDescriptionS3());
        params.add(this.getR2());
        params.add(this.getDescriptionRunesSecondary());
        params.add(this.getS4());
        params.add(this.getDescriptionS4());
        params.add(this.getS5());
        params.add(this.getDescriptionS5());
        params.add(this.getB1());
        params.add(this.getDescriptionB1());
        params.add(this.getB2());
        params.add(this.getDescriptionB2());
        params.add(this.getB3());
        params.add(this.getDescriptionB3());
        if (this.codRune == -1) {
            q = queries.INSERT;
        } else {
            q = queries.UPDATE;
            params.add(this.codRune);
        }
        try {
            //Comienza transacción
            con.setAutoCommit(false);
            int rs = ConnectionUtil.execUpdate(con, q.getQ(), params, (q == queries.INSERT ? true : false));
            if (q == runesDao.queries.INSERT) {
                this.codRune = rs;
            }
            /* if (channels != null) { //si se ha modificado algo sobre channels
                //Borrando aquellos que no están ya -> coherencia
                List<Channel> oldChannels = ChannelDao.getByContact(con, id);
                for (Channel oldChannel : oldChannels) {
                    if (!channels.contains(oldChannel)) {
                        ChannelDao cd = new ChannelDao(oldChannel);
                        cd.remove();
                    }
                }
                //Actualizando o insertando los nuevos
                for (Channel newChannels : channels) {
                    ChannelDao cd = new ChannelDao(newChannels);
                    cd.setId_contact(id); //me aseguro de la relación
                    cd.save();
                }
            }*/
            //Fin de la transacción
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            Dialog.showError("ERROR", "Error guardando runas", ex.toString());
        }
    }

    public static runes instanceBuilder(ResultSet rs) {
        //ojo rs.getMetaData()
        runes c = new runes();
        if (rs != null) {
            try {
                c.setCodRune(rs.getInt("codRune"));
                c.setType((RuneType) rs.getObject("RuneType"));
                c.setDescriptionType(rs.getString("DescriptionRuneType"));
                c.setR1((RunesPrimary) rs.getObject("RunesPrimary"));
                c.setDescriptionRunesPrimary(rs.getString("DescriptionRunesPrimary"));
                c.setS1((SlotGeneral) rs.getObject("S1"));
                c.setDescriptionS1(rs.getString("DescriptionS1"));
                c.setS2((SlotGeneral) rs.getObject("S2"));
                c.setDescriptionS2(rs.getString("DescriptionS2"));
                c.setS3((SlotGeneral) rs.getObject("S3"));
                c.setDescriptionS3(rs.getString("DescriptionS3"));
                c.setR2((RunesPrimary) rs.getObject("RunesSecondary"));
                c.setDescriptionRunesSecondary(rs.getString("DescriptionRunesSecondary"));
                c.setS4((SlotGeneral) rs.getObject("S4"));
                c.setDescriptionS4(rs.getString("DescriptionS4"));
                c.setS5((SlotGeneral) rs.getObject("S5"));
                c.setDescriptionS5(rs.getString("DescriptionS5"));
                c.setB1((buffsGeneral) rs.getObject("B1"));
                c.setDescriptionB1(rs.getString("DescriptionB1"));
                c.setB2((buffsGeneral) rs.getObject("B2"));
                c.setDescriptionB2(rs.getString("DescriptionB2"));
                c.setB3((buffsGeneral) rs.getObject("B3"));
                c.setDescriptionB3(rs.getString("DescriptionB3"));
            } catch (SQLException ex) {
                Dialog.showError("Error SQL", "SQL creando runas", ex.toString());
            }
        }
        return c;
    }

    public static List<runes> getAll(Connection con) {
        List<runes> result = new ArrayList<>();
        try {
            ResultSet rs = ConnectionUtil.execQuery(con, queries.ALL.getQ(), null);
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
