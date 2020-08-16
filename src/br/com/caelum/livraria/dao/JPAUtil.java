package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	/*private EntityManager entityManager;

	public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		entityManager = factory.createEntityManager();
		return entityManager;
	}*/

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("livraria-pu");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(EntityManager em) {
		em.close();
	}

}