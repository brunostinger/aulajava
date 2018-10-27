package com.web.mapeamento;

import java.util.ArrayList;

public class Funcionario {

	private String nome;
	private ArrayList<Projeto> projetos;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(ArrayList<Projeto> projetos) {
		this.projetos = projetos;
	}
	

	
}
