/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.model;

/**
 *
 * @author AlbertoRS
 */
public class champions {

    private int codChamp;
    private String nombre;
    private String descripcion;
    private String p;
    private String q;
    private String w;
    private String e;
    private String r;

    public champions() {
        this(-1, "", "", "", "", "", "", "");
    }

    public champions(int codChamp, String nombre, String descripcion, String p, String q, String w, String e, String r) {
        this.codChamp = codChamp;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.p = p;
        this.q = q;
        this.w = w;
        this.e = e;
        this.r = r;
    }

    

    public int getCodChamp() {
        return codChamp;
    }

    public String getNombre() {
        return nombre;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "champions{" + "codChamp=" + codChamp + ", nombre=" + nombre + ", descripcion=" + descripcion + ", p=" + p + ", q=" + q + ", w=" + w + ", e=" + e + ", r=" + r + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean igual = false;
        if (obj != null) {
            if (this == obj) {
                igual = true;
            } else {
                if (obj instanceof champions) {
                    champions n = (champions) obj;
                    if (this.codChamp == n.getCodChamp()) {
                        igual = true;
                    }
                }
            }
        }
        return igual;
    }

}
