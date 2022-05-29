package ifsp.projeto.lp3.dao;

import ifsp.projeto.lp3.model.Produto;
import java.sql.*;

public class ProdutoDAO {

  public boolean cadastrarProduto(Produto produto) {
    Connection conn = Conexao.getConexao();
    PreparedStatement pst = null;


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
}
