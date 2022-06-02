package ifsp.projeto.lp3.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
public class MenuController implements Initializable{

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private MenuItem menuItem_CadastroUsuario;

    @FXML
    private MenuItem menuItem_cadastroCategoria;

    @FXML
    private MenuItem menuItem_cadastroCliente;

    @FXML
    private MenuItem menuItem_cadastroFornecedores;

    @FXML
    private MenuItem menuItem_cadastroProdutos;

    @FXML
    private MenuItem menuItem_graficosMensal;

    @FXML
    private MenuItem menuItem_processosVendas;

    @FXML
    private MenuItem menuItem_relatoriosValorTotalEstoque;

    @FXML
    private MenuItem menuItem_relatoriosValorTotalPorCategoria;

    @FXML
    void abriTelaDeVendas(ActionEvent event) {

    }

    @FXML
    void abriTelaCategoria(ActionEvent event) {

    }

    @FXML
    void abriTelaFornecedores(ActionEvent event) throws IOException{

    }

    @FXML
    void abriTelaUsuario(ActionEvent event) throws IOException {
        AnchorPane telaCadastroUsuario =(AnchorPane) 
        FXMLLoader.load(getClass().getResource("/ifsp/projeto/lp3/view/Usuario.fxml"));
        anchorPane.getChildren().setAll(telaCadastroUsuario); 
    }


    @FXML
    void abriTelaProduto(ActionEvent event) throws IOException {          
        AnchorPane telaCadPro =(AnchorPane) 
        FXMLLoader.load(getClass().getResource("/ifsp/projeto/lp3/view/Produto.fxml"));
        anchorPane.getChildren().setAll(telaCadPro);            
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {        
      
        
    }   
}
