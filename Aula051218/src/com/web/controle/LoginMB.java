package com.web.controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.catalina.Context;

import com.web.dao.UsuarioDAO;
import com.web.model.Usuario;

@RequestScoped
@ManagedBean(name = "loginMB")
public class LoginMB {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();
	
	public String enviar() {
		
		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
		if(usuario==null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usu�rio n�o encontrado","Erro no Login!"));
			return null;
		}else {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().getSessionMap().put("logado", true);
			return "/restrito/listagemUsuarios?faces-redirect=true";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
