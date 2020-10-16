package TAA.TP_JPA;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;



public class FicheDAO implements Dao<Fiche> {
	private EntityManager entityManager;
    
    public FicheDAO() {
    	this.entityManager = EntityManagerHelper.getEntityManager();
    }
    
 
    public Optional<Fiche> get(long id) {
    	
	        return Optional.ofNullable(entityManager.find(Fiche.class, id));
	    
    }
    
    
    public List<Fiche> getAll() {
        
        List<Fiche> resultList = entityManager.createQuery("Select f From Fiche f", Fiche.class)
        		.getResultList();
        return resultList;
    }
    
    
    public void create(Fiche fiche) {
    	EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		
		try {
            entityManager.persist(fiche);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


    }
    
    
    
    
    public void delete(Fiche fiche) {
    	
    	
    	EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		
		try {
			entityManager.remove(fiche);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
    	
    	
    }
}