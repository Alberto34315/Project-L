/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.DAO.runesDao;
import com.mycompany.projecytl.Utils.ConnectionUtils;
import com.mycompany.projecytl.model.runes;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author AlbertoRS
 */
public class createCompositionController extends ModalControllers implements Initializable {

    private boolean creating;

    Connection con;

    @FXML
    public ComboBox<String> namesRune;

    @FXML
    public ComboBox<String> namesChampion;

    @FXML
    private TextField T_namesChampion;

    @FXML
    private TextField T_namesRune;

    private homeController parent;

    private Object params;

    private Stage myStage;

    @Override
    public void setParams(Object p) {
        this.params = p;
    }

    @Override
    public void setParent(Controllers p) {
        this.parent = (homeController) p;
    }

    @Override
    public void setStage(Stage Stage) {
        this.myStage = Stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(createCompositionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(createCompositionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        selectTypeRune();
    }

    private void selectTypeRune() {
        runesDao eDao = new runesDao();
        List<runes> r = eDao.getAll(con);
        if (namesRune != null) {
            for (runes rune : r) {
                namesRune.getItems().add(rune.getName());
            }
        }
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
        //   r = parent.save();
        //  r.setName(L_Name.getText());
        //runes r = (runes) params;
        if (this.parent != null) {
            this.creating = true;
            //  MapEntry<participates, Boolean> response = new MapEntry<>(r, creating);
            //  this.parent.doOnClosedModal(response.getKey());
        }
        this.myStage.close();
    }
}
