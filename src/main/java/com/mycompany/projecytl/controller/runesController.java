/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.Enums.RuneType;
import com.mycompany.projecytl.Enums.RunesPrimary;
import com.mycompany.projecytl.Enums.SlotGeneral;
import com.mycompany.projecytl.Enums.buffsGeneral;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 *
 * @author AlbertoRS
 */
public class runesController extends ModalControllers implements Initializable {

    private boolean creating;

    @FXML
    public ComboBox<String> type;

    @FXML
    public ComboBox<String> rPrimary;

    @FXML
    public ComboBox<String> s1;

    @FXML
    public ComboBox<String> s2;

    @FXML
    public ComboBox<String> s3;

    @FXML
    public ComboBox<String> rSecondary;

    @FXML
    public ComboBox<String> s4;

    @FXML
    public ComboBox<String> s5;

    @FXML
    public ComboBox<String> b1;

    @FXML
    public ComboBox<String> b2;

    @FXML
    public ComboBox<String> b3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* if (type != null) {
            for (RuneType _type : RuneType.values()) {
                type.getItems().add(_type.getRune());
            }
        }*/
        selectTypeRune();
    }

    private ComboBox<String> selectTypeRune() {
        if (type != null) {
            for (RuneType _type : RuneType.values()) {
                type.getItems().add(_type.getRune());
            }
        }
        return type;
    }

    @FXML
    public void selectRunePrimary() {
        rSecondary.getItems().clear();
        selectRunesecondary();
        runesBuff1();
        runesBuff2();
        runesBuff3();
        switch (type.getValue()) {
            case "Precision":
                rPrimary.getItems().clear();
                runesPrecision();
                break;
            case "Domination":
                rPrimary.getItems().clear();
                runesDomination();
                break;
            case "Sorcery":
                rPrimary.getItems().clear();
                runesSorcery();
                break;
            case "Resolve":
                rPrimary.getItems().clear();
                runesResolve();
                break;
            case "Inspiration":
                rPrimary.getItems().clear();
                runesInspiration();
                break;
            default:
                System.out.println("Opción no encontrado");
        }
    }

    @FXML
    public void selectRuneSlots() {

        switch (type.getValue()) {
            case "Precision":
                s1.getItems().clear();
                runesSlot1Precision();
                s2.getItems().clear();
                runesSlot2Precision();
                s3.getItems().clear();
                runesSlot3Precision();
                break;
            case "Domination":
                s1.getItems().clear();
                runesSlot1Domination();
                s2.getItems().clear();
                runesSlot2Domination();
                s3.getItems().clear();
                runesSlot3Domination();
                break;
            case "Sorcery":
                s1.getItems().clear();
                runesSlot1Sorcery();
                s2.getItems().clear();
                runesSlot2Sorcery();
                s3.getItems().clear();
                runesSlot3Sorcery();
                break;
            case "Resolve":
                s1.getItems().clear();
                runesSlot1Resolve();
                s2.getItems().clear();
                runesSlot2Resolve();
                s3.getItems().clear();
                runesSlot3Resolve();
                break;
            case "Inspiration":
                s1.getItems().clear();
                runesSlot1Inspiration();
                s2.getItems().clear();
                runesSlot2Inspiration();
                s3.getItems().clear();
                runesSlot3Inspiration();
                break;
            default:
                System.out.println("Opción no encontrado");
        }
    }

    @FXML
    public void selectRunesecondary() {
        if (type != null) {
            for (RuneType _type : RuneType.values()) {
                if (type.getValue() != _type.getRune()) {
                    rSecondary.getItems().add(_type.getRune());
                }
            }
        }

    }

    private void selectsSlotsSecondarys() {
        for (SlotGeneral _type : SlotGeneral.values()) {
                s1.getItems().add(_type.getRune());
        }

    }

    private boolean runesPrecision() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (RunesPrimary _type : RunesPrimary.values()) {
                if (_type.getRune().equals(RunesPrimary.Conqueror.getRune())
                        || _type.getRune().equals(RunesPrimary.PressTheAttack.getRune())
                        || _type.getRune().equals(RunesPrimary.LethalTempo.getRune())
                        || _type.getRune().equals(RunesPrimary.FleetFootwork.getRune())) {
                    rPrimary.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesDomination() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (RunesPrimary _type : RunesPrimary.values()) {
                if (_type.getRune().equals(RunesPrimary.Electrocute.getRune())
                        || _type.getRune().equals(RunesPrimary.Predator.getRune())
                        || _type.getRune().equals(RunesPrimary.DarkHarvest.getRune())
                        || _type.getRune().equals(RunesPrimary.HailOfBlade.getRune())) {
                    rPrimary.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSorcery() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (RunesPrimary _type : RunesPrimary.values()) {
                if (_type.getRune().equals(RunesPrimary.SummonAery.getRune())
                        || _type.getRune().equals(RunesPrimary.ArcaneComet.getRune())
                        || _type.getRune().equals(RunesPrimary.PhaseRush.getRune())) {
                    rPrimary.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesResolve() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (RunesPrimary _type : RunesPrimary.values()) {
                if (_type.getRune().equals(RunesPrimary.GraspOfTheUndying.getRune())
                        || _type.getRune().equals(RunesPrimary.Aftershock.getRune())
                        || _type.getRune().equals(RunesPrimary.Guardian.getRune())) {
                    rPrimary.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesInspiration() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (RunesPrimary _type : RunesPrimary.values()) {
                if (_type.getRune().equals(RunesPrimary.GlacialAugment.getRune())
                        || _type.getRune().equals(RunesPrimary.UnsealedSpellbook.getRune())
                        || _type.getRune().equals(RunesPrimary.PrototypeVersatility.getRune())) {
                    rPrimary.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot1Precision() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Overheal.getRune())
                        || _type.getRune().equals(SlotGeneral.Triumph.getRune())
                        || _type.getRune().equals(SlotGeneral.PresenceOfMind.getRune())) {
                    s1.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot2Precision() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Promptness.getRune())
                        || _type.getRune().equals(SlotGeneral.Tenacity.getRune())
                        || _type.getRune().equals(SlotGeneral.Lineage.getRune())) {
                    s2.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot3Precision() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.CoupOfGrace.getRune())
                        || _type.getRune().equals(SlotGeneral.CutDown.getRune())
                        || _type.getRune().equals(SlotGeneral.LastStand.getRune())) {
                    s3.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot1Domination() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.CheapShot.getRune())
                        || _type.getRune().equals(SlotGeneral.TasteOfBlood.getRune())
                        || _type.getRune().equals(SlotGeneral.SuddenImpact.getRune())) {
                    s1.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot2Domination() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.ZombieWard.getRune())
                        || _type.getRune().equals(SlotGeneral.Tenacity.getRune())
                        || _type.getRune().equals(SlotGeneral.Lineage.getRune())) {
                    s2.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot3Domination() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.RavenousHunter.getRune())
                        || _type.getRune().equals(SlotGeneral.IngeniousHunter.getRune())
                        || _type.getRune().equals(SlotGeneral.RelentlessHunter.getRune())
                        || _type.getRune().equals(SlotGeneral.UltimateHunter.getRune())) {
                    s3.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot1Sorcery() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.NullifyingOrb.getRune())
                        || _type.getRune().equals(SlotGeneral.ManaflowBand.getRune())
                        || _type.getRune().equals(SlotGeneral.NimbusCloak.getRune())) {
                    s1.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot2Sorcery() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Transcendence.getRune())
                        || _type.getRune().equals(SlotGeneral.Celerity.getRune())
                        || _type.getRune().equals(SlotGeneral.AbsoluteFocus.getRune())) {
                    s2.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot3Sorcery() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Scorch.getRune())
                        || _type.getRune().equals(SlotGeneral.Waterwalking.getRune())
                        || _type.getRune().equals(SlotGeneral.GatheringStorm.getRune())) {
                    s3.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot1Resolve() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Demolish.getRune())
                        || _type.getRune().equals(SlotGeneral.FontOfLife.getRune())
                        || _type.getRune().equals(SlotGeneral.ShielBash.getRune())) {
                    s1.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot2Resolve() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Conditioning.getRune())
                        || _type.getRune().equals(SlotGeneral.Renewedforces.getRune())
                        || _type.getRune().equals(SlotGeneral.BonePlating.getRune())) {
                    s2.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot3Resolve() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Overgrowth.getRune())
                        || _type.getRune().equals(SlotGeneral.Revitalize.getRune())
                        || _type.getRune().equals(SlotGeneral.Unflinching.getRune())) {
                    s3.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot1Inspiration() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.HextechFlashtraption.getRune())
                        || _type.getRune().equals(SlotGeneral.MagicalFootwear.getRune())
                        || _type.getRune().equals(SlotGeneral.PerfectTiming.getRune())) {
                    s1.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot2Inspiration() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.FuturesMarket.getRune())
                        || _type.getRune().equals(SlotGeneral.MinionDematerializer.getRune())
                        || _type.getRune().equals(SlotGeneral.BiscuitDelivery.getRune())) {
                    s2.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesSlot3Inspiration() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.CosmicInsight.getRune())
                        || _type.getRune().equals(SlotGeneral.ApproachVelocity.getRune())
                        || _type.getRune().equals(SlotGeneral.TimeWarpTonic.getRune())) {
                    s3.getItems().add(_type.getRune());
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean runesBuff1() {
        boolean result = false;

        for (buffsGeneral _type : buffsGeneral.values()) {
            if (_type.getRune().equals(buffsGeneral.AdaptiveForce.getRune())
                    || _type.getRune().equals(buffsGeneral.AttackSpeed.getRune())
                    || _type.getRune().equals(buffsGeneral.CoolingReduction.getRune())) {
                b1.getItems().add(_type.getRune());
                result = true;
            }
        }

        return result;
    }

    private boolean runesBuff2() {
        boolean result = false;

        for (buffsGeneral _type : buffsGeneral.values()) {
            if (_type.getRune().equals(buffsGeneral.AdaptiveForce.getRune())
                    || _type.getRune().equals(buffsGeneral.Armor.getRune())
                    || _type.getRune().equals(buffsGeneral.MagicResistance.getRune())) {
                b2.getItems().add(_type.getRune());
                result = true;
            }
        }

        return result;
    }

    private boolean runesBuff3() {
        boolean result = false;

        for (buffsGeneral _type : buffsGeneral.values()) {
            if (_type.getRune().equals(buffsGeneral.Life.getRune())
                    || _type.getRune().equals(buffsGeneral.Armor.getRune())
                    || _type.getRune().equals(buffsGeneral.MagicResistance.getRune())) {
                b3.getItems().add(_type.getRune());
                result = true;
            }
        }

        return result;
    }

    @Override
    public void setParams(Object p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
