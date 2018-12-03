package com.web.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Pessoa;

public class TestePersistencia {

	public static void main (String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager em = emf.createEntityManager();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("02852469170");
		pessoa.setNome("BRUNO R");
		
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		
		List<Pessoa> listaPessoas = em.createQuery("From "+Pessoa.class.getName()).getResultList();
		
		for(Pessoa pessoaSelecionada : listaPessoas) {
			System.out.println(pessoaSelecionada.toString());
		}
	}

	
}
