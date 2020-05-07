/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.Enums.RuneType;
import com.mycompany.projecytl.Enums.RunesPrimary;
import java.net.URL;
import java.util.ResourceBundle;
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

        switch (type.getValue()) {
            case "Precision":
                runesPrecision();
                rPrimary=null;
                break;
            case "Domination":
                runesDomination();
                rPrimary=null;
                break;
            case "Sorcery":
                runesSorcery();
                break;
            case "Resolve":
                runesResolve();
                break;
            case "Inspiration":
                runesInspiration();
                break;
            default:
                System.out.println("Opción no encontrado");
        }
    }

    private boolean runesPrecision() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Precision.getRune())) {
            /*     for (RunesPrimary _type : RunesPrimary.values()) {
                if (_type.getRune().equals(RunesPrimary.Conqueror.getRune())
                        || _type.getRune().equals(RunesPrimary.PressTheAttack.getRune())
                        || _type.getRune().equals(RunesPrimary.LethalTempo.getRune())
                        || _type.getRune().equals(RunesPrimary.FleetFootwork.getRune())) {
                    rPrimary.getItems().add(_type.getRune());
                    result = true;
                }
            }*/
            rPrimary.getItems().add(RunesPrimary.Conqueror.getRune());
            rPrimary.getItems().add(RunesPrimary.PressTheAttack.getRune());
            rPrimary.getItems().add(RunesPrimary.LethalTempo.getRune());
            rPrimary.getItems().add(RunesPrimary.FleetFootwork.getRune());
            result = true;
        }
        return result;
    }

    private boolean runesDomination() {
        boolean result = false;
        if (type.getValue().equals(RuneType.Domination.getRune())) {
            /*  for (RunesPrimary _type : RunesPrimary.values()) {
                if (_type.getRune().equals(RunesPrimary.Electrocute.getRune())
                        || _type.getRune().equals(RunesPrimary.Predator.getRune())
                        || _type.getRune().equals(RunesPrimary.DarkHarvest.getRune())
                        || _type.getRune().equals(RunesPrimary.HailOfBlade.getRune())) {
                    rPrimary.getItems().add(_type.getRune());
                    result = true;
                }
            }*/
            rPrimary.getItems().add(RunesPrimary.Electrocute.getRune());
            rPrimary.getItems().add(RunesPrimary.Predator.getRune());
            rPrimary.getItems().add(RunesPrimary.DarkHarvest.getRune());
            rPrimary.getItems().add(RunesPrimary.HailOfBlade.getRune());
            result = true;
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

    @Override
    public void setParams(Object p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
