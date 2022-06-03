package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.model.Funcionario;
import ifsp.projeto.lp3.model.Usuario;
import ifsp.projeto.lp3.model.Administrador;

import ifsp.projeto.lp3.utils.Metodos;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class LoginController implements Initializable {

  Metodos msg = new Metodos();
  Connection conexao = null;
  PreparedStatement pst = null;
  ResultSet rs = null;

  String usuario;
  String senha;

  @FXML
  private AnchorPane anchorPane;

  @FXML
  private Button btn_novoCadastro;

  @FXML
  private Label lbl_status;

  @FXML
  private Button btn_okLogin;

  @FXML
  private Button btn_sairLogin;

  @FXML
  private TextField txt_login;

  @FXML
  private TextField txt_senha;

  @FXML
  private Label lbl_senhaInvalida;

  @FXML
  private AnchorPane tela_login;

  @FXML
  void novoCadastro(ActionEvent event) {}

  @FXML
  void consultaUsuario(ActionEvent event) throws IOException {
    Usuario usuario;
    if (txt_login.getText().contains("@adm")) {
      usuario = new Administrador(txt_login.getText(), txt_senha.getText());
    } else {
      usuario = new Funcionario(txt_login.getText(), txt_senha.getText());
    }    

    if (usuario.login(txt_login.getText(),txt_senha.getText())) {
            
      Stage stage = (Stage) btn_okLogin.getScene().getWindow();
      FXMLLoader root = new FXMLLoader(LoginController.class.getResource("/ifsp/projeto/lp3/view/Menu.fxml"));
      Scene scene = new Scene(root.load());
      stage.setScene(scene);
      stage.setTitle("Tela Inicial");
      stage.show();
    } else {
     msg.mensagemDeErro("Usuário ou senha inválidos!");
    }
  }

  @FXML
  void sairLogin(ActionEvent event) {}

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {}
}
