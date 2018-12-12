package web.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import web.com.modelo.Usuario;


public class UsuarioDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAJSF");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	public Usuario getUsuarioCard(String nomeUsuario, String matricula) {

		try {
			Usuario usuario = (Usuario) em
					.createQuery("Select u from Usuario u where u.nomeUsuario = :name and u.matricula = :matricula")
					.setParameter("name", nomeUsuario).setParameter("matricula", matricula).getSingleResult();

			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Usuario getUsuario(String nomeUsuario, String senha) {

		try {
			Usuario usuario = (Usuario) em
					.createQuery("Select u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
					.setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();

			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Usuario consultarUsuario(int id) {
		try{
			return em.find(Usuario.class, id);
		}catch (Exception e) {
			return null;
		}
	}
	
	public List listarUsuario() {

		Query queryObj = em.createQuery("Select u from Usuario u");
		List usuarioList = queryObj.getResultList();

		if (usuarioList != null && usuarioList.size() > 0) {
			return usuarioList;
		} else {
			return null;
		}

	}

	public boolean deletarUsuario(Usuario usuario) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.merge(usuario);
			em.remove(usuario);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean editarUsuario(Usuario usuario) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.merge(usuario);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean inserirUsuario(Usuario usuario) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.persist(usuario);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}