package br.com.caelum.livraria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DAO<T> {

	private final Class<T> classe;

	// construtor
	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	EntityManager em;

	protected final EntityManager getEntityManager() {
		if (em == null || !em.isOpen()) {
			em = JPAUtil.getInstance().getEntityManager();
		}
		return em;
	}

	public void adiciona(T t) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(t);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
	}

	public void remove(T t) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(getEntityManager().merge(t));
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
	}

	public List<T> listarTodos() {
		String jpql = "FROM " + classe + " e";
		TypedQuery<T> query = getEntityManager().createQuery(jpql, classe);
		return query.getResultList();
	}
	

}