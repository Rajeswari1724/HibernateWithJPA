package ManyToManymapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import mappingprojectOneToOne.EntityFactory;

//To diplay the students

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory=null;
		EntityManager entitymanager=null;
		EntityTransaction entitytransaction=null;
		
		try {
			factory=EntityFactory.getEntityManagerFactory("mapping");
			entitymanager=factory.createEntityManager();
			
			Course course=entitymanager.find(Course.class, 100);
			
			List<Student> stud=course.getStudent();
			
			for(Student s1: stud)
			{
				System.out.println("Student Name =====.> "+s1.getSname());
			}
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			
			if(factory!=null)
			{
				factory.close();
			}
			if(entitymanager!=null)
			{
				entitymanager.close();
			}
		}

	}

}

