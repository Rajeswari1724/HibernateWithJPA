package assignmentPgWithJPQL.bean;

import javax.persistence.EntityManager;
import assignmentPgWithJPQL.bean.Libraries;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import assignmentPgWithoutJPQL.bean.Library;

public class App {
	public static void main(String[] args) {
	Libraries lib = new Libraries();
		lib.setBid(3);
		lib.setBname("ECE");
		lib.setBauthor("rajasekher");
		lib.setPrice(500.00);

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("libData");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(lib);
			System.out.println("inserted sucessful with JPQL");
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
		}
	}
}

