package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuController {

    @FXML
    private Button btn_telaProduto;

    @FXML
    private AnchorPane form_menu;

    @FXML
    void abreTelaCadProduto(ActionEvent event) {
        App.trocaTela("produto");
    }

}
