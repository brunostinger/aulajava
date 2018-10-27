package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.conexao.FabricaConexao;
import com.web.modelo.Cliente;

public class ClienteDAO {
	
	private static final String SELECT_SQL="select nome, senha, login, endereco, cidade, bairro from cliente where senha=? and login =?;";
	private static final String UPDATE_SQL="update cliente set nome=?, endereco=?, cidade=?, bairro=? where id=?;";
	private static final String INSERT_SQL="insert into cliente (Nome,Senha,Login,Endereco,Cidade,bairro) values (?,?,?,?,?,?);";
	private static final String DELETE_SQL="delete from cliente where id=?;";
	
	
	public Cliente obter(Cliente cliente) {
		
		try {
			
			Connection con = FabricaConexao.getConexao();
			PreparedStatement consulta = con.prepareStatement(SELECT_SQL);
			consulta.setString(1, cliente.getSenha());
			consulta.setString(2, cliente.getLogin());

			ResultSet rs = consulta.executeQuery();
			
			if(rs.next()) {
				cliente.setNome(rs.getString("nome"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setLogin(rs.getString("login"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setBairro(rs.getString("bairro"));
			}else {
				cliente = null;
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public void atualizar(Cliente cliente) {
		
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getCidade());
			ps.setString(4, cliente.getBairro());

			ps.setInt(5, Integer.parseInt(cliente.getId()));

			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserir(Cliente cliente) {
		
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getSenha());
			ps.setString(3, cliente.getLogin());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getCidade());
			ps.setString(6, cliente.getBairro());
			
			ps.executeUpdate();
			

		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void deletar(Cliente cliente) {
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement ps = con.prepareStatement(DELETE_SQL);
			ps.setInt(1,Integer.parseInt(cliente.getId()));
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
