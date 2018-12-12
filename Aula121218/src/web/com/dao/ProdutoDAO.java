package web.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import web.com.modelo.Produto;

public class ProdutoDAO {


	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAJSF");
	private EntityManager em = factory.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();
	
	public List listarProdutos() {

		Query queryObj = em.createQuery("Select p from Produto p");
		List listaProduto = queryObj.getResultList();

		if (listaProduto != null && listaProduto.size() > 0) {
			return listaProduto;
		} else {
			return null;
		}

	}
	
	public Produto consultarProdutoPorID(int id) {
		try{
			return em.find(Produto.class, id);
		}catch (Exception e) {
			return null;
		}
	}
	
	
	public boolean inserirProduto(Produto produto) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.persist(produto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean editarProduto(Produto produto) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.merge(produto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean deletarProduto(Produto produto) {
		if (!transaction.isActive()) {
			transaction.begin();
		}

		try {
			em.merge(produto);
			em.remove(produto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
