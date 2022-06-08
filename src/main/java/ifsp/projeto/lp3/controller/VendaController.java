package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class VendaController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lbl_caixaAberto;

    @FXML
    private Label lbl_subtotalCompra;

    @FXML
    private Label lbl_totalItem;

    @FXML
    private Label lbl_troco;

    @FXML
    private Label lbl_valorUnitarioItem;

    @FXML
    private TableView<Produto> tabela_itensSelecionados;

    @FXML
    private TableColumn<Produto, String> table_colCodBarra;

    @FXML
    private TableColumn<Produto, String> table_colDescricao;

    @FXML
    private TableColumn<?, ?> table_colNumeroDoItem;

    @FXML
    private TableColumn<?, ?> table_colQtdDeItem;

    @FXML
    private TableColumn<?, ?> table_colSubtotalItem;

    @FXML
    private TableColumn<?, ?> table_colValorUnitarioItem;

    @FXML
    private TextField txt_codigoDeBarra;

    @FXML
    private TextField txt_valorRecebido;

    @FXML
    void cancelaCompra(ActionEvent event) {

    }

    @FXML
    void finalizaCompra(ActionEvent event) {

    }

}
