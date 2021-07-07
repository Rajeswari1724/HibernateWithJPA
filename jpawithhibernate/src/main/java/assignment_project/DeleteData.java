package assignment_project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.bean.Employee;
import com.tyss.jpawithhibernate.bean.Movies;

public class DeleteData {
	public void delete(int a) {

		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
	          managerFactory=Persistence.createEntityManagerFactory("empData");
			 entityManager=managerFactory.createEntityManager();
			 transaction=entityManager.getTransaction();
			transaction.begin();
			
						 String delete="delete from Employee where eid=:eid";
							
							
							
							
							 Query quary=entityManager.createQuery(delete);
							 
							 quary.setParameter("eid", a);
										            int res=quary.executeUpdate();
				           						 
			
					
			
			System.out.println(res+"deleted data sucessful");
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

