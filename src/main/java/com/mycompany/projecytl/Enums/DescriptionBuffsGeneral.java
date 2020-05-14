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
public enum DescriptionBuffsGeneral {
    AdaptiveForceDescription("5.4 bonus Attack Damage or 9 Ability Power (Adaptive)"),
    AttackSpeedDescription("10% bonus attack speed"),
    CoolingReductionDescription("1% − 10% (based on level) cooldown reduction"),
    ArmorDescription("6 bonus armor"),
    MagicResistanceDescription("8 bonus magic resistance"),
    LifeDescription("15 − 90 (based on level) bonus health");

    private String bg;

    private DescriptionBuffsGeneral(String bg) {
        this.bg = bg;
    }

    public String getRune() {
        return bg;
    }
}
