package TAA.TP_JPA;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class TableauDAO implements Dao<Tableau> {
	private EntityManager entityManager;
    
    public TableauDAO() {
    	this.entityManager = EntityManagerHelper.getEntityManager();
    }
    
 
    public Optional<Tableau> get(long id) {
    	
	        return Optional.ofNullable(entityManager.find(Tableau.class, id));
	    
    }
    
    
    public List<Tableau> getAll() {
        
        List<Tableau> resultList = entityManager.createQuery("Select t From Tableau t", Tableau.class)
        		.getResultList();
        return resultList;
    }
    
    
    public void create(Tableau tableau) {
         
    	   
        EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		
		try {
			entityManager.persist(tableau);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
        	
    }
    
    
    
    
    public void delete(Tableau tableau) {
    	
 	   
     EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		
		try {
			entityManager.remove(tableau);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
    }
}