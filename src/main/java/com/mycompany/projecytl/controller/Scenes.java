/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

/**
 * Enum with String values:
 * https://howtodoinjava.com/java/enum/java-enum-string-example/
 */
public enum Scenes {
    RUNE("view/runes"),
    HOME("view/home"),
    ITEMS("view/items"),
    CHAMPIONS("view/champions"),
    ROOT("view/root2");
    
    private String url;

    Scenes(String fxmlFile) {
        this.url = fxmlFile;
    }

    public String getUrl() {
        return url;
    }
}
