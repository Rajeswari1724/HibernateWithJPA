package jpqapackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SingleNameQuary {
	public static void main(String[] args) {
		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		//EntityTransaction transaction=null;
		try {
	          managerFactory=Persistence.createEntityManagerFactory("moviesData");
			 entityManager=managerFactory.createEntityManager();
			 String data="select name from Movies where id=10";
			 Query quary=entityManager.createQuery(data);
			 List<String> movies=quary.getResultList();
			
			 for(String movie:movies)
			 {
			System.out.println(movie);
			 }
			
						
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
