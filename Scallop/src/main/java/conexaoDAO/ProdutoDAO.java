package conexaoDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Produto;

public class ProdutoDAO {

	public void cadastrarUsuario(Produto produto) {
		
		String sql = "INSERT INTO PRODUTO (nome_produto, valor_compra, valor_venda, descricao, quantidade) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, produto.getNomeProduto());
			ps.setDouble(2, produto.getValorCompra());
			ps.setDouble(3, produto.getValorVenda());
			ps.setString(4, produto.getDescricao());
			ps.setInt(5, produto.getQuantidade());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}

