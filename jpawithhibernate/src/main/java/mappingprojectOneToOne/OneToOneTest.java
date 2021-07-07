package mappingprojectOneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import mappingProjectAnother.System_info;

public class OneToOneTest {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;
	
	Employe employe=new Employe();
	 employe.setMid(10);
	 employe.setMname("rajeshwari");
	 
	 System_info system_info=new System_info();
	 system_info.setSid(100);
	 system_info.setSname("DELL");
	 employe.setSystem_info(system_info);

	try {
		entityManagerFactory= EntityFactory.getEntityManagerFactory("mapping");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		
//	transaction.begin();
//	
//	entityManager.persist(employe);
//	transaction.commit();
//	
	
	     Employe employe2=entityManager.find(Employe.class, 10);
	 System.out.println(employe2);
	 System.out.println(employe2.getSystem_info());
		
		

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
		
	}
}
}
