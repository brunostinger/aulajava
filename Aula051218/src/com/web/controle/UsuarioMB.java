package com.web.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.web.dao.UsuarioDAO;
import com.web.model.Usuario;

@ViewScoped
@ManagedBean
public class UsuarioMB {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new  Usuario();
	private List<Usuario> usuarioListDb =  new ArrayList<>();
	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String idUsuario = facesContext.getExternalContext().getRequestParameterMap().get("id");
		if(idUsuario!=null) {
			this.usuario=usuarioDAO.consultarUsuario(Integer.parseInt(idUsuario));
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List getUsuarioListDb() {
		return usuarioDAO.listarUsuario();
	}
	
	public void excluirUsuarioDb(Usuario usuario) {
		usuarioDAO.deletarUsuario(usuario);
	}
	
	public String incluirUsuarioDb(Usuario usuario) {
		usuarioDAO.inserirUsuario(usuario);
		return "/listagemUsuarios";
	}
	
	public String paginaEditar(Usuario usuario) {
		return"/editarUsuario?faces-redirect=true&id="+usuario.getId();
	}
	
	public String editarUsuarioDb(Usuario usuario) {
		usuarioDAO.editarUsuario(usuario);
		return "/listagemUsuarios";
	}
	
}
