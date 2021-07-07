package assignment_project;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.bean.Employee;

public class EmployeList {
	public void displayAllData() {
		EntityManagerFactory managerFactory = null;
		EntityManager entityManager = null;
		
		try {
			managerFactory = Persistence.createEntityManagerFactory("empData");
			entityManager = managerFactory.createEntityManager();

//			System.out.println("choose:SEE ALL EMPLOYEES\n 1.SEE EMPLOYESS\n 2.UPDATE\n 3.DELETE");
//			Scanner sc = new Scanner(System.in);
//			System.out.println("enter ur choice");
//			int ch = sc.nextInt();
//			switch (ch) {
//			case 1:
				String quary = "from Employee";
				Query quary1 = entityManager.createQuery(quary);
				List<Employee> emp = quary1.getResultList();
				quary1.getResultList();
				for (Employee movie : emp) {
					System.out.println(movie);
				}
			//	break;
//			case 2:
//				transaction = entityManager.getTransaction();
//				transaction.begin();
//				String read = " update Employee set ename='poojaaaa' where eid=5";
//				Query quary2 = entityManager.createQuery(read);
//				// quary2.setParameter("eid", Integer.parseInt(args[0]));
//				Employee movies = (Employee) quary2.getSingleResult();
////								 if (movies!=null) {
////						//movies.setEname("nycnyc");
////					}
//
//				System.out.println("updated data susfully completed");
//				transaction.commit();
//				break;
//
//			case 3:
//				transaction = entityManager.getTransaction();
//				transaction.begin();
//				String delete = "delete from Employee where eid=:eid";
//				Query quary3 = entityManager.createQuery(delete);
//				quary3.setParameter("eid", Integer.parseInt(args[0]));
//				Employee emp1 = (Employee) quary3.getSingleResult();
//				if (emp1 != null) {
//					emp1.setEname("woresttttt");
//				}
//
//				System.out.println("deleted data susfully completed");
//				transaction.commit();
//				break;
	
			
		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (managerFactory != null) {
				managerFactory.close();
			}

		}

	}

}
