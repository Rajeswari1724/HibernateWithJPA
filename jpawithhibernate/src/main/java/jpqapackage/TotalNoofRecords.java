package jpqapackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TotalNoofRecords {
	public static void main(String[] args) {
		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		
		try {
	          managerFactory=Persistence.createEntityManagerFactory("moviesData");
			 entityManager=managerFactory.createEntityManager();
			 String data="select count(*) from Movies ";
			 Query quary=entityManager.createQuery(data);
			Long llong=(Long)quary.getSingleResult();
						System.out.println(llong);
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
