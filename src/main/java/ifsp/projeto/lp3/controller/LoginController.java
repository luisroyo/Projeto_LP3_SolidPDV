package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.App;
import ifsp.projeto.lp3.dao.LoginDAO;
import ifsp.projeto.lp3.model.Administrador;
import ifsp.projeto.lp3.model.Funcionario;
import ifsp.projeto.lp3.model.UsuarioInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {

  Connection conexao = null;
  PreparedStatement pst = null;
  ResultSet rs = null;

  String usuario;
  String senha; 

  @FXML
  private Button btn_novoCadastro;

  @FXML
  private Label lbl_status;

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
    
    UsuarioInterface usuario;

    if(tf_login.getText().contains("@adm")){
      usuario = new Administrador(tf_login.getText(), tf_senha.getText());
    }
    else{
     usuario = new Funcionario(tf_login.getText(), tf_senha.getText());
    }

    LoginDAO loginDAO = new LoginDAO();
    
    if(loginDAO.logar(usuario)){
        App.trocaTela("menu");
    }
    else{
        final Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro ao efetuar login!");
        alert.setHeaderText("Login Inválido!");
        alert.setContentText("Usuário ou senha Inválido!");
        alert.setResizable(true);
        alert.showAndWait();
    }
  }

  @FXML
  void sairLogin(ActionEvent event) {}
}
