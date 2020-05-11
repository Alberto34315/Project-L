/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.Enums.DescriptionRuneType;
import com.mycompany.projecytl.Enums.RuneType;
import com.mycompany.projecytl.Enums.RunesPrimary;
import com.mycompany.projecytl.Enums.SlotGeneral;
import com.mycompany.projecytl.Enums.buffsGeneral;
import com.mycompany.projecytl.Utils.MapEntry;
import com.mycompany.projecytl.model.runes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author AlbertoRS
 */
public class runesController extends ModalControllers implements Initializable {

    private boolean creating;
    private runes r;
    private RuneType rT;
    private RunesPrimary rP;
    private SlotGeneral sG;
    private buffsGeneral bG;

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

    @FXML
    private TextArea L_Type;

    @FXML
    public Label L_RPrimary;

    @FXML
    private Label L_S1;

    @FXML
    private Label L_S2;

    @FXML
    private Label L_S3;

    @FXML
    public Label L_RSecondary;

    @FXML
    private Label L_S4;

    @FXML
    private Label L_S5;

    @FXML
    private Label L_B1;

    @FXML
    private Label L_B2;

    @FXML
    private Label L_B3;

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
        addDescriptionRunesType();
        rSecondary.getItems().clear();
        selectRunesecondary();

        b1.getItems().clear();
        runesBuff1();
        b2.getItems().clear();
        runesBuff2();
        b3.getItems().clear();
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

    public void selectRunesecondary() {
        if (type != null) {
            for (RuneType _type : RuneType.values()) {
                if (type.getValue() != _type.getRune()) {
                    rSecondary.getItems().add(_type.getRune());
                }
            }
        }

    }

    @FXML
    private void selectsSlotsSecondarys4() {
        s4.getItems().clear();
        runesSlot4();
    }

    @FXML
    private void selectsSlotsSecondarys5() {
        s5.getItems().clear();
        runesSlot5();
    }

    private void runesSlot4() {
        switch (rSecondary.getValue()) {
            case "Precision":
                s4.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Precision.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.Overheal.getRune())
                                || _type.getRune().equals(SlotGeneral.Triumph.getRune())
                                || _type.getRune().equals(SlotGeneral.PresenceOfMind.getRune())
                                || _type.getRune().equals(SlotGeneral.Promptness.getRune())
                                || _type.getRune().equals(SlotGeneral.Tenacity.getRune())
                                || _type.getRune().equals(SlotGeneral.Lineage.getRune())
                                || _type.getRune().equals(SlotGeneral.CoupOfGrace.getRune())
                                || _type.getRune().equals(SlotGeneral.CutDown.getRune())
                                || _type.getRune().equals(SlotGeneral.LastStand.getRune())) {

                            s4.getItems().add(_type.getRune());

                        }
                    }
                }
                break;
            case "Domination":
                s4.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Domination.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.CheapShot.getRune())
                                || _type.getRune().equals(SlotGeneral.TasteOfBlood.getRune())
                                || _type.getRune().equals(SlotGeneral.SuddenImpact.getRune())
                                || _type.getRune().equals(SlotGeneral.ZombieWard.getRune())
                                || _type.getRune().equals(SlotGeneral.Tenacity.getRune())
                                || _type.getRune().equals(SlotGeneral.Lineage.getRune())
                                || _type.getRune().equals(SlotGeneral.RavenousHunter.getRune())
                                || _type.getRune().equals(SlotGeneral.IngeniousHunter.getRune())
                                || _type.getRune().equals(SlotGeneral.RelentlessHunter.getRune())
                                || _type.getRune().equals(SlotGeneral.UltimateHunter.getRune())) {

                            s4.getItems().add(_type.getRune());
                        }
                    }
                }
                break;
            case "Sorcery":
                s4.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Sorcery.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.NullifyingOrb.getRune())
                                || _type.getRune().equals(SlotGeneral.ManaflowBand.getRune())
                                || _type.getRune().equals(SlotGeneral.NimbusCloak.getRune())
                                || _type.getRune().equals(SlotGeneral.Transcendence.getRune())
                                || _type.getRune().equals(SlotGeneral.Celerity.getRune())
                                || _type.getRune().equals(SlotGeneral.AbsoluteFocus.getRune())
                                || _type.getRune().equals(SlotGeneral.Scorch.getRune())
                                || _type.getRune().equals(SlotGeneral.Waterwalking.getRune())
                                || _type.getRune().equals(SlotGeneral.GatheringStorm.getRune())) {

                            s4.getItems().add(_type.getRune());

                        }
                    }
                }
                break;

            case "Resolve":
                s4.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Resolve.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.Demolish.getRune())
                                || _type.getRune().equals(SlotGeneral.FontOfLife.getRune())
                                || _type.getRune().equals(SlotGeneral.ShielBash.getRune())
                                || _type.getRune().equals(SlotGeneral.Conditioning.getRune())
                                || _type.getRune().equals(SlotGeneral.Renewedforces.getRune())
                                || _type.getRune().equals(SlotGeneral.BonePlating.getRune())
                                || _type.getRune().equals(SlotGeneral.Overgrowth.getRune())
                                || _type.getRune().equals(SlotGeneral.Revitalize.getRune())
                                || _type.getRune().equals(SlotGeneral.Unflinching.getRune())) {

                            s4.getItems().add(_type.getRune());

                        }
                    }
                }
                break;

            case "Inspiration":
                s4.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Inspiration.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.HextechFlashtraption.getRune())
                                || _type.getRune().equals(SlotGeneral.MagicalFootwear.getRune())
                                || _type.getRune().equals(SlotGeneral.PerfectTiming.getRune())
                                || _type.getRune().equals(SlotGeneral.FuturesMarket.getRune())
                                || _type.getRune().equals(SlotGeneral.MinionDematerializer.getRune())
                                || _type.getRune().equals(SlotGeneral.BiscuitDelivery.getRune())
                                || _type.getRune().equals(SlotGeneral.CosmicInsight.getRune())
                                || _type.getRune().equals(SlotGeneral.ApproachVelocity.getRune())
                                || _type.getRune().equals(SlotGeneral.TimeWarpTonic.getRune())) {

                            s4.getItems().add(_type.getRune());

                        }
                    }
                }
                break;
            default:
                System.out.println("Opción no encontrado");
        }
    }

    private void runesSlot5() {
        switch (rSecondary.getValue()) {
            case "Precision":
                s5.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Precision.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.Overheal.getRune()) && s4.getValue() != SlotGeneral.Overheal.getRune() && s4.getValue() != SlotGeneral.Triumph.getRune() && s4.getValue() != SlotGeneral.PresenceOfMind.getRune()
                                || _type.getRune().equals(SlotGeneral.Triumph.getRune()) && s4.getValue() != SlotGeneral.Triumph.getRune() && s4.getValue() != SlotGeneral.Overheal.getRune() && s4.getValue() != SlotGeneral.PresenceOfMind.getRune()
                                || _type.getRune().equals(SlotGeneral.PresenceOfMind.getRune()) && s4.getValue() != SlotGeneral.PresenceOfMind.getRune() && s4.getValue() != SlotGeneral.Triumph.getRune() && s4.getValue() != SlotGeneral.Overheal.getRune()
                                || _type.getRune().equals(SlotGeneral.Promptness.getRune()) && s4.getValue() != SlotGeneral.Promptness.getRune() && s4.getValue() != SlotGeneral.Tenacity.getRune() && s4.getValue() != SlotGeneral.Lineage.getRune()
                                || _type.getRune().equals(SlotGeneral.Tenacity.getRune()) && s4.getValue() != SlotGeneral.Tenacity.getRune() && s4.getValue() != SlotGeneral.Promptness.getRune() && s4.getValue() != SlotGeneral.Lineage.getRune()
                                || _type.getRune().equals(SlotGeneral.Lineage.getRune()) && s4.getValue() != SlotGeneral.Lineage.getRune() && s4.getValue() != SlotGeneral.Tenacity.getRune() && s4.getValue() != SlotGeneral.Promptness.getRune()
                                || _type.getRune().equals(SlotGeneral.CoupOfGrace.getRune()) && s4.getValue() != SlotGeneral.CoupOfGrace.getRune() && s4.getValue() != SlotGeneral.CutDown.getRune() && s4.getValue() != SlotGeneral.LastStand.getRune()
                                || _type.getRune().equals(SlotGeneral.CutDown.getRune()) && s4.getValue() != SlotGeneral.CutDown.getRune() && s4.getValue() != SlotGeneral.CoupOfGrace.getRune() && s4.getValue() != SlotGeneral.LastStand.getRune()
                                || _type.getRune().equals(SlotGeneral.LastStand.getRune()) && s4.getValue() != SlotGeneral.LastStand.getRune() && s4.getValue() != SlotGeneral.CoupOfGrace.getRune() && s4.getValue() != SlotGeneral.CutDown.getRune()) {

                            s5.getItems().add(_type.getRune());

                        }
                    }
                }
                break;
            case "Domination":
                s5.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Domination.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.CheapShot.getRune()) && s4.getValue() != SlotGeneral.CheapShot.getRune() && s4.getValue() != SlotGeneral.TasteOfBlood.getRune() && s4.getValue() != SlotGeneral.SuddenImpact.getRune()
                                || _type.getRune().equals(SlotGeneral.TasteOfBlood.getRune()) && s4.getValue() != SlotGeneral.CheapShot.getRune() && s4.getValue() != SlotGeneral.TasteOfBlood.getRune() && s4.getValue() != SlotGeneral.SuddenImpact.getRune()
                                || _type.getRune().equals(SlotGeneral.SuddenImpact.getRune()) && s4.getValue() != SlotGeneral.CheapShot.getRune() && s4.getValue() != SlotGeneral.TasteOfBlood.getRune() && s4.getValue() != SlotGeneral.SuddenImpact.getRune()
                                || _type.getRune().equals(SlotGeneral.ZombieWard.getRune()) && s4.getValue() != SlotGeneral.ZombieWard.getRune() && s4.getValue() != SlotGeneral.GhostPoro.getRune() && s4.getValue() != SlotGeneral.EyeballCollection.getRune()
                                || _type.getRune().equals(SlotGeneral.GhostPoro.getRune()) && s4.getValue() != SlotGeneral.ZombieWard.getRune() && s4.getValue() != SlotGeneral.GhostPoro.getRune() && s4.getValue() != SlotGeneral.EyeballCollection.getRune()
                                || _type.getRune().equals(SlotGeneral.EyeballCollection.getRune()) && s4.getValue() != SlotGeneral.ZombieWard.getRune() && s4.getValue() != SlotGeneral.GhostPoro.getRune() && s4.getValue() != SlotGeneral.EyeballCollection.getRune()
                                || _type.getRune().equals(SlotGeneral.RavenousHunter.getRune()) && s4.getValue() != SlotGeneral.RavenousHunter.getRune() && s4.getValue() != SlotGeneral.IngeniousHunter.getRune() && s4.getValue() != SlotGeneral.RelentlessHunter.getRune() && s4.getValue() != SlotGeneral.UltimateHunter.getRune()
                                || _type.getRune().equals(SlotGeneral.IngeniousHunter.getRune()) && s4.getValue() != SlotGeneral.RavenousHunter.getRune() && s4.getValue() != SlotGeneral.IngeniousHunter.getRune() && s4.getValue() != SlotGeneral.RelentlessHunter.getRune() && s4.getValue() != SlotGeneral.UltimateHunter.getRune()
                                || _type.getRune().equals(SlotGeneral.RelentlessHunter.getRune()) && s4.getValue() != SlotGeneral.RavenousHunter.getRune() && s4.getValue() != SlotGeneral.IngeniousHunter.getRune() && s4.getValue() != SlotGeneral.RelentlessHunter.getRune() && s4.getValue() != SlotGeneral.UltimateHunter.getRune()
                                || _type.getRune().equals(SlotGeneral.UltimateHunter.getRune()) && s4.getValue() != SlotGeneral.RavenousHunter.getRune() && s4.getValue() != SlotGeneral.IngeniousHunter.getRune() && s4.getValue() != SlotGeneral.RelentlessHunter.getRune() && s4.getValue() != SlotGeneral.UltimateHunter.getRune()) {

                            s5.getItems().add(_type.getRune());

                        }
                    }
                }
                break;
            case "Sorcery":
                s5.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Sorcery.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.NullifyingOrb.getRune()) && s4.getValue() != SlotGeneral.NullifyingOrb.getRune() && s4.getValue() != SlotGeneral.ManaflowBand.getRune() && s4.getValue() != SlotGeneral.NimbusCloak.getRune()
                                || _type.getRune().equals(SlotGeneral.ManaflowBand.getRune()) && s4.getValue() != SlotGeneral.NullifyingOrb.getRune() && s4.getValue() != SlotGeneral.ManaflowBand.getRune() && s4.getValue() != SlotGeneral.NimbusCloak.getRune()
                                || _type.getRune().equals(SlotGeneral.NimbusCloak.getRune()) && s4.getValue() != SlotGeneral.NullifyingOrb.getRune() && s4.getValue() != SlotGeneral.ManaflowBand.getRune() && s4.getValue() != SlotGeneral.NimbusCloak.getRune()
                                || _type.getRune().equals(SlotGeneral.Transcendence.getRune()) && s4.getValue() != SlotGeneral.Transcendence.getRune() && s4.getValue() != SlotGeneral.Celerity.getRune() && s4.getValue() != SlotGeneral.AbsoluteFocus.getRune()
                                || _type.getRune().equals(SlotGeneral.Celerity.getRune()) && s4.getValue() != SlotGeneral.Transcendence.getRune() && s4.getValue() != SlotGeneral.Celerity.getRune() && s4.getValue() != SlotGeneral.AbsoluteFocus.getRune()
                                || _type.getRune().equals(SlotGeneral.AbsoluteFocus.getRune()) && s4.getValue() != SlotGeneral.Transcendence.getRune() && s4.getValue() != SlotGeneral.Celerity.getRune() && s4.getValue() != SlotGeneral.AbsoluteFocus.getRune()
                                || _type.getRune().equals(SlotGeneral.Scorch.getRune()) && s4.getValue() != SlotGeneral.Scorch.getRune() && s4.getValue() != SlotGeneral.Waterwalking.getRune() && s4.getValue() != SlotGeneral.GatheringStorm.getRune()
                                || _type.getRune().equals(SlotGeneral.Waterwalking.getRune()) && s4.getValue() != SlotGeneral.Scorch.getRune() && s4.getValue() != SlotGeneral.Waterwalking.getRune() && s4.getValue() != SlotGeneral.GatheringStorm.getRune()
                                || _type.getRune().equals(SlotGeneral.GatheringStorm.getRune()) && s4.getValue() != SlotGeneral.Scorch.getRune() && s4.getValue() != SlotGeneral.Waterwalking.getRune() && s4.getValue() != SlotGeneral.GatheringStorm.getRune()) {

                            s5.getItems().add(_type.getRune());

                        }
                    }
                }
                break;

            case "Resolve":
                s5.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Resolve.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.Demolish.getRune()) && s4.getValue() != SlotGeneral.Demolish.getRune() && s4.getValue() != SlotGeneral.FontOfLife.getRune() && s4.getValue() != SlotGeneral.ShielBash.getRune()
                                || _type.getRune().equals(SlotGeneral.FontOfLife.getRune()) && s4.getValue() != SlotGeneral.Demolish.getRune() && s4.getValue() != SlotGeneral.FontOfLife.getRune() && s4.getValue() != SlotGeneral.ShielBash.getRune()
                                || _type.getRune().equals(SlotGeneral.ShielBash.getRune()) && s4.getValue() != SlotGeneral.Demolish.getRune() && s4.getValue() != SlotGeneral.FontOfLife.getRune() && s4.getValue() != SlotGeneral.ShielBash.getRune()
                                || _type.getRune().equals(SlotGeneral.Conditioning.getRune()) && s4.getValue() != SlotGeneral.Conditioning.getRune() && s4.getValue() != SlotGeneral.Renewedforces.getRune() && s4.getValue() != SlotGeneral.BonePlating.getRune()
                                || _type.getRune().equals(SlotGeneral.Renewedforces.getRune()) && s4.getValue() != SlotGeneral.Conditioning.getRune() && s4.getValue() != SlotGeneral.Renewedforces.getRune() && s4.getValue() != SlotGeneral.BonePlating.getRune()
                                || _type.getRune().equals(SlotGeneral.BonePlating.getRune()) && s4.getValue() != SlotGeneral.Conditioning.getRune() && s4.getValue() != SlotGeneral.Renewedforces.getRune() && s4.getValue() != SlotGeneral.BonePlating.getRune()
                                || _type.getRune().equals(SlotGeneral.Overgrowth.getRune()) && s4.getValue() != SlotGeneral.Overgrowth.getRune() && s4.getValue() != SlotGeneral.Revitalize.getRune() && s4.getValue() != SlotGeneral.Unflinching.getRune()
                                || _type.getRune().equals(SlotGeneral.Revitalize.getRune()) && s4.getValue() != SlotGeneral.Overgrowth.getRune() && s4.getValue() != SlotGeneral.Revitalize.getRune() && s4.getValue() != SlotGeneral.Unflinching.getRune()
                                || _type.getRune().equals(SlotGeneral.Unflinching.getRune()) && s4.getValue() != SlotGeneral.Overgrowth.getRune() && s4.getValue() != SlotGeneral.Revitalize.getRune() && s4.getValue() != SlotGeneral.Unflinching.getRune()) {

                            s5.getItems().add(_type.getRune());

                        }
                    }
                }
                break;

            case "Inspiration":
                s5.getItems().clear();
                if (rSecondary.getValue().equals(RuneType.Inspiration.getRune())) {
                    for (SlotGeneral _type : SlotGeneral.values()) {
                        if (_type.getRune().equals(SlotGeneral.HextechFlashtraption.getRune()) && s4.getValue() != SlotGeneral.HextechFlashtraption.getRune() && s4.getValue() != SlotGeneral.MagicalFootwear.getRune() && s4.getValue() != SlotGeneral.PerfectTiming.getRune()
                                || _type.getRune().equals(SlotGeneral.MagicalFootwear.getRune()) && s4.getValue() != SlotGeneral.HextechFlashtraption.getRune() && s4.getValue() != SlotGeneral.MagicalFootwear.getRune() && s4.getValue() != SlotGeneral.PerfectTiming.getRune()
                                || _type.getRune().equals(SlotGeneral.PerfectTiming.getRune()) && s4.getValue() != SlotGeneral.HextechFlashtraption.getRune() && s4.getValue() != SlotGeneral.MagicalFootwear.getRune() && s4.getValue() != SlotGeneral.PerfectTiming.getRune()
                                || _type.getRune().equals(SlotGeneral.FuturesMarket.getRune()) && s4.getValue() != SlotGeneral.FuturesMarket.getRune() && s4.getValue() != SlotGeneral.MinionDematerializer.getRune() && s4.getValue() != SlotGeneral.BiscuitDelivery.getRune()
                                || _type.getRune().equals(SlotGeneral.MinionDematerializer.getRune()) && s4.getValue() != SlotGeneral.FuturesMarket.getRune() && s4.getValue() != SlotGeneral.MinionDematerializer.getRune() && s4.getValue() != SlotGeneral.BiscuitDelivery.getRune()
                                || _type.getRune().equals(SlotGeneral.BiscuitDelivery.getRune()) && s4.getValue() != SlotGeneral.FuturesMarket.getRune() && s4.getValue() != SlotGeneral.MinionDematerializer.getRune() && s4.getValue() != SlotGeneral.BiscuitDelivery.getRune()
                                || _type.getRune().equals(SlotGeneral.CosmicInsight.getRune()) && s4.getValue() != SlotGeneral.CosmicInsight.getRune() && s4.getValue() != SlotGeneral.ApproachVelocity.getRune() && s4.getValue() != SlotGeneral.TimeWarpTonic.getRune()
                                || _type.getRune().equals(SlotGeneral.ApproachVelocity.getRune()) && s4.getValue() != SlotGeneral.CosmicInsight.getRune() && s4.getValue() != SlotGeneral.ApproachVelocity.getRune() && s4.getValue() != SlotGeneral.TimeWarpTonic.getRune()
                                || _type.getRune().equals(SlotGeneral.TimeWarpTonic.getRune()) && s4.getValue() != SlotGeneral.CosmicInsight.getRune() && s4.getValue() != SlotGeneral.ApproachVelocity.getRune() && s4.getValue() != SlotGeneral.TimeWarpTonic.getRune()) {

                            s5.getItems().add(_type.getRune());

                        }
                    }
                }
                break;
            default:
                System.out.println("Opción no encontrado");
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

    private ComboBox<String> runesSlot1Precision() {

        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Overheal.getRune())
                        || _type.getRune().equals(SlotGeneral.Triumph.getRune())
                        || _type.getRune().equals(SlotGeneral.PresenceOfMind.getRune())) {
                    s1.getItems().add(_type.getRune());

                }
            }
        }
        return s1;
    }

    private ComboBox<String> runesSlot2Precision() {

        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Promptness.getRune())
                        || _type.getRune().equals(SlotGeneral.Tenacity.getRune())
                        || _type.getRune().equals(SlotGeneral.Lineage.getRune())) {
                    s2.getItems().add(_type.getRune());

                }
            }
        }
        return s2;
    }

    private ComboBox<String> runesSlot3Precision() {

        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.CoupOfGrace.getRune())
                        || _type.getRune().equals(SlotGeneral.CutDown.getRune())
                        || _type.getRune().equals(SlotGeneral.LastStand.getRune())) {
                    s3.getItems().add(_type.getRune());

                }
            }
        }
        return s3;
    }

    private ComboBox<String> runesSlot1Domination() {

        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.CheapShot.getRune())
                        || _type.getRune().equals(SlotGeneral.TasteOfBlood.getRune())
                        || _type.getRune().equals(SlotGeneral.SuddenImpact.getRune())) {
                    s1.getItems().add(_type.getRune());

                }
            }
        }
        return s1;
    }

    private ComboBox<String> runesSlot2Domination() {

        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.ZombieWard.getRune())
                        || _type.getRune().equals(SlotGeneral.Tenacity.getRune())
                        || _type.getRune().equals(SlotGeneral.Lineage.getRune())) {
                    s2.getItems().add(_type.getRune());

                }
            }
        }
        return s2;
    }

    private ComboBox<String> runesSlot3Domination() {

        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.RavenousHunter.getRune())
                        || _type.getRune().equals(SlotGeneral.IngeniousHunter.getRune())
                        || _type.getRune().equals(SlotGeneral.RelentlessHunter.getRune())
                        || _type.getRune().equals(SlotGeneral.UltimateHunter.getRune())) {
                    s3.getItems().add(_type.getRune());

                }
            }
        }
        return s3;
    }

    private ComboBox<String> runesSlot1Sorcery() {

        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.NullifyingOrb.getRune())
                        || _type.getRune().equals(SlotGeneral.ManaflowBand.getRune())
                        || _type.getRune().equals(SlotGeneral.NimbusCloak.getRune())) {
                    s1.getItems().add(_type.getRune());

                }
            }
        }
        return s1;
    }

    private ComboBox<String> runesSlot2Sorcery() {

        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Transcendence.getRune())
                        || _type.getRune().equals(SlotGeneral.Celerity.getRune())
                        || _type.getRune().equals(SlotGeneral.AbsoluteFocus.getRune())) {
                    s2.getItems().add(_type.getRune());

                }
            }
        }
        return s2;
    }

    private ComboBox<String> runesSlot3Sorcery() {

        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Scorch.getRune())
                        || _type.getRune().equals(SlotGeneral.Waterwalking.getRune())
                        || _type.getRune().equals(SlotGeneral.GatheringStorm.getRune())) {
                    s3.getItems().add(_type.getRune());

                }
            }
        }
        return s3;
    }

    private ComboBox<String> runesSlot1Resolve() {

        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Demolish.getRune())
                        || _type.getRune().equals(SlotGeneral.FontOfLife.getRune())
                        || _type.getRune().equals(SlotGeneral.ShielBash.getRune())) {
                    s1.getItems().add(_type.getRune());

                }
            }
        }
        return s1;
    }

    private ComboBox<String> runesSlot2Resolve() {

        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Conditioning.getRune())
                        || _type.getRune().equals(SlotGeneral.Renewedforces.getRune())
                        || _type.getRune().equals(SlotGeneral.BonePlating.getRune())) {
                    s2.getItems().add(_type.getRune());
                }
            }
        }
        return s2;
    }

    private ComboBox<String> runesSlot3Resolve() {
        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Overgrowth.getRune())
                        || _type.getRune().equals(SlotGeneral.Revitalize.getRune())
                        || _type.getRune().equals(SlotGeneral.Unflinching.getRune())) {
                    s3.getItems().add(_type.getRune());

                }
            }
        }
        return s3;
    }

    private ComboBox<String> runesSlot1Inspiration() {

        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.HextechFlashtraption.getRune())
                        || _type.getRune().equals(SlotGeneral.MagicalFootwear.getRune())
                        || _type.getRune().equals(SlotGeneral.PerfectTiming.getRune())) {
                    s1.getItems().add(_type.getRune());

                }
            }
        }
        return s1;
    }

    private ComboBox<String> runesSlot2Inspiration() {

        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.FuturesMarket.getRune())
                        || _type.getRune().equals(SlotGeneral.MinionDematerializer.getRune())
                        || _type.getRune().equals(SlotGeneral.BiscuitDelivery.getRune())) {
                    s2.getItems().add(_type.getRune());

                }
            }
        }
        return s2;
    }

    private ComboBox<String> runesSlot3Inspiration() {

        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.CosmicInsight.getRune())
                        || _type.getRune().equals(SlotGeneral.ApproachVelocity.getRune())
                        || _type.getRune().equals(SlotGeneral.TimeWarpTonic.getRune())) {
                    s3.getItems().add(_type.getRune());

                }
            }
        }
        return s3;
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

    private RuneType returnType(ComboBox<String> type) {
        if (type != null) {
            for (RuneType _type : RuneType.values()) {
                if (type.getValue().equals(_type.getRune())) {
                    rT = _type;
                }
            }
        }
        return rT;
    }

    private RunesPrimary returnRunesP(ComboBox<String> rPrimary) {
        if (rPrimary != null) {
            for (RunesPrimary _type : RunesPrimary.values()) {
                if (rPrimary.getValue().equals(_type.getRune())) {
                    rP = _type;
                }
            }
        }
        return rP;
    }

    private SlotGeneral returnSlotGeneral(ComboBox<String> s) {
        if (s != null) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (s.getValue().equals(_type.getRune())) {
                    sG = _type;
                }
            }
        }
        return sG;
    }

    private buffsGeneral returnBuffGeneral(ComboBox<String> b) {
        if (bG != null) {
            for (buffsGeneral _type : buffsGeneral.values()) {
                if (b.getValue().equals(_type.getRune())) {
                    bG = _type;
                }
            }
        }
        return bG;
    }

    private void addDescriptionRunesType() {
        if (type != null) {
            for (DescriptionRuneType _type : DescriptionRuneType.values()) {
                if (type.getValue().equals(RuneType.Precision.getRune()) && _type.getRune().equals(DescriptionRuneType.PrecisionDescription.getRune())) {
                    L_Type.setText(_type.getRune());
                }
            }
        }
    }

    @FXML
    public void save() {
        //  if (isValid()) {
        if (r == null) {
            this.r = new runes();
            this.creating = true;
        }
        this.r.setType(returnType(type));
        this.r.setDescriptionType(L_Type.getText());
        this.r.setR1(returnRunesP(rPrimary));
        this.r.setDescriptionType(L_RPrimary.getText());
        this.r.setS1(returnSlotGeneral(s1));
        this.r.setDescriptionS1(L_S1.getText());
        this.r.setS2(returnSlotGeneral(s2));
        this.r.setDescriptionS2(L_S2.getText());
        this.r.setS3(returnSlotGeneral(s3));
        this.r.setDescriptionS3(L_S3.getText());
        this.r.setR2(returnRunesP(rSecondary));
        this.r.setS3(returnSlotGeneral(s4));
        this.r.setDescriptionS3(L_S4.getText());
        this.r.setS3(returnSlotGeneral(s5));
        this.r.setDescriptionS3(L_S5.getText());
        this.r.setB1(returnBuffGeneral(b1));
        this.r.setDescriptionB1(L_B1.getText());
        this.r.setB2(returnBuffGeneral(b2));
        this.r.setDescriptionB2(L_B2.getText());
        this.r.setB3(returnBuffGeneral(b3));
        this.r.setDescriptionB3(L_B3.getText());
        if (this.parentController != null) {
            MapEntry<runes, Boolean> response = new MapEntry<>(this.r, creating);
            this.parentController.doOnCloseModal(response);
        }
        this.stage.close();
        //    }
    }

}
