/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.model;

import java.util.ArrayList;

/**
 *
 * @author AlbertoRS
 */
public class build {

    private int codBuild;
    private champions c;
    private runes r;
    private ArrayList<items> it;

    public build() {
        this(-1, null, null, null);
    }

    public build(int codBuild, champions c, runes r, ArrayList<items> it) {
        this.codBuild = codBuild;
        this.c = c;
        this.r = r;
        this.it = it;
    }

    public int getCodBuild() {
        return codBuild;
    }

    public champions getC() {
        return c;
    }

    public void setC(champions c) {
        this.c = c;
    }

    public runes getR() {
        return r;
    }

    public void setR(runes r) {
        this.r = r;
    }

    public ArrayList<items> getIt() {
        return it;
    }

    public void setIt(ArrayList<items> it) {
        this.it = it;
    }

    @Override
    public String toString() {
        return "build{" + "codBuild=" + codBuild + ", c=" + c + ", r=" + r + ", it=" + it + '}';
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
                if (obj instanceof build) {
                    build n = (build) obj;
                    if (this.codBuild == n.getCodBuild()) {
                        igual = true;
                    }
                }
            }
        }
        return igual;
    }

}
