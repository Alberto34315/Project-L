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
public enum DescriptionRunesPrimary {
     //Precision
    ConquerorDescription("Ranged basic attacks on-hit against enemy champions grant 1 stack of Conqueror, while Melee role melee basic attacks on-hit grant 2 stacks. Abilities that deal damage to an enemy champion always grant 2 stacks."),
    PressTheAttackDescription("Basic attacks against enemy Champion icon champions apply stacks for 4 seconds. Attacking a new target removes all stacks from the previous target. The third stack consumes them all to deal 40 − 180 (based on level) bonus Attack damageAbility power Adaptive damage and makes them Exposed for 6 seconds, causing them to take 8% − 12% (based on level) increased damage from all subsequent sources (except from Hybrid penetration true damage)."),
    LethalTempoDescription("After 1.5 seconds upon damaging an enemy Champion icon champion you gain Attack speed icon 40% − 110% (based on level) bonus attack speed as well as have any bonus attack speed ignore the attack speed cap for 3 seconds. Attacking a champion while the effect is active will extend the duration to 6 seconds."),
    FleetFootworkDescription("Moving and basic attacking generates Energize stacks, up to 100. FLEET FOOTWORK: When fully Kircheis Shard item Energized, your next basic attack Heal power restores 3 − 60 (based on level) (Attack damage icon + 30% bonus AD) (Ability power icon + 30% AP) Health icon health and grants Movement speed icon 20% bonus movement speed for 1 second. On Ranged role ranged champions, the healing is only 20% effective versus Minion icon minions."),
    
    //Domination
    ElectrocuteDescription("Electrocute"),
    PredatorDescription("Predator"),
    DarkHarvestDescription("DarkHarvest"),
    HailOfBladeDescription("HailOfBlade"),
    
    //Sorcery
    SummonAeryDescription("SummonAery"),
    ArcaneCometDescription("ArcaneComet"),
    PhaseRushDescription("PhaseRush"),
    
    //Resolve
    GraspOfTheUndyingDescription("GraspOfTheUndying"),
    AftershockDescription("Aftershock"),
    GuardianDescription("Guardian"),
    
    //Inspiration
    GlacialAugmentDescription("GlacialAugment"),
    UnsealedSpellbookDescription("UnsealedSpellbook"),
    PrototypeVersatilityDescription("PrototypeVersatility");
    private String ru;

    private DescriptionRunesPrimary(String r) {
        this.ru = r;
    }

    public String getRune() {
        return ru;
    }

}
