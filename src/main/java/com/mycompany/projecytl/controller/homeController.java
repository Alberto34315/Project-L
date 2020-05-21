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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author AlbertoRS
 */
public class homeController extends Controllers implements Initializable {

    Connection con;
    private ObservableList<participates> compos;
    @FXML
    private TableView<participates> composition;

    @FXML
    private TableColumn<participates, champions> champion;

    @FXML
    private TableColumn<participates, runes> runes;

    private ObservableList<participates> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.compos = FXCollections.observableArrayList();
        try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(createCompositionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(createCompositionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.data = FXCollections.observableArrayList();
        List<participates> misitems = participatesDao.getAll(con);
        data.addAll(misitems);
        //    List<champions> listChamp = participatesDao.getAllChamp(con);
        for (participates misitem : misitems) {
            this.champion.setCellValueFactory(new PropertyValueFactory<participates, champions>("champion"));
            this.runes.setCellValueFactory(new PropertyValueFactory<participates, runes>("runes"));
            compos.add(misitem);
            composition.setItems(data);
        }

    }

    /*
    public void showAatrox() {
        for (champions champion : champions) {
            if (champion.getNombre().equals("Aatrox")) {
                //img =  new ImageView(imgAatrox);

                L_name.setText(champion.getNombre());
                T_Description.setText(champion.getDescription());
                p.setCellValueFactory(new PropertyValueFactory<champions, String>("P"));
                q.setCellValueFactory(new PropertyValueFactory<champions, String>("Q"));
                w.setCellValueFactory(new PropertyValueFactory<champions, String>("W"));
                e.setCellValueFactory(new PropertyValueFactory<champions, String>("E"));
                r.setCellValueFactory(new PropertyValueFactory<champions, String>("R"));
                champs.add(champion);
                skills.setItems(champs);
            }
        }
    }
     */
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
        }
    }

}
