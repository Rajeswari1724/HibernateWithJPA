package assignment_project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.bean.Employee;
import com.tyss.jpawithhibernate.bean.Movies;

public class UpdateData {
	public  void update(int a) {

		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
	          managerFactory=Persistence.createEntityManagerFactory("empData");
			 entityManager=managerFactory.createEntityManager();
			 transaction=entityManager.getTransaction();
			transaction.begin();
			//Employee emp=entityManager.find(Employee.class,Integer.parseInt("id"));
			
			String read=" update Employee set name='pooj' where eid=:eid";
            Query quary=entityManager.createQuery(read);
			 quary.setParameter("eid",a);
			int res=quary.executeUpdate();			
	
			
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
