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
public enum DescriptionRuneType {
    PrecisionDescription("Improved attacks and sustained damage"),
    DominationDescription("Burst damage and target access"),
    SorceryDescription("Empowered abilities and resource manipulation"),
    ResolveDescription("Durability and crowd control"),
    InspirationDescription("Creative tools and rule bending");
   
private String ru;

private DescriptionRuneType(String r) {
 this.ru=r;
 }

    public String getRune() {
        return ru;
    }
     
}