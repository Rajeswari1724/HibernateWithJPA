package jpqapackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.bean.Movies;

public class UpdateQuary {
	public static void main(String[] args) {
		
		EntityManagerFactory managerFactory=null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
	          managerFactory=Persistence.createEntityManagerFactory("moviesData");
			 entityManager=managerFactory.createEntityManager();
			 transaction=entityManager.getTransaction();
			transaction.begin();
			String quary="update Movies set name='rajeswari' where id=10";
			Query quary2=entityManager.createQuery(quary);
			int res=quary2.executeUpdate();
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
