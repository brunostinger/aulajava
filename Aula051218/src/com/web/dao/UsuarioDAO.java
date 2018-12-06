package com.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.web.model.Usuario;

public class UsuarioDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAJSF");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	public Usuario getUsuarioCard(String nomeUsuario, String matricula) {

		try {
			Usuario usuario =  (Usuario) 
					em.createQuery("Select u from Usuario u where u.nomeUsuario = :name and u.matricula = :matricula")
					.setParameter("name", nomeUsuario).setParameter("matricula", matricula).getSingleResult();
		
			return usuario;			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Usuario getUsuario(String nomeUsuario, String senha) {

		try {
			Usuario usuario =  (Usuario) 
					em.createQuery("Select u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
					.setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();
		
			return usuario;			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List listarUsuario() {
		
		Query queryObj = em.createQuery("Select u from usuario u");
		List usuarioList = queryObj.getResultList();
		
		if(usuarioList!=null && usuarioList.size()>0) {
			return usuarioList;
		}
		else {
			return null;
		}
			
	}
}
