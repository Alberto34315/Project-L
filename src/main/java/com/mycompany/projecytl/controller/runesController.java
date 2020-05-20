/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.DAO.runesDao;
import com.mycompany.projecytl.Enums.DescriptionBuffsGeneral;
import com.mycompany.projecytl.Enums.DescriptionRuneType;
import com.mycompany.projecytl.Enums.DescriptionRunesPrimary;
import com.mycompany.projecytl.Enums.DescriptionSlotGeneral;
import com.mycompany.projecytl.Enums.RuneType;
import com.mycompany.projecytl.Enums.RunesPrimary;
import com.mycompany.projecytl.Enums.SlotGeneral;
import com.mycompany.projecytl.Enums.buffsGeneral;
import com.mycompany.projecytl.Utils.MapEntry;
import com.mycompany.projecytl.model.runes;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 *
 * @author AlbertoRS
 */
public class runesController extends Controllers implements Initializable {

    private boolean creating;
    private ObservableList<runes> rune;

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
    public TextArea L_RPrimary;

    @FXML
    private TextArea L_S1;

    @FXML
    private TextArea L_S2;

    @FXML
    private TextArea L_S3;

    @FXML
    public TextArea L_RSecondary;

    @FXML
    private TextArea L_S4;

    @FXML
    private TextArea L_S5;

    @FXML
    private TextArea L_B1;

    @FXML
    private TextArea L_B2;

    @FXML
    private TextArea L_B3;

    public runesController() {
        this.rune = FXCollections.observableArrayList();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* if (type != null) {
            for (RuneType _type : RuneType.values()) {
                type.getItems().add(_type.getRune());
            }
        }*/
       // this.rune = FXCollections.observableArrayList();
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
        L_RPrimary.clear();
        s1.getItems().clear();
        s2.getItems().clear();
        s3.getItems().clear();
        s4.getItems().clear();
        s5.getItems().clear();
        L_S1.clear();
        L_S2.clear();
        L_S3.clear();
        L_S4.clear();
        L_S5.clear();
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
                addDescriptionRunesPrimaryPrecision();
                runesSlot1Precision();
                runesSlot2Precision();
                runesSlot3Precision();
                break;
            case "Domination":
                addDescriptionRunesPrimaryDomination();
                runesSlot1Domination();
                runesSlot2Domination();
                runesSlot3Domination();
                break;
            case "Sorcery":
                addDescriptionRunesPrimarySorcery();
                runesSlot1Sorcery();
                runesSlot2Sorcery();
                runesSlot3Sorcery();
                break;
            case "Resolve":
                addDescriptionRunesPrimaryResolve();
                runesSlot1Resolve();
                runesSlot2Resolve();
                runesSlot3Resolve();
                break;
            case "Inspiration":
                addDescriptionRunesPrimaryInspiration();
                runesSlot1Inspiration();
                runesSlot2Inspiration();
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

    private void selectRunesecondaryDescription() {
        if (rSecondary != null) {
            for (DescriptionRuneType _type : DescriptionRuneType.values()) {
                if (rSecondary.getValue().equals(RuneType.Precision.getRune()) && _type.getRune().equals(DescriptionRuneType.PrecisionDescription.getRune())) {
                    L_RSecondary.setText(_type.getRune());
                } else if (rSecondary.getValue().equals(RuneType.Domination.getRune()) && _type.getRune().equals(DescriptionRuneType.DominationDescription.getRune())) {
                    L_RSecondary.setText(_type.getRune());
                } else if (rSecondary.getValue().equals(RuneType.Sorcery.getRune()) && _type.getRune().equals(DescriptionRuneType.SorceryDescription.getRune())) {
                    L_RSecondary.setText(_type.getRune());
                } else if (rSecondary.getValue().equals(RuneType.Resolve.getRune()) && _type.getRune().equals(DescriptionRuneType.ResolveDescription.getRune())) {
                    L_RSecondary.setText(_type.getRune());
                } else if (rSecondary.getValue().equals(RuneType.Inspiration.getRune()) && _type.getRune().equals(DescriptionRuneType.InspirationDescription.getRune())) {
                    L_RSecondary.setText(_type.getRune());
                }
            }
        }
    }

    @FXML
    private void selectsSlotsSecondarys4() {
        L_RSecondary.clear();
        selectRunesecondaryDescription();
        s4.getItems().clear();
        runesSlot4();
    }

    @FXML
    private void selectsSlotsSecondarys5() {
        s5.getItems().clear();
        runesSlot5();
        L_S4.clear();
        runesSlot4Description();
    }

    @FXML
    private void selectsSlotsSecondarys5Description() {
        L_S5.clear();
        runesSlot5Description();
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

    private void runesSlot4Description() {
        switch (rSecondary.getValue()) {
            case "Precision":
                if (rSecondary.getValue().equals(RuneType.Precision.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s4.getValue().equals(SlotGeneral.Overheal.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.OverhealDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Triumph.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TriumphDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.PresenceOfMind.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.PresenceOfMindDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Promptness.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.PromptnessDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Tenacity.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TenacityDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Lineage.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.LineageDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.CoupOfGrace.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CoupOfGraceDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.CutDown.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CutDownDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.LastStand.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.LastStandDescription.getRune())) {

                            L_S4.setText(_type.getRune());

                        }
                    }
                }
                break;
            case "Domination":
                if (rSecondary.getValue().equals(RuneType.Domination.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s4.getValue().equals(SlotGeneral.CheapShot.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CheapShotDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.TasteOfBlood.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TasteOfBloodDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.SuddenImpact.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.SuddenImpactDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.ZombieWard.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ZombieWardDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.GhostPoro.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.GhostPoroDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.EyeballCollection.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.EyeballCollectionDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.RavenousHunter.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.RavenousHunterDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.IngeniousHunter.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.IngeniousHunterDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.RelentlessHunter.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.RelentlessHunterDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.UltimateHunter.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.UltimateHunterDescription.getRune())) {

                            L_S4.setText(_type.getRune());
                        }
                    }
                }
                break;
            case "Sorcery":
                if (rSecondary.getValue().equals(RuneType.Sorcery.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s4.getValue().equals(SlotGeneral.NullifyingOrb.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.NullifyingOrbDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.ManaflowBand.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ManaflowBandDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.NimbusCloak.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.NimbusCloakDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Transcendence.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TranscendenceDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Celerity.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CelerityDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.AbsoluteFocus.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.AbsoluteFocusDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Scorch.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ScorchDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Waterwalking.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.WaterwalkingDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.GatheringStorm.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.GatheringStormDescription.getRune())) {

                            L_S4.setText(_type.getRune());

                        }
                    }
                }
                break;

            case "Resolve":
                if (rSecondary.getValue().equals(RuneType.Resolve.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s4.getValue().equals(SlotGeneral.Demolish.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.DemolishDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.FontOfLife.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.FontOfLifeDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.ShielBash.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ShielBashDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Conditioning.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ConditioningDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Renewedforces.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.RenewedforcesDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.BonePlating.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.BonePlatingDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Overgrowth.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.OvergrowthDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Revitalize.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.RevitalizeDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.Unflinching.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.UnflinchingDescription.getRune())) {

                            L_S4.setText(_type.getRune());

                        }
                    }
                }
                break;

            case "Inspiration":
                if (rSecondary.getValue().equals(RuneType.Inspiration.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s4.getValue().equals(SlotGeneral.HextechFlashtraption.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.HextechFlashtraptionDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.MagicalFootwear.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.MagicalFootwearDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.PerfectTiming.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.PerfectTimingDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.FuturesMarket.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.FuturesMarketDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.MinionDematerializer.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.MinionDematerializerDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.BiscuitDelivery.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.BiscuitDeliveryDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.CosmicInsight.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CosmicInsightDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.ApproachVelocity.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ApproachVelocityDescription.getRune())
                                || s4.getValue().equals(SlotGeneral.TimeWarpTonic.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TimeWarpTonicDescription.getRune())) {

                            L_S4.setText(_type.getRune());

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

    private void runesSlot5Description() {
        switch (rSecondary.getValue()) {
            case "Precision":
                if (rSecondary.getValue().equals(RuneType.Precision.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s5.getValue().equals(SlotGeneral.Overheal.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.OverhealDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Triumph.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TriumphDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.PresenceOfMind.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.PresenceOfMindDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Promptness.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.PromptnessDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Tenacity.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TenacityDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Lineage.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.LineageDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.CoupOfGrace.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CoupOfGraceDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.CutDown.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CutDownDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.LastStand.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.LastStandDescription.getRune())) {

                            L_S5.setText(_type.getRune());

                        }
                    }
                }
                break;
            case "Domination":
                if (rSecondary.getValue().equals(RuneType.Domination.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s5.getValue().equals(SlotGeneral.CheapShot.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CheapShotDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.TasteOfBlood.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TasteOfBloodDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.SuddenImpact.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.SuddenImpactDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.ZombieWard.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ZombieWardDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.GhostPoro.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.GhostPoroDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.EyeballCollection.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.EyeballCollectionDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.RavenousHunter.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.RavenousHunterDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.IngeniousHunter.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.IngeniousHunterDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.RelentlessHunter.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.RelentlessHunterDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.UltimateHunter.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.UltimateHunterDescription.getRune())) {

                            L_S5.setText(_type.getRune());

                        }
                    }
                }
                break;
            case "Sorcery":
                if (rSecondary.getValue().equals(RuneType.Sorcery.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s5.getValue().equals(SlotGeneral.NullifyingOrb.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.NullifyingOrbDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.ManaflowBand.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ManaflowBandDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.NimbusCloak.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.NimbusCloakDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Transcendence.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TranscendenceDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Celerity.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CelerityDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.AbsoluteFocus.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.AbsoluteFocusDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Scorch.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ScorchDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Waterwalking.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.WaterwalkingDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.GatheringStorm.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.GatheringStormDescription.getRune())) {

                            L_S5.setText(_type.getRune());

                        }
                    }
                }
                break;

            case "Resolve":
                if (rSecondary.getValue().equals(RuneType.Resolve.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s5.getValue().equals(SlotGeneral.Demolish.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.DemolishDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.FontOfLife.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.FontOfLifeDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.ShielBash.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ShielBashDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Conditioning.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ConditioningDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Renewedforces.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.RenewedforcesDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.BonePlating.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.BonePlatingDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Overgrowth.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.OvergrowthDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Revitalize.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.RevitalizeDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.Unflinching.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.UnflinchingDescription.getRune())) {

                            L_S5.setText(_type.getRune());

                        }
                    }
                }
                break;

            case "Inspiration":
                if (rSecondary.getValue().equals(RuneType.Inspiration.getRune())) {
                    for (DescriptionSlotGeneral _type : DescriptionSlotGeneral.values()) {
                        if (s5.getValue().equals(SlotGeneral.HextechFlashtraption.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.HextechFlashtraptionDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.MagicalFootwear.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.MagicalFootwearDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.PerfectTiming.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.PerfectTimingDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.FuturesMarket.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.FuturesMarketDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.MinionDematerializer.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.MinionDematerializerDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.BiscuitDelivery.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.BiscuitDeliveryDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.CosmicInsight.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.CosmicInsightDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.ApproachVelocity.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.ApproachVelocityDescription.getRune())
                                || s5.getValue().equals(SlotGeneral.TimeWarpTonic.getRune()) && _type.getRune().equals(DescriptionSlotGeneral.TimeWarpTonicDescription.getRune())) {

                            L_S5.setText(_type.getRune());

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

    @FXML
    public void addDescriptionSlot1() {
        switch (type.getValue()) {
            case "Precision":
                runesSlot1PrecisionDescription();
                break;
            case "Domination":
                runesSlot1DominationDescription();
                break;
            case "Sorcery":
                runesSlot1SorceryDescription();
                break;
            case "Resolve":
                runesSlot1ResolveDescription();
                break;
            case "Inspiration":
                runesSlot1InspirationDescription();
                break;
            default:
                System.out.println("Opción no encontrado");
        }
    }

    @FXML
    public void addDescriptionSlot2() {
        switch (type.getValue()) {
            case "Precision":
                runesSlot2PrecisionDescription();
                break;
            case "Domination":
                runesSlot2DominationDescription();
                break;
            case "Sorcery":
                runesSlot2SorceryDescription();
                break;
            case "Resolve":
                runesSlot2ResolveDescription();
                break;
            case "Inspiration":
                runesSlot2InspirationDescription();
                break;
            default:
                System.out.println("Opción no encontrado");
        }
    }

    @FXML
    public void addDescriptionSlot3() {
        switch (type.getValue()) {
            case "Precision":
                runesSlot3PrecisionDescription();
                break;
            case "Domination":
                runesSlot3DominationDescription();
                break;
            case "Sorcery":
                runesSlot3SorceryDescription();
                break;
            case "Resolve":
                runesSlot3ResolveDescription();
                break;
            case "Inspiration":
                runesSlot3InspirationDescription();
                break;
            default:
                System.out.println("Opción no encontrado");
        }
    }

    private void runesSlot1PrecisionDescription() {
        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s1.getValue().equals(SlotGeneral.Overheal.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.OverhealDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.Triumph.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.TriumphDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.PresenceOfMind.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.PresenceOfMindDescription.getRune())) {
                    L_S1.setText(_sType.getRune());
                }
            }

        }
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

    private void runesSlot2PrecisionDescription() {
        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s2.getValue().equals(SlotGeneral.Promptness.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.PromptnessDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.Tenacity.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.TenacityDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.Lineage.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.LineageDescription.getRune())) {
                    L_S2.setText(_sType.getRune());
                }
            }

        }
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

    private void runesSlot3PrecisionDescription() {
        if (type.getValue().equals(RuneType.Precision.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s3.getValue().equals(SlotGeneral.CoupOfGrace.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.CoupOfGraceDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.CutDown.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.CutDownDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.LastStand.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.LastStandDescription.getRune())) {
                    L_S3.setText(_sType.getRune());
                }
            }

        }
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

    private void runesSlot1DominationDescription() {
        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s1.getValue().equals(SlotGeneral.CheapShot.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.CheapShotDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.TasteOfBlood.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.TasteOfBloodDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.SuddenImpact.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.SuddenImpactDescription.getRune())) {
                    L_S1.setText(_sType.getRune());

                }
            }
        }
    }

    private ComboBox<String> runesSlot2Domination() {

        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.ZombieWard.getRune())
                        || _type.getRune().equals(SlotGeneral.GhostPoro.getRune())
                        || _type.getRune().equals(SlotGeneral.EyeballCollection.getRune())) {
                    s2.getItems().add(_type.getRune());

                }
            }
        }
        return s2;
    }

    private void runesSlot2DominationDescription() {

        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s2.getValue().equals(SlotGeneral.ZombieWard.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.ZombieWardDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.GhostPoro.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.GhostPoroDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.EyeballCollection.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.EyeballCollectionDescription.getRune())) {
                    L_S2.setText(_sType.getRune());
                }
            }
        }
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

    private void runesSlot3DominationDescription() {

        if (type.getValue().equals(RuneType.Domination.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s3.getValue().equals(SlotGeneral.RavenousHunter.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.RavenousHunterDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.IngeniousHunter.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.IngeniousHunterDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.RelentlessHunter.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.RelentlessHunterDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.UltimateHunter.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.UltimateHunterDescription.getRune())) {
                    L_S3.setText(_sType.getRune());

                }
            }
        }
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

    private void runesSlot1SorceryDescription() {

        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s1.getValue().equals(SlotGeneral.NullifyingOrb.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.NullifyingOrbDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.ManaflowBand.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.ManaflowBandDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.NimbusCloak.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.NimbusCloakDescription.getRune())) {
                    L_S1.setText(_sType.getRune());
                }
            }
        }
    }

    private void runesSlot2Sorcery() {

        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (SlotGeneral _type : SlotGeneral.values()) {
                if (_type.getRune().equals(SlotGeneral.Transcendence.getRune())
                        || _type.getRune().equals(SlotGeneral.Celerity.getRune())
                        || _type.getRune().equals(SlotGeneral.AbsoluteFocus.getRune())) {
                    s2.getItems().add(_type.getRune());

                }
            }
        }
    }

    private void runesSlot2SorceryDescription() {

        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s2.getValue().equals(SlotGeneral.Transcendence.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.TranscendenceDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.Celerity.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.CelerityDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.AbsoluteFocus.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.AbsoluteFocusDescription.getRune())) {
                    L_S2.setText(_sType.getRune());
                }
            }
        }
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

    private void runesSlot3SorceryDescription() {

        if (type.getValue().equals(RuneType.Sorcery.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s3.getValue().equals(SlotGeneral.Scorch.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.ScorchDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.Waterwalking.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.WaterwalkingDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.GatheringStorm.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.GatheringStormDescription.getRune())) {
                    L_S3.setText(_sType.getRune());
                }
            }
        }
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

    private void runesSlot1ResolveDescription() {

        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s1.getValue().equals(SlotGeneral.Demolish.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.DemolishDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.FontOfLife.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.FontOfLifeDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.ShielBash.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.ShielBashDescription.getRune())) {
                    L_S1.setText(_sType.getRune());
                }
            }
        }
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

    private void runesSlot2ResolveDescription() {

        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s2.getValue().equals(SlotGeneral.Conditioning.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.ConditioningDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.Renewedforces.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.RenewedforcesDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.BonePlating.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.BonePlatingDescription.getRune())) {
                    L_S2.setText(_sType.getRune());
                }
            }
        }
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

    private void runesSlot3ResolveDescription() {

        if (type.getValue().equals(RuneType.Resolve.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s3.getValue().equals(SlotGeneral.Overgrowth.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.OvergrowthDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.Revitalize.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.RevitalizeDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.Unflinching.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.UnflinchingDescription.getRune())) {
                    L_S3.setText(_sType.getRune());
                }
            }
        }
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

    private void runesSlot1InspirationDescription() {

        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s1.getValue().equals(SlotGeneral.HextechFlashtraption.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.HextechFlashtraptionDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.MagicalFootwear.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.MagicalFootwearDescription.getRune())
                        || s1.getValue().equals(SlotGeneral.PerfectTiming.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.PerfectTimingDescription.getRune())) {
                    L_S1.setText(_sType.getRune());
                }
            }
        }
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

    private void runesSlot2InspirationDescription() {

        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s2.getValue().equals(SlotGeneral.FuturesMarket.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.FuturesMarketDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.MinionDematerializer.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.MinionDematerializerDescription.getRune())
                        || s2.getValue().equals(SlotGeneral.BiscuitDelivery.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.BiscuitDeliveryDescription.getRune())) {
                    L_S2.setText(_sType.getRune());
                }
            }
        }
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

    private void runesSlot3InspirationDescription() {

        if (type.getValue().equals(RuneType.Inspiration.getRune())) {
            for (DescriptionSlotGeneral _sType : DescriptionSlotGeneral.values()) {
                if (s3.getValue().equals(SlotGeneral.CosmicInsight.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.CosmicInsightDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.ApproachVelocity.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.ApproachVelocityDescription.getRune())
                        || s3.getValue().equals(SlotGeneral.TimeWarpTonic.getRune()) && _sType.getRune().equals(DescriptionSlotGeneral.TimeWarpTonicDescription.getRune())) {
                    L_S3.setText(_sType.getRune());
                }
            }
        }
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

    @FXML
    private void runesBuff1Description() {
        if (L_B1.getText() != null) {
            L_B1.clear();
        }
        for (DescriptionBuffsGeneral _type : DescriptionBuffsGeneral.values()) {
            if (b1.getValue().equals(buffsGeneral.AdaptiveForce.getRune()) && _type.getRune().equals(DescriptionBuffsGeneral.AdaptiveForceDescription.getRune())
                    || b1.getValue().equals(buffsGeneral.AttackSpeed.getRune()) && _type.getRune().equals(DescriptionBuffsGeneral.AttackSpeedDescription.getRune())
                    || b1.getValue().equals(buffsGeneral.CoolingReduction.getRune()) && _type.getRune().equals(DescriptionBuffsGeneral.CoolingReductionDescription.getRune())) {
                L_B1.setText(_type.getRune());
            }
        }
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

    @FXML
    private void runesBuff2Description() {
        if (L_B2.getText() != null) {
            L_B2.clear();
        }
        for (DescriptionBuffsGeneral _type : DescriptionBuffsGeneral.values()) {
            if (b2.getValue().equals(buffsGeneral.AdaptiveForce.getRune()) && _type.getRune().equals(DescriptionBuffsGeneral.AdaptiveForceDescription.getRune())
                    || b2.getValue().equals(buffsGeneral.Armor.getRune()) && _type.getRune().equals(DescriptionBuffsGeneral.ArmorDescription.getRune())
                    || b2.getValue().equals(buffsGeneral.MagicResistance.getRune()) && _type.getRune().equals(DescriptionBuffsGeneral.MagicResistanceDescription.getRune())) {
                L_B2.setText(_type.getRune());
            }
        }
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

    @FXML
    private void runesBuff3Description() {
        if (L_B3.getText() != null) {
            L_B3.clear();
        }
        for (DescriptionBuffsGeneral _type : DescriptionBuffsGeneral.values()) {
            if (b3.getValue().equals(buffsGeneral.Life.getRune()) && _type.getRune().equals(DescriptionBuffsGeneral.LifeDescription.getRune())
                    || b3.getValue().equals(buffsGeneral.Armor.getRune()) && _type.getRune().equals(DescriptionBuffsGeneral.ArmorDescription.getRune())
                    || b3.getValue().equals(buffsGeneral.MagicResistance.getRune()) && _type.getRune().equals(DescriptionBuffsGeneral.MagicResistanceDescription.getRune())) {
                L_B3.setText(_type.getRune());
            }
        }
    }

    /*
    @Override
    public void setParams(Object p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    private RuneType returnType(ComboBox<String> type) {
        RuneType rT = null;
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
        RunesPrimary rP = null;
        if (rPrimary != null) {
            for (RunesPrimary _type : RunesPrimary.values()) {
                if (rPrimary.getValue().equals(_type.getRune())) {
                    rP = _type;
                }
            }
        }
        return rP;
    }

    private RuneType returnRunesPs(ComboBox<String> rSecondary) {
        RuneType rP = null;
        if (rSecondary != null) {
            for (RuneType _type : RuneType.values()) {
                if (rSecondary.getValue().equals(_type.getRune())) {
                    rP = _type;
                }
            }
        }
        return rP;
    }

    private SlotGeneral returnSlotGeneral(ComboBox<String> s) {
        SlotGeneral sG = null;
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
        buffsGeneral bG = null;
        if (b != null) {
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
                } else if (type.getValue().equals(RuneType.Domination.getRune()) && _type.getRune().equals(DescriptionRuneType.DominationDescription.getRune())) {
                    L_Type.setText(_type.getRune());
                } else if (type.getValue().equals(RuneType.Sorcery.getRune()) && _type.getRune().equals(DescriptionRuneType.SorceryDescription.getRune())) {
                    L_Type.setText(_type.getRune());
                } else if (type.getValue().equals(RuneType.Resolve.getRune()) && _type.getRune().equals(DescriptionRuneType.ResolveDescription.getRune())) {
                    L_Type.setText(_type.getRune());
                } else if (type.getValue().equals(RuneType.Inspiration.getRune()) && _type.getRune().equals(DescriptionRuneType.InspirationDescription.getRune())) {
                    L_Type.setText(_type.getRune());
                }
            }
        }
    }

    private void addDescriptionRunesPrimaryPrecision() {
        if (type != null) {
            for (DescriptionRunesPrimary _type : DescriptionRunesPrimary.values()) {
                if (rPrimary.getValue().equals(RunesPrimary.Conqueror.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.ConquerorDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.LethalTempo.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.LethalTempoDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.FleetFootwork.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.FleetFootworkDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.PressTheAttack.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.PressTheAttackDescription.getRune())) {
                    L_RPrimary.setText(_type.getRune());
                }
            }
        }
    }

    private void addDescriptionRunesPrimaryDomination() {
        if (type != null) {
            for (DescriptionRunesPrimary _type : DescriptionRunesPrimary.values()) {
                if (rPrimary.getValue().equals(RunesPrimary.Electrocute.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.ElectrocuteDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.Predator.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.PredatorDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.DarkHarvest.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.DarkHarvestDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.HailOfBlade.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.HailOfBladeDescription.getRune())) {
                    L_RPrimary.setText(_type.getRune());
                }
            }
        }
    }

    private void addDescriptionRunesPrimarySorcery() {
        if (type != null) {
            for (DescriptionRunesPrimary _type : DescriptionRunesPrimary.values()) {
                if (rPrimary.getValue().equals(RunesPrimary.SummonAery.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.SummonAeryDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.ArcaneComet.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.ArcaneCometDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.PhaseRush.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.PhaseRushDescription.getRune())) {
                    L_RPrimary.setText(_type.getRune());
                }
            }
        }
    }

    private void addDescriptionRunesPrimaryResolve() {
        if (type != null) {
            for (DescriptionRunesPrimary _type : DescriptionRunesPrimary.values()) {
                if (rPrimary.getValue().equals(RunesPrimary.GraspOfTheUndying.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.GraspOfTheUndyingDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.Aftershock.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.AftershockDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.Guardian.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.GuardianDescription.getRune())) {
                    L_RPrimary.setText(_type.getRune());
                }
            }
        }
    }

    private void addDescriptionRunesPrimaryInspiration() {
        if (type != null) {
            for (DescriptionRunesPrimary _type : DescriptionRunesPrimary.values()) {
                if (rPrimary.getValue().equals(RunesPrimary.GlacialAugment.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.GlacialAugmentDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.UnsealedSpellbook.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.UnsealedSpellbookDescription.getRune())
                        || rPrimary.getValue().equals(RunesPrimary.PrototypeVersatility.getRune()) && _type.getRune().equals(DescriptionRunesPrimary.PrototypeVersatilityDescription.getRune())) {
                    L_RPrimary.setText(_type.getRune());
                }
            }
        }
    }

    private boolean showConfirm() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirmar");
        alert.setHeaderText("A punto de Guardar");
        alert.setContentText("¿Desea guardar el elemento?");
        //alert.show();
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    private void handleNameRune() {
        addNameRunesController cc = (addNameRunesController) app.controller.openModal(Scenes.NAMERUNE, "Name Rune", this, null);
    }

    @FXML
    public runes save() {
        runes r = null;
        addNameRunesController add = new addNameRunesController();
        //  if (isValid()) {
        if (r == null) {
            r = new runes();
            this.creating = true;
        }
        r.setType(returnType(type));
        r.setDescriptionType(L_Type.getText());
        r.setR1(returnRunesP(rPrimary));
        r.setDescriptionRunesPrimary(L_RPrimary.getText());
        r.setS1(returnSlotGeneral(s1));
        r.setDescriptionS1(L_S1.getText());
        r.setS2(returnSlotGeneral(s2));
        r.setDescriptionS2(L_S2.getText());
        r.setS3(returnSlotGeneral(s3));
        r.setDescriptionS3(L_S3.getText());
        r.setR2(returnRunesPs(rSecondary));
        r.setDescriptionRunesSecondary(L_RSecondary.getText());
        r.setS4(returnSlotGeneral(s4));
        r.setDescriptionS4(L_S4.getText());
        r.setS5(returnSlotGeneral(s5));
        r.setDescriptionS5(L_S5.getText());
        r.setB1(returnBuffGeneral(b1));
        r.setDescriptionB1(L_B1.getText());
        r.setB2(returnBuffGeneral(b2));
        r.setDescriptionB2(L_B2.getText());
        r.setB3(returnBuffGeneral(b3));
        r.setDescriptionB3(L_B3.getText());

        return r;
    }

    public void doOnClosedModal(Object response) {
        if (response != null) {
            runes newItem = (runes) response;
            rune.add(newItem);
            runesDao dao = new runesDao(newItem);
            int newId = dao.save();
            newItem.setCodRune(newId);
        }
    }

}
