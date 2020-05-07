module com.mycompany.projecytl {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.xml.bind;
    requires java.prefs;
    requires java.sql;
    requires com.h2database;
    
    opens com.mycompany.proyectojavafx.utils to java.xml.bind;
    opens com.mycompany.projecytl.controller to javafx.fxml;
     opens com.mycompany.proyectojavafx.model to java.xml.bind;
     
    exports com.mycompany.projecytl;
    exports com.mycompany.projecytl.model;
    
}
