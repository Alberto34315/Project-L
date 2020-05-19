/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.App;
import com.mycompany.projecytl.Utils.MapEntry;
import com.mycompany.projecytl.model.Connection;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author AlbertoRS
 */
public class AppController extends Controllers {

    public Scenes backScene;
    public Scenes currentScene;
    public static Connection currentConnection;

    // public static Connection currentConnection;
    public static MapEntry<Parent, Controllers> loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent p = fxmlLoader.load();
        Controllers c = fxmlLoader.getController();
        MapEntry<Parent, Controllers> result = new MapEntry<>(p, c);
        return result;
    }

    public void changeScene(Scenes scene) {
        try {
            MapEntry<Parent, Controllers> m = loadFXML(scene.getUrl());
            this.app.rootLayout.setCenter(m.getKey());
            if (m.getValue() != null) {
                m.getValue().setMainApp(this.app);
            }
            if (backScene != currentScene) {
                backScene = currentScene;
            }
            this.currentScene = scene;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Controllers openModal(Scenes scene, String title, Controllers parentController, Object params) {

        /*   try {
            System.out.println(scene.getUrl());
            MapEntry<Parent, Controllers> m = loadFXML(scene.getUrl());
            Stage modalStage = new Stage();
            modalStage.setTitle(title);
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.initOwner(this.app.mainStage);

            Scene modalScene = new Scene(m.getKey());
            
            modalStage.setScene(modalScene);

            if (m.getValue() != null) {
            m.getValue().setMainApp(this.app);
            ModalControllers mc = (ModalControllers) m.getValue();
            mc.setParentController(parentController);
            mc.setStage(modalStage);
            mc.setParams(params);
            }
            modalStage.showAndWait();
            return m.getValue();
            } catch (IOException ex) {
            ex.printStackTrace();
            return null;
            }*/
        // FXMLLoader fxmlLoader = new FXMLLoader(scene.getUrl());
        try {
            MapEntry<Parent, Controllers> m = loadFXML(scene.getUrl());
            Parent modal;
            modal = m.getKey();
            Stage modalStage = new Stage();
            modalStage.setTitle(title);
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.initOwner(this.app.mainStage); //ojo no existía, hay que crearlo
            Scene modalScene = new Scene(modal);
            modalStage.setScene(modalScene);
            ModalControllers modalController = (ModalControllers) m.getValue();
            if (modalController != null) {
                //Para autocerrar
                modalController.setStage(modalStage);
                //Comunicacion hijo -> padre
                modalController.setParent(parentController);
                //Comunicacion padre -> hijo
                modalController.setParams(params);
            }
            modalStage.showAndWait();
           
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }

    @FXML
    public void connectionsHome() {
        changeScene(Scenes.HOME);
    }

    @FXML
    public void connectionsRune() {
        changeScene(Scenes.RUNE);
    }

    @FXML
    public void connectionsChampions() {
        changeScene(Scenes.CHAMPIONS);
    }

}
