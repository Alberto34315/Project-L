/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.Utils.MapEntry;
import com.mycompany.projecytl.model.runes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author AlbertoRS
 */
public class addNameRunes extends ModalControllers implements Initializable {

    @FXML
    private TextField L_Name;
    private runes r;
    @FXML
    private Button btnCancel;
    @FXML
    private Button ok;
    private boolean creating;
    private runesController parent;
    //recibir ifo de mi padre
    private Object params;
    private Stage myStage;

    public addNameRunes() {
        r=new runes();
    }

    @Override
    public void setParams(Object p) {
        this.params = p;
    }

    public void setParent(runesController p) {
        this.parent = p;
    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void handleCancel() {
        if (parent != null) {
            parent.doOnModalClosed(null);
        }
        if (this.myStage != null) {
            this.myStage.close();
        }
    }

public void cancel(ActionEvent event){
        this.r = null;
        Stage stage = (Stage) this.ok.getScene().getWindow();
        stage.close();
    }    
    

    public runes returnRune(runes ru) {

        r.setName(L_Name.getText());
        r.setType(ru.getType());
        r.setDescriptionType(ru.getDescriptionType());
        r.setR1(ru.getR1());
        r.setDescriptionRunesPrimary(ru.getDescriptionRunesPrimary());
        r.setS1(ru.getS1());
        r.setDescriptionS1(ru.getDescriptionS1());
        r.setS2(ru.getS2());
        r.setDescriptionS2(ru.getDescriptionS2());
        r.setS3(ru.getS3());
        r.setDescriptionS3(ru.getDescriptionS3());
        r.setR2(ru.getR2());
        r.setDescriptionRunesSecondary(ru.getDescriptionRunesSecondary());
        r.setS4(ru.getS4());
        r.setDescriptionS4(ru.getDescriptionS4());
        r.setS5(ru.getS5());
        r.setDescriptionS5(ru.getDescriptionS5());
        r.setB1(ru.getB1());
        r.setDescriptionB1(ru.getDescriptionB1());
        r.setB2(ru.getB2());
        r.setDescriptionB2(ru.getDescriptionB2());
        r.setB3(ru.getB3());
        r.setDescriptionB3(ru.getDescriptionB3());
        return r;
    }

    @FXML
    public void handleOK() {
        
        //runes r = (runes) params;
        if (this.parent != null) {
            MapEntry<runes, Boolean> response = new MapEntry<>(r, creating);
            this.parent.doOnCloseModal(response);
        }
        this.myStage.close();
    }
}
