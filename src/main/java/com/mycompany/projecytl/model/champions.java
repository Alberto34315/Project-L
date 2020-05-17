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

    protected int codChamp;
    protected String nombre;
    protected String description;
    protected String p;
    protected String q;
    protected String w;
    protected String e;
    protected String r;

    public champions() {
        this(-1, "", "", "", "", "", "", "");
    }

    public champions(int codChamp, String nombre, String description, String p, String q, String w, String e, String r) {
        this.codChamp = codChamp;
        this.nombre = nombre;
        this.description = description;
        this.p = p;
        this.q = q;
        this.w = w;
        this.e = e;
        this.r = r;
    }

    public void setCodChamp(int codChamp) {
        this.codChamp = codChamp;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "champions{" + "codChamp=" + codChamp + ", nombre=" + nombre + ", descripcion=" + description + ", p=" + p + ", q=" + q + ", w=" + w + ", e=" + e + ", r=" + r + '}';
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
