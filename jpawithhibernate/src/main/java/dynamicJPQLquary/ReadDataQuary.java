package dynamicJPQLquary;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.bean.Movies;

public class ReadDataQuary {
	public static void main(String[] args) {
		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		
		try {
	          managerFactory=Persistence.createEntityManagerFactory("moviesData");
			 entityManager=managerFactory.createEntityManager();
			 String read="from Movies where mid=:mid";
			 
			 Query quary=entityManager.createQuery(read);
			 quary.setParameter("mid", Integer.parseInt(args[0]));
						 Movies movies=(Movies)quary.getSingleResult();
			 
			 System.out.println(movies.getName());
			 System.out.println(movies.getReviews());
			 System.out.println(movies.getRatings());
			
						
					} catch (Exception e) {
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
