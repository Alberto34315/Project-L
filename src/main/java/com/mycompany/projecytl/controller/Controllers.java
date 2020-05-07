/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

/**
 *
 * @author AlbertoRS
 */
import com.mycompany.projecytl.App;

public abstract class Controllers {

    App app;

    public void setMainApp(App app) {
        this.app = app;
        this.onLoad();
    }
    //To be ovewritten

    void onLoad() {
    }

    ;
 //To be ovewritten
    void doOnCloseModal(Object response) {
    }
}
