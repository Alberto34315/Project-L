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
public class participates {

    protected int codGame;
    protected int codRune;
    protected int codChamp;

    public participates() {
        this.codGame = -1;
        this.codRune = -1;
        this.codChamp = -1;
    }

    public participates(int codGame, int codRune, int codChamp) {
        this.codGame = codGame;
        this.codRune = codRune;
        this.codChamp = codChamp;
    }

    public int getCodGame() {
        return codGame;
    }

    public void setCodGame(int codGame) {
        this.codGame = codGame;
    }

    public int getCodRune() {
        return codRune;
    }

    public void setCodRune(int codRune) {
        this.codRune = codRune;
    }

    public int getCodChamp() {
        return codChamp;
    }

    public void setCodChamp(int codChamp) {
        this.codChamp = codChamp;
    }

    @Override
    public String toString() {
        return "participates{" + "codGame=" + codGame + ", codRune=" + codRune + ", codChamp=" + codChamp + '}';
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
                if (obj instanceof runes) {
                    participates n = (participates) obj;
                    if (this.codRune == n.getCodRune() && this.codChamp == n.getCodChamp() && this.codGame == n.getCodGame()) {
                        igual = true;
                    }
                }
            }
        }
        return igual;
    }

}
