package ifsp.projeto.lp3.dao;

import ifsp.projeto.lp3.model.Produto;
import ifsp.projeto.lp3.utils.Metodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

  Connection conn = Conexao.getConexao();
  PreparedStatement pst = null;
  ResultSet rs = null;
  Metodos msg = new Metodos();
  ArrayList<Produto> produtos = new ArrayList<>();

  public boolean cadastrarProduto(Produto produto) {
    try {
      String sql =
        "insert into tb_cad_produto(cod_barra, descricao, preco_custo, preco_venda, qtd_estoque,categoria)values(?,?,?,?,?,?);";
      pst = conn.prepareStatement(sql);
      pst.setString(1, produto.getCodigoBarra());
      pst.setString(2, produto.getNome());
      pst.setDouble(3, produto.getPrecoCusto());
      pst.setDouble(4, produto.getPrecoVenda());
      pst.setInt(5, produto.getQuantidadeEstoque());
      pst.setString(6, produto.getCategoria());

      if (!pst.execute()) {
        return true;
      }
    } catch (Exception e) {}
    return false;
  }

  public ArrayList<Produto> listarProduto() {
    String sql = "select * from tb_cad_produto";

    try {
      pst = conn.prepareStatement(sql);
      rs = pst.executeQuery();

      while (rs.next()) {
        Produto produto = new Produto();

        produto.setCodigoBarra(rs.getString("cod_barra"));
        produto.setNome(rs.getString("descricao"));
        produto.setPrecoCusto(rs.getDouble("preco_custo"));
        produto.setPrecoVenda(rs.getDouble("preco_venda"));
        produto.setQuantidadeEstoque(rs.getInt("qtd_estoque"));
        produto.setCategoria(rs.getString("categoria"));

        produtos.add(produto);
      }
    } catch (Exception e) {
      msg.mensagemDeErro("Erro ao listar os produtos!");
    }
    return produtos;
  }

  public Produto buscarProdutoPorCodBarra(Produto produto) {
    String sql = "select * from tb_cad_produto where cod_barra =?";
    Produto retorno = new Produto();

    try {
      pst = conn.prepareStatement(sql);
      pst.setString(1, produto.getCodigoBarra());
      rs = pst.executeQuery();
      if (rs.next()) {
        retorno.setCodigoBarra(rs.getString("cod_barra"));
        retorno.setNome(rs.getString("descricao"));
        retorno.setPrecoCusto(rs.getDouble("preco_custo"));
        retorno.setPrecoVenda(rs.getDouble("preco_venda"));
        retorno.setQuantidadeEstoque(rs.getInt("qtd_estoque"));
        retorno.setCategoria(rs.getString("categoria"));
      }
    } catch (Exception ex) {
      msg.mensagemDeErro("Produto não encontrado");
    }
    return retorno;
  }

  

  public void editaProduto(Produto produto) {
    String sql =
      "update tb_cad_produto set descricao =?,preco_custo=?,preco_venda=?,qtd_estoque=?,categoria=? where cod_barra =?;";

    try {
      pst = conn.prepareStatement(sql);

      pst.setString(1, produto.getNome());
      pst.setDouble(2, produto.getPrecoCusto());
      pst.setDouble(3, produto.getPrecoVenda());
      pst.setInt(4, produto.getQuantidadeEstoque());
      pst.setString(5, produto.getCategoria());
      pst.setString(6, produto.getCodigoBarra());

      pst.execute();
      pst.close();
    } catch (Exception e) {
      System.out.println("Erro na atulização " + e);
    }
  }

  public boolean remover(Produto produto) {
    String sql = "DELETE FROM tb_cad_produto WHERE cod_barra=?";
    try {
      pst = conn.prepareStatement(sql);
      pst.setString(1, produto.getCodigoBarra());
      pst.execute();
      msg.mensagemDeConfirmacao("Deseja excluir este produto?");
      return true;
    } catch (SQLException ex) {
      msg.mensagemDeErro("Produto não pode ser excluido!");;
      return false;
    }
  }
}
