package com.web.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.web.dao.UsuarioDAO;
import com.web.model.Usuario;

@RequestScoped
public class UsuarioMB {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new  Usuario();
	private List<Usuario> usuarioListDb =  new ArrayList<>();
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List getUsuarioListDb() {
		return usuarioDAO.listarUsuario();
	}
	
}
