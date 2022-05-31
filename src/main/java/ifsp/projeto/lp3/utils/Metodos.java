package ifsp.projeto.lp3.utils;


import javafx.scene.control.Alert;

public class Metodos {
    
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

    //Limpa campos textField 

    public void limpaCadProduto(){
        
        
    }
    // MENSAGEM DE ERRO BUSCA PRODUTOS

    public void erroBuscaProduto(){
        final Alert alert = new Alert(Alert.AlertType.ERROR);
        // alert.setTitle("Logado com sucesso!");
        alert.setHeaderText("Erro ao buscar produto");
        // alert.setContentText("Usuário ou senha Inválido!");
        alert.setResizable(true);
        alert.showAndWait();
    }
}