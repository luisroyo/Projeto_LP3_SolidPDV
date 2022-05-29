package ifsp.projeto.lp3.utils;

import javafx.scene.control.Alert;

public class Mensagem {
    
    //CADASTRO DE PRODUTO
    public void cadastroProdutoSucesso(){
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro Realizado!");
        alert.setHeaderText("Cadastro realizado com sucesso!");
        // alert.setContentText("Usuário ou senha Inválido!");
        alert.setResizable(true);
        alert.showAndWait();
    }

    public void cadastroProdutoNaoRealizado(){
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro não realizado!");
        alert.setHeaderText("Cadastro não realizado!");
        // alert.setContentText("Usuário ou senha Inválido!");
        alert.setResizable(true);
        alert.showAndWait();
    }


    //LOGIN USUARIO

    public void logadoUsuarioComum(){
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // alert.setTitle("Logado com sucesso!");
        alert.setHeaderText("Usuário Comum!");
        // alert.setContentText("Usuário ou senha Inválido!");
        alert.setResizable(true);
        alert.showAndWait();
    }
    public void logadoUsuarioAdm(){
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // alert.setTitle("Logado com sucesso!");
        alert.setHeaderText("Usuário Administrativo!");
        // alert.setContentText("Usuário ou senha Inválido!");
        alert.setResizable(true);
        alert.showAndWait();
    }
}