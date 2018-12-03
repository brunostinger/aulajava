package com.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Pessoa;

public class PessoaDAO {

	EntityManager entityManager;
	private static PessoaDAO instance;

	public static PessoaDAO getInstance() {
		if (instance == null) {
			instance = new PessoaDAO();
		}
		return instance;
	}

	private PessoaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExemploJPA");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public void persist(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(pessoa);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public Pessoa getById(final int id) {
		return entityManager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> findAll(){
		return entityManager.createQuery("From "+Pessoa.class.getName()).getResultList();
	}
	
	public void update(Pessoa pessoa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(pessoa);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void remove(Pessoa pessoa) {		
		try {
			entityManager.getTransaction().begin();
			pessoa = entityManager.find(Pessoa.class, pessoa.getId());
			entityManager.remove(pessoa);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	public void removeById(final int id) {
		try {
			Pessoa pessoa = getById(id);		
			remove(pessoa);
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}