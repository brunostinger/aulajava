package com.web.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.bind.ValidationException;

import com.web.dao.UsuarioDAO;
import com.web.model.Usuario;

@ManagedBean(name = "usuarioService")
@ApplicationScoped
public class UsuarioService {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void telaEdicao(Usuario usuario) throws ValidationException {
		if (!usuario.getMatricula().startsWith("ADM")) {
			throw new ValidationException("Somente usu�rio com perfil ADM podem acessar a p�gina de edi�ao");
		}
	}

	public void salvarUsuario(Usuario usuario) throws ValidationException {
		this.validarMatricula(usuario);
		 usuario.setSenha(this.encriptarSenha(usuario.getSenha()));
		if (!usuarioDAO.inserirUsuario(usuario)) {
			throw new ValidationException("Usuario j� existe");
		}
	}

	public String encriptarSenha(String senha) {
		String senhaRetorno = "";
		MessageDigest algorithm;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			senhaRetorno = hexString.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return senhaRetorno;

	}

	public Usuario consultarUsuario(Integer idUsuario) {
		return usuarioDAO.consultarUsuario(idUsuario);
	}

	public void mergeUsuario(Usuario usuario) {
		usuarioDAO.editarUsuario(usuario);
	}

	private void validarMatricula(Usuario usuario) throws ValidationException {
		if (!usuario.getMatricula().startsWith("M") && !usuario.getMatricula().startsWith("ADM")) {
			throw new ValidationException("A matr�cula do usu�rio de iniciar com M ou ADM!");
		}
	}

	public void deletarUsuario(Usuario usuario) {
		usuarioDAO.deletarUsuario(usuario);
	}

}