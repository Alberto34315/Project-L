/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.DAO.championsDao;
import com.mycompany.projecytl.DAO.gameDao;
import com.mycompany.projecytl.DAO.runesDao;
import com.mycompany.projecytl.Utils.ConnectionUtils;
import com.mycompany.projecytl.Utils.MapEntry;
import com.mycompany.projecytl.model.Game;
import com.mycompany.projecytl.model.champions;
import com.mycompany.projecytl.model.participates;
import com.mycompany.projecytl.model.runes;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<Game> game;
    Connection con;
    private List<champions> lChamp;
    private List<runes> r;
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
        selectChampions();
        this.game = FXCollections.observableArrayList();
    }

    private void selectTypeRune() {
        r = runesDao.getAll(con);
        if (namesRune != null) {
            for (runes rune : r) {
                namesRune.getItems().add(rune.getName());
            }
        }
    }

    private void selectChampions() {
        lChamp = championsDao.getAll(con);
        if (namesChampion != null) {
            for (champions champ : lChamp) {
                namesChampion.getItems().add(champ.getNombre());
            }
        }
    }

    @FXML
    private void selectTextRune() {
        T_namesRune.setText(namesRune.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void selectTextChampion() {
        T_namesChampion.setText(namesChampion.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void handleCancel() {
        System.out.println(this.parent);
        if (this.parent != null) {
            this.parent.doOnClosedModal(null);
        }
        this.myStage.close();
    }

    private int returnCodRune() {
        int cod = 0;
        for (runes rune : r) {
            if (rune.getName().equals(T_namesRune.getText())) {
                cod = rune.getCodRune();
            }
        }
        return cod;
    }

    private int returnCodChampion() {
        int cod = 0;
        for (champions c : lChamp) {
            if (c.getNombre().equals(namesChampion.getSelectionModel().getSelectedItem())) {
                cod = c.getCodChamp();
            }
        }
        return cod;
    }

    private int returnCodGame() {
        int cod = 0;
        Game newItem = new Game();
        game.add(newItem);
        gameDao dao = new gameDao(newItem);
        int newId = dao.save();
        newItem.setCodGame(newId);
        return newId;
    }

    @FXML
    public void handleOK() {
        participates p = new participates(returnCodGame(), returnCodRune(), returnCodChampion());
        //runes r = (runes) params;
        if (this.parent != null) {
            this.creating = true;
            MapEntry<participates, Boolean> response = new MapEntry<>(p, creating);
            this.parent.doOnClosedModal(response.getKey());
        }
        this.myStage.close();
    }
}
