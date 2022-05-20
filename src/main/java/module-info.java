module ifsp.projeto.lp3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ifsp.projeto.lp3 to javafx.fxml;   
    exports ifsp.projeto.lp3;
    exports ifsp.projeto.lp3.controller;
    exports ifsp.projeto.lp3.model;
    opens ifsp.projeto.lp3.controller to javafx.fxml;
    
}
