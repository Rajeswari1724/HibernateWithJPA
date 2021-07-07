package assignmentPgWithoutJPQL.bean;


import javax.persistence.EntityManager;

//import assignmentPgWithoutJPQL.bean.Library;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import assignmentPgWithJPQL.bean.Libraries;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("libData");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();

			transaction.begin();
			Libraries lib = entityManager.find(Libraries.class, 1);
			if (lib != null) {
				lib.setBauthor("priyasingh");
			}
			System.out.println("updated sucessfully");
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}

}

