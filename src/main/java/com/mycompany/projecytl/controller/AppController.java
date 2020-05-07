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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

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

    @FXML
    public void connectionsHome() {
        changeScene(Scenes.HOME);
    }

    @FXML
    public void connectionsRune() {
        changeScene(Scenes.RUNE);
    }

    @FXML
    public void connectionsItems() {
        changeScene(Scenes.ITEMS);
    }

    @FXML
    public void connectionsChampions() {
        changeScene(Scenes.CHAMPIONS);
    }

}
