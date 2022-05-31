package ifsp.projeto.lp3.dao;

import java.sql.*;
import ifsp.projeto.lp3.model.Administrador;
import ifsp.projeto.lp3.model.Funcionario;
import ifsp.projeto.lp3.model.UsuarioInterface;
import ifsp.projeto.lp3.utils.Metodos;
public class LoginDAO {
  ResultSet rs = null;
  PreparedStatement pst = null;
  Connection conn = Conexao.getConexao();

  public boolean logar(UsuarioInterface usuario) {
    Metodos msg = new Metodos();    
    conn = Conexao.getConexao();

    try { 
      if(usuario instanceof Administrador){
        Administrador adm = (Administrador) usuario;
        pst =conn.prepareStatement("select * from tb_usuario where login=? and senha=?");
        pst.setString(1, adm.getLogin());
        pst.setString(2, adm.getSenha());
        msg.logadoUsuarioAdm();
      }
      else{
        Funcionario funcionario = (Funcionario) usuario;
        pst =conn.prepareStatement("select * from tb_usuario where login=? and senha=?");
        pst.setString(1, funcionario.getLogin());
        pst.setString(2, funcionario.getSenha());
        msg.logadoUsuarioComum();
      }

      rs = pst.executeQuery();
      if (rs.next()) {
        
        return true;
      }
      conn.close();
    } catch (Exception e) {
      System.out.println("Erro ao efetuar login!");
    }

    return false;
  }
}
