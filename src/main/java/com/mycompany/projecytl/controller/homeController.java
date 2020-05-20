/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.DAO.participatesDao;
import com.mycompany.projecytl.model.participates;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author AlbertoRS
 */
public class homeController extends Controllers implements Initializable {

    private ObservableList<participates> compos;
    @FXML
    private TableView<participates> composition;

    @FXML
    private TableColumn<participates, String> champion;

    @FXML
    private TableColumn<participates, String> runes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }
@FXML
    private void handleNewComposition() {
        addNameRunesController cc = (addNameRunesController) app.controller.openModal(Scenes.CREATECOMPOSITION, "Create Composition", this, null);
    }
    public void doOnClosedModal(Object response) {
        if (response != null) {
            participates newItem = (participates) response;
            compos.add(newItem);
            participatesDao dao = new participatesDao(newItem);
            int newId = dao.save();
            newItem.setCodGame(newId);
            newItem.setCodRune(newId);
            newItem.setCodChamp(newId);
        }
    }

}
