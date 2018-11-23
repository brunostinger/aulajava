package br.com.framework.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "testeJSF")
public class TesteJSF {
	
	private String message;
	private String message2;
	private String nomeCompleto;

	@PostConstruct
	public void init() {
		System.out.println("**** Entrou metodo init ****");
		nomeCompleto="Bruno Roger";
		message="Mensagem 1";
		message2="Mensagem 2";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	
}
