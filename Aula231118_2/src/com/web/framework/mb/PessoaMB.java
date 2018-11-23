package com.web.framework.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.web.model.Pessoa;

@RequestScoped
@ManagedBean(name = "pessoaMB")
public class PessoaMB {

	private Pessoa pessoa;
	
	@PostConstruct
	public void init() {
		System.out.println("**** Entrou metodo init ****");
		pessoa = new Pessoa();
		
		pessoa.setNome("Bruno Roger");
		pessoa.setIdade(28);
		pessoa.setSexo("M");	
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
	
}
