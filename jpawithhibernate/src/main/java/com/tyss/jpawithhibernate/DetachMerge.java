package com.tyss.jpawithhibernate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.bean.Movies;

public class DetachMerge {
public static void main(String[] args) {
			EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
	          managerFactory=Persistence.createEntityManagerFactory("moviesData");
			 entityManager=managerFactory.createEntityManager();
			 transaction=entityManager.getTransaction();
			transaction.begin();
			
			Movies movies=entityManager.find(Movies.class,10);
			System.out.println(entityManager.contains(movies));
			entityManager.detach(movies);
			
			System.out.println("AFTER DETACH");
			System.out.println(entityManager.contains(movies));
            movies.setName("rajarajeswari");
            Movies mergerdData=entityManager.merge(movies);
            mergerdData.setName("simhadri");
            
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

