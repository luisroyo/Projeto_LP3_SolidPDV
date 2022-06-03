package ifsp.projeto.lp3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ifsp.projeto.lp3.model.Funcionario;
import ifsp.projeto.lp3.model.Usuario;
import ifsp.projeto.lp3.model.Administrador;

import ifsp.projeto.lp3.utils.Metodos;

public class UsuarioDAO {

    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection conn = Conexao.getConexao();
    Metodos msg = new Metodos();

    public boolean logar(String login, String senha) {
        conn = Conexao.getConexao();

        try {

            pst = conn.prepareStatement("select * from tb_usuario where login=? and senha=?");
            pst.setString(1, login);
            pst.setString(2, senha);


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

    public boolean inserir(Usuario usuario) {
        conn = Conexao.getConexao();
        try {
            if (usuario instanceof Funcionario) {
                String sql = "INSERT INTO tb_usuario(nome, login, senha, telefone, cpf) VALUES(?,?,?,?,?)";
                Funcionario caixa = (Funcionario) usuario;
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, caixa.getNome());
                pst.setString(2, caixa.getLogin());
                pst.setString(3, caixa.getSenha());
                pst.setString(4, caixa.getTelefone());
                pst.setString(5, caixa.getCpf());
                pst.execute();

                return true;
            } else if (usuario instanceof Administrador) {
                String sql = "INSERT INTO tb_usuario(nome, login, senha, telefone, cnpj) VALUES(?,?,?,?,?)";
                Administrador gerente = (Administrador) usuario;
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
