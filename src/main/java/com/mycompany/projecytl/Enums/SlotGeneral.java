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
public enum SlotGeneral {
    //Slot1
    //Precision 
    Overheal("Overheal"),
    Triumph("Triumph"),
    PresenceOfMind("PresenceOfMind"),
    //Domination
    CheapShot("CheapShot"),
    TasteOfBlood("TasteOfBlood"),
    SuddenImpact("SuddenImpact"),
    //Sorcery
    NullifyingOrb("NullifyingOrb"),
    ManaflowBand("ManaflowBand"),
    NimbusCloak("NimbusCloak"),
    //Resolve
    Demolish("Demolish"),
    FontOfLife("FontOfLife"),
    ShielBash("ShielBash"),
    //Inspiration
    HextechFlashtraption("HextechFlashtraption"),
    MagicalFootwear("MagicalFootwear"),
    PerfectTiming("PerfectTiming"),
    
    //Slot2
    //Precision
    Promptness("Promptness"),
    Tenacity("Tenacity"),
    Lineage("Lineage"),
    //Domination
    ZombieWard("ZombieWard"),
    GhostPoro("GhostPoro"),
    EyeballCollection("EyeballCollection"),
    //Sorcery
    Transcendence("Transcendence"),
    Celerity("Celerity"),
    AbsoluteFocus("AbsoluteFocus"),
    //Resolve
    Conditioning("Conditioning"),
    Renewedforces("Renewedforces"),
    BonePlating("BonePlating"),
    //Inspiration
    FuturesMarket("FuturesMarket"),
    MinionDematerializer("MinionDematerializer"),
    BiscuitDelivery("BiscuitDelivery"),

    //Slot3
    //Precision
    CoupOfGrace("CoupOfGrace"),
    CutDown("CutDown"),
    LastStand("LastStand"),
    //Domination
    RavenousHunter("RavenousHunter"),
    IngeniousHunter("IngeniousHunter"),
    RelentlessHunter("RelentlessHunter"),
    UltimateHunter("UltimateHunter"),
    //Sorcery
    Scorch("Scorch"),
    Waterwalking("Waterwalking"),
    GatheringStorm("GatheringStorm"),
    //Resolve
    Overgrowth("Overgrowth"),
    Revitalize("Revitalize"),
    Unflinching("Unflinching"),
    //Inspiration
    CosmicInsight("CosmicInsight"),
    ApproachVelocity("ApproachVelocity"),
    TimeWarpTonic("TimeWarpTonic");
	
	   private String sg;

private SlotGeneral(String sg) {
 this.sg=sg;
 }

    public String getRune() {
        return sg;
    }
    
}
