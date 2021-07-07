package jpqapackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.bean.Movies;


public class ReadSingleRecord {
	public static void main(String[] args) {
		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		//EntityTransaction transaction=null;
		try {
	          managerFactory=Persistence.createEntityManagerFactory("moviesData");
			 entityManager=managerFactory.createEntityManager();
			 String data="from Movies where mid=20";
			 Query quary=entityManager.createQuery(data);
			// List<Movies> movies=quary.getResultList();
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
