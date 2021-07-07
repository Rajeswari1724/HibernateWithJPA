package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.bean.Movies;

public class FindMovie {
public static void main(String[] args) {
	EntityManagerFactory entitymanagerfactory=null;
	EntityManager manager=null;
	
	try {
		entitymanagerfactory=Persistence.createEntityManagerFactory("moviesData");
		 manager=entitymanagerfactory.createEntityManager();
		 Movies movies=manager.find(Movies.class,10);
		 System.out.println(movies.getId());
		 System.out.println(movies.getName());
		 System.out.println(movies.getRatings());
		 System.out.println(movies.getReviews());
		} catch (Exception e) {
				e.printStackTrace();
	}
	finally {
		if (entitymanagerfactory!=null) {
			entitymanagerfactory.close();
			if (manager!=null) {
				manager.close();
				
			}
		}
	}
}
}
