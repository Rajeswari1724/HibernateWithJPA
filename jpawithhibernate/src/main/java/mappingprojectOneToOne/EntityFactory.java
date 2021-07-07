package mappingprojectOneToOne;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
// SINGLETON CLASS
public class EntityFactory {
 static EntityManagerFactory factory=null;
private EntityFactory() {
	
}
public static EntityManagerFactory getEntityManagerFactory(String pUnit) {
	if (factory==null) {
		factory=Persistence.createEntityManagerFactory(pUnit);
	}
	return factory;
}
}
