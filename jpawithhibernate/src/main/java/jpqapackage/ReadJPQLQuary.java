package jpqapackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.bean.Movies;

public class ReadJPQLQuary {
public static void main(String[] args) {
		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		//EntityTransaction transaction=null;
		try {
	          managerFactory=Persistence.createEntityManagerFactory("moviesData");
			 entityManager=managerFactory.createEntityManager();
			 String selct="from Movies";
			 Query quary=entityManager.createQuery(selct);
			 List<Movies> movies=quary.getResultList();
			 quary.getResultList();
			 for (Movies movie : movies) {
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
