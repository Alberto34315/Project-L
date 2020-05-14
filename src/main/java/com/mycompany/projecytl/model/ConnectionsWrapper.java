/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.model;


import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="conns")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConnectionsWrapper {

 @XmlElement(name="conn")
 private List<Connection> conns;
 public List<Connection> getConns() {
 return conns;
 }
 public void setConns(List<Connection> conns) {
 this.conns = conns;
 }
 @Override
 public String toString() {
 return "ConnectionsWrapper{" + "conns=" + conns + '}';
 }
}
