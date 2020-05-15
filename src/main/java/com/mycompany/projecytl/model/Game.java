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
public class Game {

    private int codGame;

    public Game() {
        this.codGame=-1;
    }

    public Game(int codGame) {
        this.codGame = codGame;
    }

    public int getCodGame() {
        return codGame;
    }

    public void setCodGame(int codGame) {
        this.codGame = codGame;
    }

    @Override
    public String toString() {
        return "Game{" + "codGame=" + codGame + '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean igual = false;
        if (obj != null) {
            if (this == obj) {
                igual = true;
            } else {
                if (obj instanceof runes) {
                    Game g = (Game) obj;
                    if (this.codGame == g.getCodGame()) {
                        igual = true;
                    }
                }
            }
        }
        return igual;
    }

}
