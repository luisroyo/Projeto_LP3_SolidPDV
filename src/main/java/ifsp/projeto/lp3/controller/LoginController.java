package ifsp.projeto.lp3.controller;

import ifsp.projeto.lp3.App;
import ifsp.projeto.lp3.dao.UsuarioDAO;
import ifsp.projeto.lp3.model.UsuarioGerente;
import ifsp.projeto.lp3.model.UsuarioCaixa;
import ifsp.projeto.lp3.model.UsuarioInterface;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable{

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
  private TextField txt_login;

  @FXML
  private TextField txt_senha;

  @FXML
  private Label lbl_senhaInvalida;

  @FXML
  private AnchorPane tela_login;

  @FXML
  void novoCadastro(ActionEvent event) {  
  }

  @FXML
  void consultaUsuario(ActionEvent event) {
    
    UsuarioInterface usuario;

    if(txt_login.getText().contains("@adm")){
      usuario = new UsuarioGerente(txt_login.getText(), txt_senha.getText());
    }
    else{
     usuario = new UsuarioCaixa(txt_login.getText(), txt_senha.getText());
    }

    UsuarioDAO login = new UsuarioDAO();
    
    if(login.logar(usuario)){
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

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    
    
  }
}
