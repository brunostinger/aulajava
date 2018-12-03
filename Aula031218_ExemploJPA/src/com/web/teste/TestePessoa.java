package com.web.teste;

import java.util.List;

import com.web.dao.PessoaDAO;

import modelo.Pessoa;

public class TestePessoa {
	static PessoaDAO pessoaDAO = PessoaDAO.getInstance();

	public static void main(String[] args) {
		
		listarTodasPessoas();
		
		//listarTodasPessoas();
		//alterarPessoa();
		//incluirPessoa();
		removerPessoa();
		
		listarTodasPessoas();

	}
	
	private static void listarTodasPessoas() {
		List<Pessoa> todasPessoasJPA = pessoaDAO.findAll();
		
		for(Pessoa pessoaSelecionada : todasPessoasJPA){
			System.out.println(pessoaSelecionada.toString());
		}
	}

	private static void alterarPessoa() {
		Pessoa pessoaAlterar = pessoaDAO.getById(2);
		pessoaAlterar.setNome("Novo nome");
		
		pessoaDAO.update(pessoaAlterar);
	}
	
	private static void incluirPessoa() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("02852469170");
		pessoa.setNome("BRUNO");

		pessoaDAO.persist(pessoa);
	}
	
	public static void removerPessoa() {
		pessoaDAO.removeById(2);
	}
}
