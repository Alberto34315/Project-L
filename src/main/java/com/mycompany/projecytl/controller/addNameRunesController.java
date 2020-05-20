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
public class addNameRunesController extends ModalControllers implements Initializable {

    @FXML
    private TextField L_Name;
    private runes r;

    private boolean creating;
    private runesController parent;
    //recibir ifo de mi padre
    private Object params;
    private Stage myStage;

    public addNameRunesController() {
        r = new runes();
    }

    @Override
    public void setParams(Object p) {
        this.params = p;
    }

    @Override
    public void setParent(Controllers p) {
        this.parent = (runesController) p;
    }

    @Override
    public void setStage(Stage Stage) {
        this.myStage = Stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    @FXML
    public void handleCancel() {
        System.out.println(this.parent);
        if (this.parent != null) {
            this.parent.doOnClosedModal(null);
        }
        this.myStage.close();
    }



    @FXML
    public void handleOK() {
        r = parent.save();
       r.setName(L_Name.getText());
        //runes r = (runes) params;
        if (this.parent != null) {
            this.creating = true;
            MapEntry<runes, Boolean> response = new MapEntry<>(r, creating);
            this.parent.doOnClosedModal(response.getKey());
        }
        this.myStage.close();
    }
}
