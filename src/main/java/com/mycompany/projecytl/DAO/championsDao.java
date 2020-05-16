/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.DAO;

import com.mycompany.projecytl.model.champions;

/**
 *
 * @author AlbertoRS
 */
public class championsDao extends champions implements DAO{

    public championsDao() {
    }

    public championsDao(int codChamp, String nombre, String descripcion, String p, String q, String w, String e, String r) {
        super(codChamp, nombre, descripcion, p, q, w, e, r);
    }

    public championsDao(champions selected) {
        this(selected.getCodChamp(),selected.getNombre(),selected.getDescripcion(),selected.getP(),selected.getQ(),selected.getW(),selected.getE(),selected.getR());
    }

    @Override
    public void persist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void detach() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
