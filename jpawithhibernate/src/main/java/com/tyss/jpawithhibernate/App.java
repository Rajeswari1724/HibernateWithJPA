package com.tyss.jpawithhibernate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.bean.Movies;

public class App {
public static void main(String[] args) {
	Movies movies=new Movies();
	movies.setId(10);
	movies.setName("zimbuzimbu");
	movies.setRatings(8.5);
	movies.setReviews("nyc");
	
	EntityManagerFactory managerFactory=null;
	EntityManager entityManager=null;
	EntityTransaction transaction=null;
	try {
          managerFactory=Persistence.createEntityManagerFactory("moviesData");
		 entityManager=managerFactory.createEntityManager();
		 transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(movies);
		System.out.println("inserted data");
		transaction.commit();
	} catch (Exception e) {
		if (transaction!=null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
	finally {
		if (entityManager!=null) {
			entityManager.close();
		}
		if (managerFactory!=null) {
			managerFactory.close();
		}
		
	}
	
}
}
