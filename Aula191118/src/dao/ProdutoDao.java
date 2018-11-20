package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;
import util.FabricaConexao;

public class ProdutoDao {

	private static final String LISTARPRODUTOS = "select * from produto order by idProduto asc;";

	public List<Produto> listarProdutos() {
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		try (Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consulta = conexao.prepareStatement(LISTARPRODUTOS);) {

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				Produto Produto = new Produto();
				Produto.setIdProduto(resultado.getInt("IdProduto"));
				Produto.setNome(resultado.getString("nome"));
				Produto.setDescricao(resultado.getString("descricao"));
				Produto.setValor(resultado.getDouble("valor"));
				Produto.setQuantidade(resultado.getDouble("quantidade"));
				Produto.setUnidade(resultado.getString("unidade"));
				lista.add(Produto);
			}

			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}
