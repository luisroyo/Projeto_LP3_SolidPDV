package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.dao.UsuarioDAO;
import ifsp.projeto.lp3.model.UsuarioCaixa;
import ifsp.projeto.lp3.model.UsuarioGerente;
import ifsp.projeto.lp3.model.UsuarioInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class UsuarioController implements Initializable {

  UsuarioDAO usuarioDAO = new UsuarioDAO();

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private Button btn_alterar;

  @FXML
  private Button btn_excluir;

  @FXML
  private Button btn_inserir;

  @FXML
  private TableColumn<UsuarioInterface, String> tableColumn_usuarioCpfCnpj;

  @FXML
  private TableColumn<?, ?> tableColumn_UsuarioNome;

  @FXML
  private TableView<?> tabela_usuarios;

  @FXML
  private TextField txt_documento;

  @FXML
  private TextField txt_login;

  @FXML
  private TextField txt_nome;

  @FXML
  private TextField txt_senha;

  @FXML
  private TextField txt_telefone;

  @FXML
  void btn_alterarUsuario(ActionEvent event) {}

  @FXML
  void btn_excluirUsuario(ActionEvent event) {}

  @FXML
  void btn_inserirUsuario(ActionEvent event) {
    UsuarioInterface usuarios;
    if (txt_login.getText().contains("adm")) {
      usuarios =
        new UsuarioGerente(
          txt_nome.getText(),
          txt_login.getText(),
          txt_senha.getText(),
          txt_telefone.getText(),
          txt_documento.getText()
        );
      limpaCampo();
    } else {
      usuarios =
        new UsuarioCaixa(
          txt_nome.getText(),
          txt_login.getText(),
          txt_senha.getText(),
          txt_telefone.getText(),
          txt_documento.getText()
        );
      limpaCampo();
    }
    usuarioDAO.inserir(usuarios);
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {}

  private void limpaCampo() {
    txt_nome.clear();
    txt_login.clear();
    txt_senha.clear();
    txt_telefone.clear();
    txt_documento.clear();
  }

//   public void carregaTabelaUsuario(){
//       if(txt){
//           tableColumn_UsuarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
//           tableColumn_usuarioCpfCnpj.setCellValueFactory(new PropertyValueFactory<>("cpf"));
//       }
//   }
}
