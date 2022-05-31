package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuController {

    @FXML
    private Button btn_telaCliente;

    @FXML
    private Button btn_telaFornecedores;

    @FXML
    private Button btn_telaProduto;

    @FXML
    private Button btn_telaRelatorio;

    @FXML
    private Button btn_telaUsuario;

    @FXML
    private Button btn_telaVenda;

    @FXML
    private AnchorPane form_menu;

    @FXML
    void abreTelaCliente(ActionEvent event) {

    }

    @FXML
    void abreTelaFornecedor(ActionEvent event) {

    }

    @FXML
    void abreTelaProduto(ActionEvent event) {
        App.trocaTela("produto");
    }

    @FXML
    void abreTelaRelatorio(ActionEvent event) {

    }

    @FXML
    void abreTelaUsuario(ActionEvent event) {

    }

    @FXML
    void abreTelaVenda(ActionEvent event) {

    }

}
