package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.bean.Movies;

public class UpdateData {
	public static void main(String[] args) {
		
//		movies.setId(10);
//		movies.setName("badrinath");
//		movies.setRatings(8.5);
//		movies.setReviews("confusing");
//		
		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
	          managerFactory=Persistence.createEntityManagerFactory("moviesData");
			 entityManager=managerFactory.createEntityManager();
			 transaction=entityManager.getTransaction();
			transaction.begin();
			Movies movies=entityManager.find(Movies.class,10);
			if (movies!=null) {
				movies.setReviews("worest");
			}
		
			
			System.out.println("updated data");
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
