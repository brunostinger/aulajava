package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import model.Livro;
import util.FabricaConexao;

public class LivroDao {

	private static final String OBTER_POR_ID_SQL = "SELECT * FROM LIVRO WHERE COD_LIVRO = ?";
	private static final String CONSULTAR_SQL = "SELECT * FROM LIVRO WHERE TITULO LIKE ?";
	private static final String LISTAR_TODOS = "SELECT * FROM LIVRO ORDER BY COD_LIVRO ASC";
	private static final String UPDATE_SQL = "UPDATE LIVRO SET TITULO = ?, AUTOR = ?, DESCRICAO = ?, PRECO = ? WHERE COD_LIVRO = ?";
	private static final String INSERT_SQL="Insert into livro (titulo, autor, preco, imagem) values(?,?,?,?);";
	private static final String DELETE_SQL="DELETE FROM LIVRO WHERE COD_LIVRO = ?";

	public Livro consultar(int codigo) {
		Livro livro = null;
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(OBTER_POR_ID_SQL);) {
//			PreparedStatement consulta = conexao.prepareStatement(Sql.OBTER_POR_ID_SQL.getSql());) {
			consulta.setInt(1, codigo);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {
				livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
			}

			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}

	public List<Livro> consultar(String titulo) {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_SQL);) {
			consulta.setString(1, "%" + titulo.toUpperCase() + "%");

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				Livro livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
				lista.add(livro);
			}

			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public List<Livro> listarTodos() {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(LISTAR_TODOS);) {

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				Livro livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
				lista.add(livro);
			}

			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void updateTitulo(Livro livro) {

			try (Connection conexao = FabricaConexao.getConexao();
			PreparedStatement consulta = conexao.prepareStatement(UPDATE_SQL);) {

			consulta.setString(1, livro.getTitulo());
			consulta.setString(2, livro.getAutor());
			consulta.setString(3, livro.getDescricao());
			consulta.setDouble(4, livro.getPreco());
			consulta.setInt(5, livro.getCodigo());

			consulta.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletarLivro(Integer id) {

		try (Connection conexao = FabricaConexao.getConexao();
		  PreparedStatement consulta = conexao.prepareStatement(DELETE_SQL);) {

			consulta.setInt(1, id);
			consulta.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inserir (Livro livro){		
		try {
		Connection con = FabricaConexao.getConexao();
		PreparedStatement ps = con.prepareStatement(INSERT_SQL);	
		
		ps.setString(1, livro.getTitulo());
		ps.setString(2, livro.getAutor());
		ps.setDouble(3, livro.getPreco());
		ps.setString(4, livro.getImagem());
		
		ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public void save(Contato contato) {
//		/*
//		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
//		 * de dados
//		 */
//		String sql = "INSERT INTO contatos(nome, idade, dataCadastro)" + " VALUES(?,?,?)";
//
//		try (Connection conexao = FabricaConexao.getConexao();
//				PreparedStatement consulta = conexao.prepareStatement(sql);){
//
//			// Adiciona o valor do primeiro parâmetro da sql
//			consulta.setString(1, contato.getNome());
//			// Adicionar o valor do segundo parâmetro da sql
//			consulta.setInt(2, contato.getIdade());
//			// Adiciona o valor do terceiro parâmetro da sql
//			consulta.setDate(3, new Date(contato.getDataCadastro().getTime()));
//
//			// Executa a sql para inserção dos dados
//			consulta.execute();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
