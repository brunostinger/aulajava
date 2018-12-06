package com.web.controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.web.dao.UsuarioDAO;
import com.web.model.Usuario;

@RequestScoped
@ManagedBean(name = "cardLoginMB")
public class CardLoginMB {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	public String enviar() {
		
		apiRecebeDadosCartao();
		
		usuario = usuarioDAO.getUsuarioCard(usuario.getNomeUsuario(), usuario.getMatricula());
		if(usuario==null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cart�o n�o aceito","Erro no Login!"));
			return null;
		}else {
			return "/acessoLiberado";
		}
	}
	
	private void apiRecebeDadosCartao() {
		String nomeUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nomeUsuario");
		String matricula = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("matricula");

		usuario.setNomeUsuario(nomeUsuario);
		usuario.setMatricula(matricula);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
