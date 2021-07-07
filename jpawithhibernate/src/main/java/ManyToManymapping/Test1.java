package ManyToManymapping;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import mappingprojectOneToOne.EntityFactory;

public class Test1{
	
	// Assigning same course to multiple students

	public static void main(String[] args) {
	
		EntityManagerFactory factory=null;
		EntityManager entitymanager=null;
		EntityTransaction entitytransaction=null;
		
		Student s1=new Student();
		s1.setSid(21);
		s1.setSname("Raju");
		
		Student s2=new Student();
		s2.setSid(22);
		s2.setSname("raji");
		
		Student s3=new Student();
		s3.setSid(23);
		s3.setSname("poorna");
		
		Student s4=new Student();
		s4.setSid(24);
		s4.setSname("sekher");
		
		Course crs=new Course();
		crs.setCid(2);
		crs.setCname("j2ee");
		
		try {
			factory=EntityFactory.getEntityManagerFactory("mapping");
			entitymanager=factory.createEntityManager();
			entitytransaction=entitymanager.getTransaction();
			
			entitytransaction.begin();
			entitymanager.persist(crs);
			Course course=entitymanager.find(Course.class, 1);
			
			ArrayList<Course> clist=new ArrayList<Course>();
			ArrayList<Student> slist=new ArrayList<Student>();

			clist.add(course);             //1
			
			slist.add(s1);
			slist.add(s2);                  // all r 2
			slist.add(s3);
			slist.add(s4);
			
			course.setStudent(slist);        //1
			
			s1.setCourse(clist);
			s2.setCourse(clist);             //all r 2
			s3.setCourse(clist);
			s4.setCourse(clist);
			
			entitytransaction.commit();
		} 
		
		catch (Exception e) {
			if(entitytransaction!=null)
			{
				entitytransaction.rollback();
			}
		}
			finally {
				try {
				if(factory!=null)
				{
					factory.close();
				}
				if(entitymanager!=null)
				{
					entitymanager.close();
				}
			}
			
						
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}