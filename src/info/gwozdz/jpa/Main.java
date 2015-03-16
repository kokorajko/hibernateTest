package info.gwozdz.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	private EntityManagerFactory entityManagerFactory;
	public EntityManager entityManager;
		
	public void startConnection(){
		entityManagerFactory = Persistence
				.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory
				.createEntityManager();
	}
	
	public void closeConnection(){
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
