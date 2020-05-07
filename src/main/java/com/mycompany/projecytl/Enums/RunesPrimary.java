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
public enum RunesPrimary {
    //Precision
    Conqueror("Conqueror"),
    PressTheAttack("PressTheAttack"),
    LethalTempo("LethalTempo"),
    FleetFootwork("FleetFootwork"),
    
    //Domination
    Electrocute("Electrocute"),
    Predator("Predator"),
    DarkHarvest("DarkHarvest"),
    HailOfBlade("HailOfBlade"),
    
    //Sorcery
    SummonAery("SummonAery"),
    ArcaneComet("ArcaneComet"),
    PhaseRush("PhaseRush"),
    
    //Resolve
    GraspOfTheUndying("GraspOfTheUndying"),
    Aftershock("Aftershock"),
    Guardian("Guardian"),
    
    //Inspiration
    GlacialAugment("GlacialAugment"),
    UnsealedSpellbook("UnsealedSpellbook"),
    PrototypeVersatility("PrototypeVersatility");
    
    private String rp;

private RunesPrimary(String rp) {
 this.rp=rp;
 }

    public String getRune() {
        return rp;
    }
    
    
}
