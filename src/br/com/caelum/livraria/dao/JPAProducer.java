package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;

public class JPAProducer {

	public EntityManager createEntityManager() {
		EntityManager em = JPAUtil.getInstance().getEntityManager();
		System.out.println("createEntityManager: " + em);
		return em;
	}

	public void closeEntityManager(EntityManager entityManager) {
		if (entityManager.isOpen()) {
			System.out.println("closeEntityManager: " + entityManager);
			entityManager.close();
		}
	}

}