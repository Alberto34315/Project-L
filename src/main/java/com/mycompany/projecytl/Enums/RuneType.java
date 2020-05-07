/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.Enums;

/**
 *
 * @author AlbertoRS
 */
public enum RuneType {
    Precision("Precision"),
    Domination("Domination"),
    Sorcery("Sorcery"),
    Resolve("Resolve"),
    Inspiration("Inspiration");
   
private String ru;

private RuneType(String r) {
 this.ru=r;
 }

    public String getRune() {
        return ru;
    }
     
}