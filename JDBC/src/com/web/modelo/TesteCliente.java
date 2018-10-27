package com.web.modelo;

import com.web.dao.ClienteDAO;

public class TesteCliente {

	public static void main(String[] args) {

		//atualizarCliente();
		//buscarCliente();
		//inserirCliente();
		deletarCliente();

	}

	public static void buscarCliente() {
		
		Cliente cliente = new Cliente();
		cliente.setLogin("LOGIN1");
		cliente.setSenha("SENHA1");

		ClienteDAO clienteDAO = new ClienteDAO();
		cliente = clienteDAO.obter(cliente);

		if (cliente != null) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Endereco: " + cliente.getEndereco());
			System.out.println("Cidade: " + cliente.getCidade());
			System.out.println("Bairro: " + cliente.getBairro());

		} else {
			System.out.println("Login inválido");
		}
	}
	
	public static void atualizarCliente() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Novo nome");
		cliente.setEndereco("Novo endereco");
		cliente.setCidade("Nova cidade");
		cliente.setBairro("Novo bairro");
		cliente.setId("1");
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.atualizar(cliente);

	}
	
	
	public static void inserirCliente() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Novo nome 2");
		cliente.setEndereco("Novo endereco 2");
		cliente.setCidade("Nova cidade 2");
		cliente.setBairro("Novo bairro 2");
		cliente.setLogin("NOVOLOGIN2");
		cliente.setSenha("NOVASENHA2");
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(cliente);

	}
	
	public static void deletarCliente() {
		
		Cliente cliente = new Cliente();
		cliente.setId("2");
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.deletar(cliente);

	}
	

}
