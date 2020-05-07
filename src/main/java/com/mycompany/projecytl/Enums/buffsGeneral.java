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
public enum buffsGeneral {
    AdaptiveForce("AdaptiveForce"),
    AttackSpeed("AttackSpeed"),
    CoolingReduction("CoolingReduction"),
    Armor("Armor"),
    MagicResistance("MagicResistance"),
    Life("Life");
	
	   private String bg;

private buffsGeneral(String bg) {
 this.bg=bg;
 }

    public String getRune() {
        return bg;
    }
}
