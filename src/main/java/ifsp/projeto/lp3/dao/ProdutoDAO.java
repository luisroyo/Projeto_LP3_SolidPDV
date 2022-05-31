package ifsp.projeto.lp3.dao;

import ifsp.projeto.lp3.model.Produto;
import ifsp.projeto.lp3.utils.Metodos;
import java.sql.*;
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
    } catch (Exception e) {
      System.out.println("Erro ao cadastrar " + e);
    }
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

    }
    return produtos;
  }
 
}
