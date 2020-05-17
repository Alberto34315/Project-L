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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author AlbertoRS
 */
public class addNameRunes extends ModalControllers implements Initializable {

    @FXML
    private TextField L_Name;

    private boolean creating;
    private runesController parent;
    //recibir ifo de mi padre
    private Object params;
    private Stage myStage;

    public addNameRunes() {
    }

    @Override
    public void setParams(Object p) {
        //
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

    @FXML
    public void handleOK() {
        String name = L_Name.getText();
        if (this.parent != null) {
            MapEntry<String, Boolean> response = new MapEntry<>(name, creating);
            this.parent.doOnCloseModal(response);
        }
        this.myStage.close();
    }
}
