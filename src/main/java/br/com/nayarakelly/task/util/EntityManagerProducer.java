package br.com.nayarakelly.task.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * 	
 * @author nayara
 * 
 */
@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;
	//Utilizada a annotation @PersistenceUnit para injetar uma instância de um EntityManagerFactory, configurada no persistence.xml
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("crudPersistenceUnit");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}
