package com.web.model;

public class Livro {
	private String autor;
	private String titulo;
	private String descricao;


	public void setDescricao(String desc) {
		descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
