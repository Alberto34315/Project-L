/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.model;

import com.mycompany.projecytl.Enums.RuneType;
import com.mycompany.projecytl.Enums.RunesPrimary;
import com.mycompany.projecytl.Enums.SlotGeneral;
import com.mycompany.projecytl.Enums.buffsGeneral;

/**
 *
 * @author AlbertoRS
 */
public class runes {
   
    protected int codRune;
    protected RuneType type;
    protected String descriptionType;
    protected RunesPrimary r1;
    protected String descriptionRunesPrimary;
    protected SlotGeneral s1;
    protected String descriptionS1;
    protected SlotGeneral s2;
    protected String descriptionS2;
    protected SlotGeneral s3;
    protected String descriptionS3;
    protected RunesPrimary r2;
    protected String descriptionRunesSecondary;
    protected SlotGeneral s4;
    protected String descriptionS4;
    protected SlotGeneral s5;
    protected String descriptionS5;
    protected buffsGeneral b1;
    protected String descriptionB1;
    protected buffsGeneral b2;
    protected String descriptionB2;
    protected buffsGeneral b3;
    protected String descriptionB3;

    public runes() {
        this(-1,null,"",null,"",null,"",null,"",null,"",null,"",null,"",null,"",null,"",null,"",null,"");
    }

    public runes(int codRune, RuneType type, String descriptionType, RunesPrimary r1, String descriptionRunesPrimary, SlotGeneral s1, String descriptionS1, SlotGeneral s2, String descriptionS2, SlotGeneral s3, String descriptionS3, RunesPrimary r2, String descriptionRunesSecondary, SlotGeneral s4, String descriptionS4, SlotGeneral s5, String descriptionS5, buffsGeneral b1, String descriptionB1, buffsGeneral b2, String descriptionB2, buffsGeneral b3, String descriptionB3) {
        this.codRune = codRune;
        this.type = type;
        this.descriptionType = descriptionType;
        this.r1 = r1;
        this.descriptionRunesPrimary = descriptionRunesPrimary;
        this.s1 = s1;
        this.descriptionS1 = descriptionS1;
        this.s2 = s2;
        this.descriptionS2 = descriptionS2;
        this.s3 = s3;
        this.descriptionS3 = descriptionS3;
        this.r2 = r2;
        this.descriptionRunesSecondary = descriptionRunesSecondary;
        this.s4 = s4;
        this.descriptionS4 = descriptionS4;
        this.s5 = s5;
        this.descriptionS5 = descriptionS5;
        this.b1 = b1;
        this.descriptionB1 = descriptionB1;
        this.b2 = b2;
        this.descriptionB2 = descriptionB2;
        this.b3 = b3;
        this.descriptionB3 = descriptionB3;
    }

    public int getCodRune() {
        return codRune;
    }

    public void setCodRune(int codRune) {
        this.codRune = codRune;
    }

    public RuneType getType() {
        return type;
    }

    public void setType(RuneType type) {
        this.type = type;
    }

    public String getDescriptionType() {
        return descriptionType;
    }

    public void setDescriptionType(String descriptionType) {
        this.descriptionType = descriptionType;
    }

    public RunesPrimary getR1() {
        return r1;
    }

    public void setR1(RunesPrimary r1) {
        this.r1 = r1;
    }

    public String getDescriptionRunesPrimary() {
        return descriptionRunesPrimary;
    }

    public void setDescriptionRunesPrimary(String descriptionRunesPrimary) {
        this.descriptionRunesPrimary = descriptionRunesPrimary;
    }

    public SlotGeneral getS1() {
        return s1;
    }

    public void setS1(SlotGeneral s1) {
        this.s1 = s1;
    }

    public String getDescriptionS1() {
        return descriptionS1;
    }

    public void setDescriptionS1(String descriptionS1) {
        this.descriptionS1 = descriptionS1;
    }

    public SlotGeneral getS2() {
        return s2;
    }

    public void setS2(SlotGeneral s2) {
        this.s2 = s2;
    }

    public String getDescriptionS2() {
        return descriptionS2;
    }

    public void setDescriptionS2(String descriptionS2) {
        this.descriptionS2 = descriptionS2;
    }

    public SlotGeneral getS3() {
        return s3;
    }

    public void setS3(SlotGeneral s3) {
        this.s3 = s3;
    }

    public String getDescriptionS3() {
        return descriptionS3;
    }

    public void setDescriptionS3(String descriptionS3) {
        this.descriptionS3 = descriptionS3;
    }

    public RunesPrimary getR2() {
        return r2;
    }

    public void setR2(RunesPrimary r2) {
        this.r2 = r2;
    }

    public String getDescriptionRunesSecondary() {
        return descriptionRunesSecondary;
    }

    public void setDescriptionRunesSecondary(String descriptionRunesSecondary) {
        this.descriptionRunesSecondary = descriptionRunesSecondary;
    }

    public SlotGeneral getS4() {
        return s4;
    }

    public void setS4(SlotGeneral s4) {
        this.s4 = s4;
    }

    public String getDescriptionS4() {
        return descriptionS4;
    }

    public void setDescriptionS4(String descriptionS4) {
        this.descriptionS4 = descriptionS4;
    }

    public SlotGeneral getS5() {
        return s5;
    }

    public void setS5(SlotGeneral s5) {
        this.s5 = s5;
    }

    public String getDescriptionS5() {
        return descriptionS5;
    }

    public void setDescriptionS5(String descriptionS5) {
        this.descriptionS5 = descriptionS5;
    }

    public buffsGeneral getB1() {
        return b1;
    }

    public void setB1(buffsGeneral b1) {
        this.b1 = b1;
    }

    public String getDescriptionB1() {
        return descriptionB1;
    }

    public void setDescriptionB1(String descriptionB1) {
        this.descriptionB1 = descriptionB1;
    }

    public buffsGeneral getB2() {
        return b2;
    }

    public void setB2(buffsGeneral b2) {
        this.b2 = b2;
    }

    public String getDescriptionB2() {
        return descriptionB2;
    }

    public void setDescriptionB2(String descriptionB2) {
        this.descriptionB2 = descriptionB2;
    }

    public buffsGeneral getB3() {
        return b3;
    }

    public void setB3(buffsGeneral b3) {
        this.b3 = b3;
    }

    public String getDescriptionB3() {
        return descriptionB3;
    }

    public void setDescriptionB3(String descriptionB3) {
        this.descriptionB3 = descriptionB3;
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
                    runes n = (runes) obj;
                    if (this.codRune == n.getCodRune()) {
                        igual = true;
                    }
                }
            }
        }
        return igual;
    }

}
