package mappingManytoOne;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OnlineMappingOneToMany.Item;

public class Test {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=null;
	EntityManager entityManager=null;
	EntityTransaction transaction=null;
	
	Cars cars=new Cars();
	cars.setCid(13);
	cars.setCname("Honduai");
	
	Cars cars1=new Cars();
	cars1.setCid(14);
	cars1.setCname("kia");
	
	Cars cars2=new Cars();
	cars2.setCid(15);
	cars2.setCname("blakyy");
	
	Person person=new Person();
	person.setPid(600);
    person.setPname("raji");

	
	try {
		entityManagerFactory=Persistence.createEntityManagerFactory("mapping");
		entityManager=entityManagerFactory.createEntityManager();
		transaction=entityManager.getTransaction();
		transaction.begin();
//	    entityManager.persist(person);

       Person person2=entityManager.find(Person.class, 100);
       List <Cars> list=new ArrayList<Cars>(); 
      
//		list.add(cars);
//		cars.setPerson(person2);
//		person2.setCar(list);
//		
//		list.add(cars1);
//		cars1.setPerson(person2);
//		//person2.setCar(list);
//		
//		list.add(cars2);
//		cars2.setPerson(person2);
//		//person2.setCar(list);
       
       
       
       
       list.add(cars);
       list.add(cars1);
       list.add(cars2);
       
		cars.setPerson(person2);
		cars1.setPerson(person2);
		cars2.setPerson(person2);
		
		
		person2.setCar(list);
		//person2.setCar(list);
		//person2.setCar(list);
  
       transaction.commit();
		System.out.println("succes");
	} catch (Exception e) {
		if (transaction!=null) {
			transaction.rollback();
		}
        e.printStackTrace();
   }
	finally {
		if (entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if (entityManager!=null) {
			entityManager.close();
		}
	}
}
}
