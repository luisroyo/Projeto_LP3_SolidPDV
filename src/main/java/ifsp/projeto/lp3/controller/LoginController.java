package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {

  String usuario;
  String senha;


  @FXML
  private Button btn_novoCadastro;
  @FXML
  private Button btn_okLogin;

  @FXML
  private Button btn_sairLogin;

  @FXML
  private TextField tf_login;

  @FXML
  private TextField tf_senha;

  @FXML
  private Label lb_senhaInvalida;

  @FXML
  private AnchorPane tela_login;

  @FXML
  void novoCadastro(ActionEvent event) {
    App.trocaTela("novo");
  }
  @FXML
  void consultaUsuario(ActionEvent event) {
    usuario = tf_login.getText();
    senha = tf_senha.getText();

    if (usuario.equals("luis") && senha.equals("123456")) {
      App.trocaTela("menu");
    } else {
      lb_senhaInvalida.setVisible(true);
    }
  }

  @FXML
  void sairLogin(ActionEvent event) {}
}
