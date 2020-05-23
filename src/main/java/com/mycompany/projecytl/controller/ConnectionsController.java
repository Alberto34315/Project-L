/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.model.Connection;
import com.mycompany.projecytl.Utils.MapEntry;
import com.mycompany.projecytl.Utils.XMLUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ConnectionsController extends Controllers implements Initializable {
    //OBSERVABLE <--------

    public ObservableList<Connection> conns;

    @FXML
    private TableView<Connection> connTable;
    @FXML
    private TableColumn<Connection, String> nameConn;
    @FXML
    private Label L_nameConn;
    @FXML
    public Label L_type;
    @FXML
    private Label L_server;
    @FXML
    private Label L_user;
    @FXML
    private Label L_pass;

    @FXML
    private HBox tools;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.conns = FXCollections.observableArrayList();
        this.conns.addAll(XMLUtil.loadDataXML());
    }


    @Override
    void doOnCloseModal(Object response) {
        if (response != null) {
            MapEntry<Connection, Boolean> r = (MapEntry<Connection, Boolean>) response;
            if (r.getValue()) { 
                conns.add(r.getKey());
            }
            XMLUtil.writeDataXML(conns);
        }

    }
}
