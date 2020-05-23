/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.DAO.participatesDao;
import com.mycompany.projecytl.Utils.ConnectionUtils;
import com.mycompany.projecytl.model.champions;
import com.mycompany.projecytl.model.participates;
import com.mycompany.projecytl.model.runes;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author AlbertoRS
 */
public class homeController extends Controllers implements Initializable {

    Connection con;
    private ObservableList<participates> compos;
    private ObservableList<runes> l_rune;
    private ObservableList<champions> l_champ;
    @FXML
    private TableView<participates> composition;

    @FXML
    private TableColumn<participates, champions> champion;

    @FXML
    private TableColumn<participates, runes> runes;

    @FXML
    private TableColumn<champions, String> nameChamp;

    @FXML
    private TableColumn<champions, String> p;

    @FXML
    private TableColumn<champions, String> q;

    @FXML
    private TableColumn<champions, String> w;

    @FXML
    private TableColumn<champions, String> e;

    @FXML
    private TableColumn<champions, String> r;

    @FXML
    private TableColumn<runes, String> namePageRune;

    @FXML
    private TableColumn<runes, String> rune;

    @FXML
    private TableColumn<runes, String> runePrimary;

    @FXML
    private TableColumn<runes, String> slot1;

    @FXML
    private TableColumn<runes, String> slot2;

    @FXML
    private TableColumn<runes, String> slot3;

    @FXML
    private TableColumn<runes, String> runeSecondary;

    @FXML
    private TableColumn<runes, String> slot4;

    @FXML
    private TableColumn<runes, String> slot5;

    @FXML
    private TableColumn<runes, String> buff1;

    @FXML
    private TableColumn<runes, String> buff2;

    @FXML
    private TableColumn<runes, String> buff3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.compos = FXCollections.observableArrayList();
        this.l_rune = FXCollections.observableArrayList();
        this.l_champ = FXCollections.observableArrayList();

        try {
            
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<participates> misitems = participatesDao.getAll(con);
        compos.addAll(misitems);

        List<champions> listChamp = participatesDao.getAllChamp(con);
        List<runes> listRune = participatesDao.getAllRunes(con);

        this.l_champ.addAll(listChamp);
        this.l_rune.addAll(listRune);

        for (participates misitem : misitems) {
            for (champions lc : l_champ) {
                if (misitem.getCodChamp() == lc.getCodChamp()) {
                    this.nameChamp.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lc.getNombre());
                    });
                    this.p.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lc.getP());
                    });
                    this.q.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lc.getQ());
                    });
                    this.w.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lc.getW());
                    });
                    this.e.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lc.getE());
                    });
                    this.r.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lc.getR());
                    });

                }
            }

            for (runes lr : l_rune) {
                if (misitem.getCodRune() == lr.getCodRune()) {
                    this.namePageRune.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getName());
                    });
                    this.rune.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getType().getRune());
                    });
                    this.runePrimary.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getR1().getRune());
                    });
                    this.slot1.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getS1().getRune());
                    });
                    this.slot2.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getS2().getRune());
                    });
                    this.slot3.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getS3().getRune());
                    });
                    this.runeSecondary.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getR2().getRune());
                    });
                    this.slot4.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getS4().getRune());
                    });
                    this.slot5.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getS5().getRune());
                    });
                    this.buff1.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getB1().getRune());
                    });
                    this.buff2.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getB2().getRune());
                    });
                    this.buff3.setCellValueFactory(eachRowData -> {
                        return new SimpleObjectProperty<>(lr.getB3().getRune());
                    });

                }
            }
            //compos.add(misitem);
        composition.setItems(compos);
        }
    }

    @FXML
    private void handleNewComposition() {
        addNameRunesController cc = (addNameRunesController) app.controller.openModal(Scenes.CREATECOMPOSITION, "Create Composition", this, null);
    }

    @FXML
    public void deleteIetem() {
        participates selected = composition.getSelectionModel().getSelectedItem();
        if (selected != null) {
            if (!showConfirm("")) {
                return;
            }
            compos.remove(selected);
            participatesDao dao = new participatesDao(selected);
            dao.remove();
        } else {
            showWarning("¡Ojo!", "Ningún Item a borrar", "Seleccione un item antes de presionar delete");
        }
    }

    public void showWarning(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        alert.showAndWait();
    }

    private boolean showConfirm(String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Comfirmar");
        alert.setHeaderText("A punto de Eliminar");
        alert.setContentText("Desea eliminar el elemento " + title);
        //alert.showAndWait();
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    public void doOnClosedModal(Object response) {
        if (response != null) {
            participates newItem = (participates) response;
            compos.add(newItem);
            participatesDao dao = new participatesDao(newItem);
            int newId = dao.save();
            newItem.setCodGame(newId);
        }
    }

}
