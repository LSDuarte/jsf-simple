package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;

public class DAO<T> {

	private final Class<T> classe;

	// construtor
	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	public void adiciona(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void remove(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(t));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void atualiza(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(t);
	}

}