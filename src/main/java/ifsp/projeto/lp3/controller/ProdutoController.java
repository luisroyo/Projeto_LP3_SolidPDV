package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.dao.ProdutoDAO;
import ifsp.projeto.lp3.model.Produto;
import ifsp.projeto.lp3.utils.Mensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProdutoController {

  ProdutoDAO produtoDAO = new ProdutoDAO();
  Mensagem msg = new Mensagem();

  @FXML
  private Button btn_buscarProduto;

  @FXML
  private Button btn_cadastrarProduto;

  @FXML
  private Button btn_editarProduto;

  @FXML
  private Button btn_excluirProduto;

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
  void buscaProduto(ActionEvent event) {}

  @FXML
  void cadastraProduto(ActionEvent event) {
    Produto produtos = new Produto(
      tf_descricao.getText(),
      tf_codBarra.getText(),
      Double.parseDouble(tf_valorCusto.getText()),
      Double.parseDouble(tf_valorVenda.getText()),
      Integer.parseInt(tf_estoque.getText()),
      tf_categoria.getText()
    );

    boolean cadastrado = produtoDAO.cadastrarProduto(produtos);

    if (cadastrado) {     
     msg.cadastroProdutoSucesso();
    } else {
      msg.cadastroProdutoNaoRealizado();
    }
  }

  @FXML
  void editaProduto(ActionEvent event) {}

  @FXML
  void excluiProduto(ActionEvent event) {}
}
