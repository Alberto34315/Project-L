/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.model;

/**
 *
 * @author AlbertoRS
 */
public class items {

    private int codItem;
    private String nombre;
    private String descipcion;
    private int precio;

    public items() {
        this(-1, "", "", 0);
    }

    public items(int codItem, String nombre, String descipcion, int precio) {
        this.codItem = codItem;
        this.nombre = nombre;
        this.descipcion = descipcion;
        this.precio = precio;
    }

    public int getCodItem() {
        return codItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "items{" + "codItem=" + codItem + ", nombre=" + nombre + ", descipcion=" + descipcion + ", precio=" + precio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean igual = false;
        if (obj != null) {
            if (this == obj) {
                igual = true;
            } else {
                if (obj instanceof items) {
                    items n = (items) obj;
                    if (this.codItem == n.getCodItem()) {
                        igual = true;
                    }
                }
            }
        }
        return igual;
    }

}
