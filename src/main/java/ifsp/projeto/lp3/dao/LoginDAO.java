package ifsp.projeto.lp3.dao;

import java.sql.*;

public class LoginDAO {

  private Connection connection;

  public boolean logar(String login, String senha) {
    Conexao conexao = new Conexao();
    connection = conexao.getConexao();

    try {
      ResultSet rs = null;
      PreparedStatement pst = null;

      pst =
        connection.prepareStatement(
          "select * from tb_usuario where nome_usuario=? and senha=?"
        );
      pst.setString(1, login);
      pst.setString(2, senha);

      rs = pst.executeQuery();
      if (rs.next()) {
        return true;
      }
      connection.close();
    } catch (Exception e) {
      System.out.println("Erro ao efetuar login!");
    }

    return false;
  }
}
