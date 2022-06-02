package ifsp.projeto.lp3;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

  private static Stage stage;
  private static Scene telaLogin;
  private static Scene telaMenu;
  private static Scene telaUsuario;  

  @Override
  public void start(Stage primaryStage) throws IOException {
    FXMLLoader fxmlLogin = new FXMLLoader(
      getClass().getResource("view/Login.fxml")
    );
    FXMLLoader fxmlMenu = new FXMLLoader(
      getClass().getResource("view/Menu.fxml")
    );
    FXMLLoader fxmlUsuario = new FXMLLoader(
      getClass().getResource("view/Usuario.fxml")
    );
   
    stage = primaryStage;
    stage.setTitle("SolidPDV");
    

    Parent parentLogin = fxmlLogin.load();
    Parent parentMenu = fxmlMenu.load();
    Parent parentUsuario = fxmlUsuario.load();
    

    telaLogin = new Scene(parentLogin, 510, 285);
    telaMenu = new Scene(parentMenu, 600, 400);
    telaUsuario = new Scene(parentUsuario, 415, 400);
   

    primaryStage.setScene(telaLogin);
    primaryStage.show();
  }

  public static void trocaTela(String scr) {
    switch (scr) {
      case "login":
        stage.setScene(telaLogin);
        break;
      case "menu":
        stage.setScene(telaMenu);
        break;
      case "usuario":
        stage.setScene(telaUsuario);
        break;     
    }
  }

  public static void main(String[] args) {
    launch();
  }
}
