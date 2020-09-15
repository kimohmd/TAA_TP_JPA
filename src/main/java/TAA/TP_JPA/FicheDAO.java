package TAA.TP_JPA;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

public class FicheDAO implements Dao<Fiche> {
	private EntityManager entityManager;
    
    public FicheDAO(EntityManager manager) {
    	entityManager = manager;
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
            entityManager.persist(fiche);
    	
    }
    
    
    
    
    public void delete(Fiche fiche) {
    	entityManager.remove(fiche);
    }
}