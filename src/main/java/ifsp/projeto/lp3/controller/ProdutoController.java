package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.dao.ProdutoDAO;
import ifsp.projeto.lp3.model.Produto;
import ifsp.projeto.lp3.utils.Metodos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ProdutoController {

  ProdutoDAO produtoDAO = new ProdutoDAO();
  Metodos msg = new Metodos();

  @FXML
  private Button btn_buscarProduto;

  @FXML
  private Button btn_cadastrarProduto;

  @FXML
  private Button btn_editarProduto;

  @FXML
  private Button btn_excluirProduto;

  @FXML
  private TableColumn<Produto, String> col_codBarra;

  @FXML
  private TableColumn<Produto, String> col_descricao;

  @FXML
  private TableColumn<Produto, Integer> col_qtdEstoque;

  @FXML
  private TableColumn<Produto, Double> col_valorCategoria;

  @FXML
  private TableColumn<Produto, Double> col_valorCusto;

  @FXML
  private TableColumn<Produto, Double> col_valorVenda;

  @FXML
  private TableView<Produto> tabela_produtos;

  @FXML
  private AnchorPane telaCadastroProduto;

  @FXML
  private TextField tf_categoria;

  @FXML
  private TextField tf_codBarra;

  @FXML
  private TextField tf_descricao;

  @FXML
  private TextField tf_estoque;

  @FXML
  private TextField tf_valorCusto;

  @FXML
  private TextField tf_valorVenda;


  @FXML
  void buscaProduto(ActionEvent event) {
    iniciarTabela();
  }

  @FXML
  void cadastraProduto(ActionEvent event) {
    Produto produtos = new Produto(
      tf_codBarra.getText(),
      tf_descricao.getText(),      
      Double.parseDouble(tf_valorCusto.getText()),
      Double.parseDouble(tf_valorVenda.getText()),
      Integer.parseInt(tf_estoque.getText()),
      tf_categoria.getText());

    boolean cadastrado = produtoDAO.cadastrarProduto(produtos);
    if (cadastrado) {     
     msg.cadastroProdutoSucesso();
    } else {
      msg.cadastroProdutoNaoRealizado();
    }
    limpaCampo();
  }

  @FXML
  void editaProduto(ActionEvent event) {}

  @FXML
  void excluiProduto(ActionEvent event) {}

  private void limpaCampo(){
    tf_codBarra.clear();
    tf_categoria.clear();
    tf_estoque.clear();  
    tf_valorCusto.clear();
    tf_valorVenda.clear();
    tf_descricao.clear();
  }


  private void iniciarTabela(){
    
    col_codBarra.setCellValueFactory(new PropertyValueFactory<>("codigoBarra"));
    col_descricao.setCellValueFactory(new PropertyValueFactory<>("nome"));
    col_valorCusto.setCellValueFactory(new PropertyValueFactory<>("precoCusto"));
    col_valorVenda.setCellValueFactory(new PropertyValueFactory<>("precoVenda"));
    col_qtdEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));
    col_valorCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    tabela_produtos.setItems(atualizaTabela());
  }

  public ObservableList<Produto> atualizaTabela(){
    

    return FXCollections.observableArrayList(produtoDAO.listarProduto());
    
  }
  
}

