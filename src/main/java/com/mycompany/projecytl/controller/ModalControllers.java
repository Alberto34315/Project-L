/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import javafx.stage.Stage;

public abstract class ModalControllers extends Controllers {

    Controllers parentController;
    Stage stage;

    public Controllers getParentController() {
        return parentController;
    }

    public void setParentController(Controllers parentController) {
        this.parentController = parentController;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    abstract public void setParams(Object p);

}
