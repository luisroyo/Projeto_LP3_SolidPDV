package ifsp.projeto.lp3.dao;

import ifsp.projeto.lp3.model.UsuarioCaixa;
import ifsp.projeto.lp3.model.UsuarioGerente;
import ifsp.projeto.lp3.model.UsuarioInterface;
import ifsp.projeto.lp3.utils.Metodos;
import java.sql.*;

public class UsuarioDAO {

  ResultSet rs = null;
  PreparedStatement pst = null;
  Connection conn = Conexao.getConexao();
  Metodos msg = new Metodos();

  public boolean logar(UsuarioInterface usuario) {
    conn = Conexao.getConexao();

    try {
      if (usuario instanceof UsuarioGerente) {
        UsuarioGerente adm = (UsuarioGerente) usuario;
        pst =
          conn.prepareStatement(
            "select * from tb_usuario where login=? and senha=?"
          );
        pst.setString(1, adm.getLogin());
        pst.setString(2, adm.getSenha());
      }
      if (usuario instanceof UsuarioCaixa) {
        UsuarioCaixa funcionario = (UsuarioCaixa) usuario;
        pst =
          conn.prepareStatement(
            "select * from tb_usuario where login=? and senha=?"
          );
        pst.setString(1, funcionario.getLogin());
        pst.setString(2, funcionario.getSenha());
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

  public boolean inserir(UsuarioInterface usuario) {
    conn = Conexao.getConexao();
    try {
      if (usuario instanceof UsuarioCaixa) {
        String sql =
          "INSERT INTO tb_usuario(nome, login, senha, telefone, cpf) VALUES(?,?,?,?,?)";
        UsuarioCaixa caixa = (UsuarioCaixa) usuario;
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, caixa.getNome());
        pst.setString(2, caixa.getLogin());
        pst.setString(3, caixa.getSenha());
        pst.setString(4, caixa.getTelefone());
        pst.setString(5, caixa.getCpf());
        pst.execute();
        msg.mensagemDeSucesso("Usuário inserido com sucesso!");
        return true;
      }
      if (usuario instanceof UsuarioGerente) {
        String sql =
          "INSERT INTO tb_usuario(nome, login, senha, telefone, cnpj) VALUES(?,?,?,?,?)";
        UsuarioGerente gerente = (UsuarioGerente) usuario;
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, gerente.getNome());
        pst.setString(2, gerente.getLogin());
        pst.setString(3, gerente.getSenha());
        pst.setString(4, gerente.getTelefone());
        pst.setString(5, gerente.getCnpj());
        pst.execute();
        return true;
      }
    } catch (SQLException ex) {
      msg.mensagemDeErro("Erro ao cadastrar usuário");
    }
    return false;
  }
  // public boolean alterar(Cliente cliente) {
  //     String sql = "UPDATE clientes SET nome=?, cpf=?, telefone=? WHERE cdCliente=?";
  //     try {
  //         PreparedStatement pst = conn.prepareStatement(sql);
  //         pst.setString(1, cliente.getNome());
  //         pst.setString(2, cliente.getCpf());
  //         pst.setString(3, cliente.getTelefone());
  //         pst.setInt(4, cliente.getCdCliente());
  //         pst.execute();
  //         return true;
  //     } catch (SQLException ex) {
  //         Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
  //         return false;
  //     }
  // }

  // public boolean remover(Cliente cliente) {
  //     String sql = "DELETE FROM clientes WHERE cdCliente=?";
  //     try {
  //         PreparedStatement pst = conn.prepareStatement(sql);
  //         pst.setInt(1, cliente.getCdCliente());
  //         pst.execute();
  //         return true;
  //     } catch (SQLException ex) {
  //         Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
  //         return false;
  //     }
  // }

  // public List<UsuarioInterface> listar() {
  //     String sql = "SELECT * FROM tb_usuario";
  //     List<UsuarioInterface> retorno = new ArrayList<>();
  //     try {
  //         PreparedStatement pst = conn.prepareStatement(sql);
  //         ResultSet resultado = pst.executeQuery();
  //         while (resultado.next()) {
  //           if(retorno instanceof UsuarioCaixa)
  //             UsuarioInterface usuario;
  //             usuario.setI(resultado.getInt("cdusuario"));
  //             usuario.setNome(resultado.getString("nome"));
  //             usuario.setCpf(resultado.getString("cpf"));
  //             usuario.setTelefone(resultado.getString("telefone"));
  //             retorno.add(usuario);
  //         }
  //     } catch (SQLException ex) {
  //         Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
  //     }
  //     return retorno;
  // }

  // public usuario buscar(Cliente cliente) {
  //     String sql = "SELECT * FROM clientes WHERE cdCliente=?";
  //     Cliente retorno = new Cliente();
  //     try {
  //         PreparedStatement pst = conn.prepareStatement(sql);
  //         pst.setInt(1, cliente.getCdCliente());
  //         ResultSet resultado = pst.executeQuery();
  //         if (resultado.next()) {
  //             cliente.setNome(resultado.getString("nome"));
  //             cliente.setCpf(resultado.getString("cpf"));
  //             cliente.setTelefone(resultado.getString("telefone"));
  //             retorno = cliente;
  //         }
  //     } catch (SQLException ex) {
  //         Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
  //     }
  //     return retorno;
  // }

}
