package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.dao.ProdutoDAO;
import ifsp.projeto.lp3.model.Produto;
import ifsp.projeto.lp3.utils.Metodos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ProdutoController implements Initializable {

  public ProdutoController() {}

  String codigoBarra, descricao, categoria;
  Integer qtdEstoque;
  Double precoCusto, precoVenda;

  ProdutoDAO produtoDAO = new ProdutoDAO();
  Metodos msg = new Metodos();

  @FXML
  private Button btn_listaProduto;

  @FXML
  private Button btn_cadastrarProduto;

  @FXML
  private Button btn_editarProduto;

  @FXML
  private Button btn_excluirProduto;

  @FXML
  private Button btn_buscaProduto;

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
  private TextField txt_categoria;

  @FXML
  private TextField txt_codBarra;

  @FXML
  private TextField txt_descricao;

  @FXML
  private TextField txt_estoque;

  @FXML
  private TextField txt_valorCusto;

  @FXML
  private TextField txt_valorVenda;

  @FXML
  void listaProdutos(ActionEvent event) {
    iniciarTabelaProdutos();
  }

  @FXML
  void buscaProdutoPorCodBarra(ActionEvent event) {}

  @FXML
  void cadastraProduto(ActionEvent event) {
    Produto produtos = new Produto(
      txt_codBarra.getText(),
      txt_descricao.getText(),
      Double.parseDouble(txt_valorCusto.getText()),
      Double.parseDouble(txt_valorVenda.getText()),
      Integer.parseInt(txt_estoque.getText()),
      txt_categoria.getText()
    );

    boolean cadastrado = produtoDAO.cadastrarProduto(produtos);
    if (cadastrado) {
      msg.mensagemDeSucesso("Produto cadastrado com sucesso!");
    } else {
      msg.mensagemDeErro("Erro ao inserir produto, verifique os dados corretamente!");
    }
    limpaCampo();
  }

  @FXML
  void editaProduto(ActionEvent event) {
    alterarProduto();
  }

  @FXML
  void excluiProduto(ActionEvent event) {
    Produto produto = tabela_produtos.getSelectionModel().getSelectedItem();
    if (produto != null) {
      produtoDAO.remover(produto);
    }
  }

  private void limpaCampo() {
    txt_codBarra.clear();
    txt_categoria.clear();
    txt_estoque.clear();
    txt_valorCusto.clear();
    txt_valorVenda.clear();
    txt_descricao.clear();
  }

  // private void limpaTabela() {
  //   tabela_produtos.getItems().clear();
  //   col_codBarra.getColumns().clear();
  //   col_descricao.getColumns().clear();
  //   col_valorCusto.getColumns().clear();
  //   col_valorVenda.getColumns().clear();
  //   col_qtdEstoque.getColumns().clear();
  //   col_valorCategoria.getColumns().clear();
  // }

  private void iniciarTabelaProdutos() {
    col_codBarra.setCellValueFactory(new PropertyValueFactory<>("codigoBarra"));
    col_descricao.setCellValueFactory(new PropertyValueFactory<>("nome"));
    col_valorCusto.setCellValueFactory(
      new PropertyValueFactory<>("precoCusto")
    );
    col_valorVenda.setCellValueFactory(
      new PropertyValueFactory<>("precoVenda")
    );
    col_qtdEstoque.setCellValueFactory(
      new PropertyValueFactory<>("quantidadeEstoque")
    );
    col_valorCategoria.setCellValueFactory(
      new PropertyValueFactory<>("categoria")
    );
    tabela_produtos.setItems(atualizaTabela());
  }

  public ObservableList<Produto> atualizaTabela() {
    return FXCollections.observableArrayList(produtoDAO.listarProduto());
  }

  private void alterarProduto() {
    Produto produtos = new Produto();
    descricao = txt_descricao.getText();
    precoCusto = Double.parseDouble(txt_valorCusto.getText());
    precoVenda = Double.parseDouble(txt_valorCusto.getText());
    categoria = txt_categoria.getText();
    qtdEstoque = Integer.parseInt(txt_estoque.getText());
    codigoBarra = txt_codBarra.getText();

    produtos.setNome(descricao);
    produtos.setPrecoCusto(precoCusto);
    produtos.setPrecoVenda(precoVenda);
    produtos.setCategoria(categoria);
    produtos.setQuantidadeEstoque(qtdEstoque);
    produtos.setCodigoBarra(codigoBarra);

    produtoDAO.editaProduto(produtos);
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    iniciarTabelaProdutos();
  }
}
