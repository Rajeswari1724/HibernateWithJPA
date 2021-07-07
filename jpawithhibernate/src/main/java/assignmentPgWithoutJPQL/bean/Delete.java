package assignmentPgWithoutJPQL.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("libData");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
		   Library library=entityManager.find(Library.class, 1);
		   entityManager.remove(library);
		   
//			String delete = "delete from Library where bid=:id";
//			transaction.begin();
//			Query query = entityManager.createQuery(delete);
//
//			query.setParameter("id", Integer.parseInt(args[0]));
//			int res = query.executeUpdate();
//			System.out.println(res + "rows affected");
		   
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
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

