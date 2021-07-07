package assignmentPgJPQL;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.bean.Employee;

public class MainClassLoginValidation {

	public static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id which you want to delete");
		int i=sc.nextInt();

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("mapping");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();

			transaction.begin();

			String select = "delete from EmpDetails where id=:id";

			Query query = entityManager.createQuery(select);
			query.setParameter("id", i);

			int res = query.executeUpdate();

			transaction.commit();

			System.out.println(res);

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

	public static void allEmp() {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("empData");
			entityManager = entityManagerFactory.createEntityManager();

			String select = "from EmpDetails";

			Query query = entityManager.createQuery(select);

			java.util.List<Employee> empDetails = query.getResultList();

			for (Employee empD : empDetails) {
				System.out.println(empD);
			}

		} catch (Exception e) {
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

	public static void update() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID : ");
		int i = sc.nextInt();
		System.out.println("Enter Name : ");
		String name = sc.next();

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("empData");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();

			transaction.begin();

			String select = "update EmpDetails set name=:name where id =:id";

			Query query = entityManager.createQuery(select);
			
			query.setParameter("id", i);
            query.setParameter("name", name);
			
			int res = query.executeUpdate();

			transaction.commit();
			System.out.println(res);
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

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("1 for see all employees \n 2. for see Employees \n 3. for update\n 4. for delete");
		System.out.println("Enter your choice ");
		int input = sc.nextInt();

		switch (input) {
		case 1:

			MainClassLoginValidation.allEmp();
			break;
		case 2:

			while (true) {

				System.out.println("| press 1 to update based on id ");
				System.out.println("| press 2 to delete based on id ");
				System.out.println("| press 3 to exit ");

				System.out.println("Press the number");

				int input2 = sc.nextInt();
				switch (input2) {

				case 1:
					// update based on id

					MainClassLoginValidation.update();
					return;
				case 2:
					// delete based on id

					MainClassLoginValidation.delete();
					return;
				case 3:
					System.exit(0);
				}
			}
		case 3:
			MainClassLoginValidation.update();
			// update based on id
			return;
		case 4:
			MainClassLoginValidation.delete();
			// delete based on id
			
			MainClassLoginValidation.delete();
			return;

		default:
			break;
		}

	}
}
