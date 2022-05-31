package ifsp.projeto.lp3.dao;

import java.sql.*;

public class Conexao {

  public Conexao() {}

  public static Connection getConexao() {
    String url ="jdbc:mysql://localhost:3306/db_solid_pdv_lp3?serverTimezone-UTC";
    String usuario = "root";
    String password = "";
    try {
      Connection conn = DriverManager.getConnection(url, usuario, password);
      return conn;
    } catch (Exception e) {
      System.out.println("Erro ao conectar " + e.getMessage());
      return null;
    }
  }
}
