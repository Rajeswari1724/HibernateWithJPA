package dynamicJPQLquary;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDataQuary {
public static void main(String[] args) {
		
		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
	          managerFactory=Persistence.createEntityManagerFactory("moviesData");
			 entityManager=managerFactory.createEntityManager();
			 transaction=entityManager.getTransaction();
			String delete="delete from Movies where mid=:mid";
			//String update="update Movies set mname=:mname,ratings=:ratings where mid=:mid";
			Query quary2=entityManager.createQuery(delete);
			transaction.begin();
			
			 Query quary=entityManager.createQuery(delete);
			 
			 quary.setParameter("mid", 10);
//			 quary.setParameter("mname", "priya");
//			 quary.setParameter("ratings", 9.9);
            int res=quary.executeUpdate();
            System.out.println(res+"  suscefully updated");
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
