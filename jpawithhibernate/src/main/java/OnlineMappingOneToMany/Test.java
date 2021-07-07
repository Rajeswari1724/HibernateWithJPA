package OnlineMappingOneToMany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import mappingprojectOneToOne.EntityFactory;

public class Test {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		Cart cart= new Cart();
		cart.setCid(300);
		cart.setCname("Flipkart");

		Item item = new Item();
		item.setIid(7);
		item.setIname("pen");

		Item item2 = new Item();
		item2.setIid(8);
		item2.setIname("rubber");
		
		Item item3 = new Item();
		item3.setIid(9);
		item3.setIname("pencil");

		try {
			entityManagerFactory = EntityFactory.getEntityManagerFactory("mapping");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
//			entityManager.persist(cart);
//            transaction.commit();
			
			Cart cart1 = entityManager.find(Cart.class, 200);

			ArrayList<Item> list = new ArrayList<Item>();
//			 list.add(item);
//			 item.setCart(cart1);
//			 cart1.setItems(list);                                // doubt        many items list contails  in one cart
//				
//			 
//			 list.add(item2);                                                                
//			 item2.setCart(cart1);                                                                      
//			// cart1.setItems(list);                                //same as teas
//				
//			 
//			list.add(item3);
//			item3.setCart(cart1);
//		  // cart1.setItems(list);                                 //???????????????
//			transaction.commit();
			
			
			 list.add(item);
			 list.add(item2); 
			 list.add(item3);
			 
			 item.setCart(cart1);
			 item2.setCart(cart1);
			 item3.setCart(cart1);
			 
			 
			 
			 cart1.setItems(list);                                // doubt        many items list contails  in one cart
		     // cart1.setItems(list);                                //same as teas
		    // cart1.setItems(list);                                 //???????????????
			transaction.commit();
			
			
			
//			List<Item>iiItems=cart.getItems();
//			 for (Item item4 : iiItems) {
//				System.out.println(item4);
//				
//				
//			}
			 
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		finally {
			try {
				if (entityManager != null) {
					entityManager.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

	}
}
