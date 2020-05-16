/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.model.champions;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author AlbertoRS
 */
public class championsController extends Controllers implements Initializable {
    
    public ObservableList<champions> champs;
    
    private Set<champions> champions;
    
    private final static String championsXML = "champions.xml";
    
    private final static String imgAatrox = "assets/Champons/aatrox.jpg";
    
    public championsController() {
        this.champions = new HashSet<>();
        this.champs = FXCollections.observableArrayList();
    }
    
    @FXML
    public Button aatrox;
    
    @FXML
    public ImageView img;
    
    @FXML
    public Label L_name;
    
    @FXML
    public TextArea T_Description;
    
    @FXML
    private TableView<champions> skills;
    
    @FXML
    private TableColumn<champions, String> p;
    
    @FXML
    private TableColumn<champions, String> q;
    
    @FXML
    private TableColumn<champions, String> w;
    
    @FXML
    private TableColumn<champions, String> e;
    
    @FXML
    private TableColumn<champions, String> r;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadClientsFromDDBB();
    }
    
    @FXML
    public void showAatrox() {
        skills.getItems().clear();
       
        for (champions champion : champions) {
            if (champion.getNombre().equals("Aatrox")) {
                //img =  new ImageView(imgAatrox);
                //Image image = new Image("assets/Champons/aatrox.jpg");
               // img = new ImageView(image);
                L_name.setText(champion.getNombre());
                T_Description.setText(champion.getDescripcion());
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
    
    public boolean loadClientsFromDDBB() {
        boolean cargado = false;
        this.champions.clear();
        try {
            File file = new File(championsXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            // estos métodos podemos usarlos combinados para normalizar el archivo XML
            //getDocumentElement()	Accede al nodo raíz del documento
            //normalize()	Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Champion");   //nList.getLength() -> n_nodos
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //String id=eElement.getAttribute("id");
                    String codChamp = eElement.getElementsByTagName("codChamp").item(0).getTextContent();
                    String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String descripcion = eElement.getElementsByTagName("descripcion").item(0).getTextContent();
                    String p = eElement.getElementsByTagName("p").item(0).getTextContent();
                    String q = eElement.getElementsByTagName("q").item(0).getTextContent();
                    String w = eElement.getElementsByTagName("w").item(0).getTextContent();
                    String e = eElement.getElementsByTagName("e").item(0).getTextContent();
                    String r = eElement.getElementsByTagName("r").item(0).getTextContent();
                    int cod = Integer.parseInt(codChamp);
                    
                    champions c = new champions(cod, nombre, descripcion, p, q, w, e, r);
                    champions.add(c);
                }
            }
            cargado = true;
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (SAXException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return cargado;
    }
}
