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

	private static final String LISTARPRODUTOS_SQL  = "select * from produto order by idProduto asc;";
	private static final String BUSCARDADOSPRODUTO_SQL = "select * from produto where idProduto=?;";
	private static final String INSERT_SQL="Insert into produto (nome, descricao, valor, quantidade,unidade) values(?,?,?,?,?);";
	private static final String UPDATE_SQL = "update produto SET nome = ?, descricao = ?, valor = ?, quantidade = ?, unidade=? WHERE idProduto = ?;";
	private static final String FILTRARPRODUTO_SQL = "SELECT * FROM produto WHERE  ( nome ILIKE ? or descricao ILIKE ? ) order by idProduto ASC";
	private static final String DELETE_SQL="DELETE FROM produto WHERE idProduto = ?;";

	public List<Produto> listarProdutos() {
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		try (Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consulta = conexao.prepareStatement(LISTARPRODUTOS_SQL);) {

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
	
	public List<Produto> filtrarProdutos(String filtro) {
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		try (Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consulta = conexao.prepareStatement(FILTRARPRODUTO_SQL);) {
			consulta.setString(1, "%" + filtro + "%");
			consulta.setString(2, "%" + filtro + "%");

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
	

	public void deletarProduto(Integer id) {

		try (Connection conexao = FabricaConexao.getConexao();
		  PreparedStatement consulta = conexao.prepareStatement(DELETE_SQL);) {

			consulta.setInt(1, id);
			consulta.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Produto buscarProduto(int idProduto) {
		
		Produto produto = null;
		try (Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consulta = conexao.prepareStatement(BUSCARDADOSPRODUTO_SQL );) {
			consulta.setInt(1, idProduto);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {
				
				produto = new Produto();
				produto.setIdProduto(resultado.getInt("IdProduto"));
				produto.setNome(resultado.getString("nome"));
				produto.setDescricao(resultado.getString("descricao"));
				produto.setValor(resultado.getDouble("valor"));
				produto.setQuantidade(resultado.getDouble("quantidade"));
				produto.setUnidade(resultado.getString("unidade"));
			}

			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}
	
	

	public void inserir (Produto produto){		
		try {
		Connection con = FabricaConexao.getConexao();
		PreparedStatement ps = con.prepareStatement(INSERT_SQL);	
		
		ps.setString(1, produto.getNome().toUpperCase());
		ps.setString(2, produto.getDescricao().toUpperCase());
		ps.setDouble(3, produto.getValor());
		ps.setDouble(4, produto.getQuantidade());
		ps.setString(5, produto.getUnidade().toUpperCase());

		ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarProduto(Produto produto) {
		
		
		try (Connection conexao = FabricaConexao.getConexao();
		PreparedStatement consulta = conexao.prepareStatement(UPDATE_SQL);) {

		consulta.setString(1, produto.getNome().toUpperCase());
		consulta.setString(2, produto.getDescricao().toUpperCase());
		consulta.setDouble(3, produto.getValor());
		consulta.setDouble(4, produto.getQuantidade());
		consulta.setString(5, produto.getUnidade().toUpperCase());
		consulta.setInt(6, produto.getIdProduto());

		consulta.execute();

	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}
	
}
