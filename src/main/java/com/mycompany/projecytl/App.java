package com.mycompany.projecytl;

import com.mycompany.projecytl.Utils.MapEntry;
import com.mycompany.projecytl.controller.AppController;
import com.mycompany.projecytl.controller.Controllers;
import com.mycompany.projecytl.controller.Scenes;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public Stage mainStage;
    public BorderPane rootLayout;

    public AppController controller;

    @Override
    public void start(Stage stage) throws IOException {

        MapEntry<Parent, Controllers> m = AppController.loadFXML(Scenes.ROOT.getUrl());
        mainStage = stage;
        rootLayout = (BorderPane) m.getKey();
        scene = new Scene(rootLayout, 1300, 580);
        stage.setScene(scene);

        controller = (AppController) m.getValue();
        controller.setMainApp(this);
        controller.changeScene(Scenes.HOME);
        stage.getIcons().add(new Image("assets/Icono/icono.png"));
        stage.show();
    }

  

    public static void main(String[] args) {
        launch();
    }

}
