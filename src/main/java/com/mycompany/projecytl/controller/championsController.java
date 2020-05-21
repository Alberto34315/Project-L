/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projecytl.controller;

import com.mycompany.projecytl.DAO.championsDao;
import com.mycompany.projecytl.Utils.ConnectionUtils;
import com.mycompany.projecytl.model.champions;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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

    Connection con;
    private ObservableList<champions> champs;

    private Set<champions> champions;

    private final static String championsXML = "champions.xml";

    private final static String imgAatrox = "src/main/resources/assets/Champons/aatrox.jpg";
    private final static String imgAhri = "src/main/resources/assets/Champons/ahri.jpg";
    private final static String imgBraum = "src/main/resources/assets/Champons/braum.jpg";
    private final static String imgCaitlyn = "src/main/resources/assets/Champons/caitlyn.jpg";
    private final static String imgLeesin = "src/main/resources/assets/Champons/leesin.jpg";
    private final static String imgTrundle = "src/main/resources/assets/Champons/trundle.jpg";

    public championsController() {
        this.champions = new HashSet<>();
        this.champs = FXCollections.observableArrayList();
    }

//    @FXML
//    public Button aatrox;
//
//    @FXML
//    public Button aatrox;
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
        try {
            con = ConnectionUtils.connect(AppController.currentConnection);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(championsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(championsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadChampionsFromXML();
        loadChampionsFromDB();
        //loadChampionsFromDB();
    }

    @FXML
    public void showAatrox() {
        skills.getItems().clear();
        for (champions champion : champions) {
            if (champion.getNombre().equals("Aatrox")) {
                //img =  new ImageView(imgAatrox);
                File file = new File(imgAatrox);
                Image image = new Image(file.toURI().toString());
                img.setImage(image);
                L_name.setText(champion.getNombre());
                T_Description.setText(champion.getDescription());
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

    @FXML
    public void showAhri() {
        skills.getItems().clear();
        for (champions champion : champions) {
            if (champion.getNombre().equals("Ahri")) {
                //img =  new ImageView(imgAatrox);
                File file = new File(imgAhri);
                Image image = new Image(file.toURI().toString());
                img.setImage(image);
                L_name.setText(champion.getNombre());
                T_Description.setText(champion.getDescription());
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

    @FXML
    public void showBraum() {
        skills.getItems().clear();
        for (champions champion : champions) {
            if (champion.getNombre().equals("Braum")) {
                //img =  new ImageView(imgAatrox);
                File file = new File(imgBraum);
                Image image = new Image(file.toURI().toString());
                img.setImage(image);
                L_name.setText(champion.getNombre());
                T_Description.setText(champion.getDescription());
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

    @FXML
    public void showCaitlyn() {
        skills.getItems().clear();
        for (champions champion : champions) {
            if (champion.getNombre().equals("Caitlyn")) {
                //img =  new ImageView(imgAatrox);
                File file = new File(imgCaitlyn);
                Image image = new Image(file.toURI().toString());
                img.setImage(image);
                L_name.setText(champion.getNombre());
                T_Description.setText(champion.getDescription());
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

    @FXML
    public void showLeesin() {
        skills.getItems().clear();
        for (champions champion : champions) {
            if (champion.getNombre().equals("Lee Sin")) {
                //img =  new ImageView(imgAatrox);
                File file = new File(imgLeesin);
                Image image = new Image(file.toURI().toString());
                img.setImage(image);
                L_name.setText(champion.getNombre());
                T_Description.setText(champion.getDescription());
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

    @FXML
    public void showTrundle() {
        skills.getItems().clear();
        for (champions champion : champions) {
            if (champion.getNombre().equals("Trundle")) {
                //img =  new ImageView(imgAatrox);
                File file = new File(imgTrundle);
                Image image = new Image(file.toURI().toString());
                img.setImage(image);
                L_name.setText(champion.getNombre());
                T_Description.setText(champion.getDescription());
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

    public boolean loadChampionsFromXML() {
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

    public boolean saveChampionsFromDDBB(champions cha) {
        boolean guardado = false;
        try {

            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build;

            build = dFact.newDocumentBuilder();
            List<champions> lChamp = championsDao.getAll(con);
            org.w3c.dom.Document doc = build.newDocument();
            Element raiz = doc.createElement("Champions");
            for (champions c : lChamp) {

                Element e = doc.createElement("Champion");
               // if (c.getNombre().equals(cha.getNombre())) {
                    String codigo = String.valueOf(c.getCodChamp());
                    Element k = doc.createElement("codChamp");
                    k.appendChild(doc.createTextNode(codigo));
                    e.appendChild(k);
               // }
                Element name = doc.createElement("nombre");
                name.appendChild(doc.createTextNode(c.getNombre()));
                e.appendChild(name);
                Element des = doc.createElement("descripcion");
                des.appendChild(doc.createTextNode(c.getDescription()));
                e.appendChild(des);
                Element p = doc.createElement("p");
                p.appendChild(doc.createTextNode(c.getP()));
                e.appendChild(p);
                Element q = doc.createElement("q");
                q.appendChild(doc.createTextNode(c.getQ()));
                e.appendChild(q);
                Element w = doc.createElement("w");
                w.appendChild(doc.createTextNode(c.getW()));
                e.appendChild(w);
                Element es = doc.createElement("e");
                es.appendChild(doc.createTextNode(c.getE()));
                e.appendChild(es);
                Element r = doc.createElement("r");
                r.appendChild(doc.createTextNode(c.getR()));
                e.appendChild(r);

                raiz.appendChild(e);

            }
            doc.appendChild(raiz);

            //Guardar el xml en el disco duro
            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer trans = tFact.newTransformer();
            //<-- OPCIONES DEL ARCHIVO
            trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty("{http://xml.apache.org/xlst}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(championsXML));

            trans.transform(source, result);
            guardado = true;

        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
        } catch (TransformerConfigurationException ex) {
            System.out.println(ex);
        } catch (TransformerException ex) {
            System.out.println(ex);

        }
        return guardado;
    }

    public void loadChampionsFromDB() {
        for (champions champ : champions) {
            champs.add(champ);
            championsDao dao = new championsDao(champ);
            int newId = dao.save();
            champ.setCodChamp(newId);
            saveChampionsFromDDBB(champ);
        }
    }
}
