package assignmentPgJPQL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import assignmentPgWithJPQL.bean.Libraries;

public class App {
	public static void main(String[] args) {
		Libraries lib = new Libraries();
		lib.setBid(4);
		lib.setBname("rajeswari");
		lib.setBauthor("Tagore");
		lib.setPrice(280.00);

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("libData");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(lib);
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

