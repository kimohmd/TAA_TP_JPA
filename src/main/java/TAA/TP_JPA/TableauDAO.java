package TAA.TP_JPA;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

public class TableauDAO implements Dao<Tableau> {
	private EntityManager entityManager;
    
    public TableauDAO(EntityManager manager) {
    	entityManager = manager;
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
            entityManager.persist(tableau);
    	
    }
    
    
    
    
    public void delete(Tableau tableau) {
    	entityManager.remove(tableau);
    }
}