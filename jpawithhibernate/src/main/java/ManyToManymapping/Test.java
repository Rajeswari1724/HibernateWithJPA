package ManyToManymapping;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mappingprojectOneToOne.EntityFactory;
//assigning same student into different cources
public class Test {
	public static void main(String[] args) {
		
		EntityManagerFactory factory=null;
		EntityManager entitymanager=null;
		EntityTransaction entitytransaction=null;
		
		ArrayList<Course> clist=new ArrayList<Course>();
		ArrayList<Student> slist=new ArrayList<Student>();
		
		Student s=new Student();
		s.setSid(40);
		s.setSname("raji");
		
        Course c1=new Course();
		c1.setCid(300);
		c1.setCname("j2ee");
		
		Course c2=new Course();
		c2.setCid(400);
		c2.setCname("servlet ");
		
		clist.add(c1);
		clist.add(c2);
		
		slist.add(s);
		
		c1.setStudent(slist); //only one student setting to course here //output mismatch//database mismatch
		c2.setStudent(slist); //only one student setting to course here
		
		s.setCourse(clist);   // cource into student          
		
		try {
			factory=EntityFactory.getEntityManagerFactory("mapping");
			entitymanager=factory.createEntityManager();
			entitytransaction=entitymanager.getTransaction(); 
			
			entitytransaction.begin();
			
			entitymanager.persist(s);
			
			entitytransaction.commit();
		} 
		
		catch (Exception e) {
			if(entitytransaction!=null)
			{
				entitytransaction.rollback();
			}
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

	}}
