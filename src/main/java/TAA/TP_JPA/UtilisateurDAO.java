package TAA.TP_JPA;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;



public class UtilisateurDAO implements Dao<Utilisateur> {
	private EntityManager entityManager;
    
    public UtilisateurDAO(EntityManager manager) {
    	entityManager = manager;
    }
    
 
    public Optional<Utilisateur> get(long id) {
    	
	        return Optional.ofNullable(entityManager.find(Utilisateur.class, id));
	    
    }
    
    
    public List<Utilisateur> getAll() {
        
        List<Utilisateur> resultList = entityManager.createQuery("Select a From Utilisateur a", Utilisateur.class)
        		.getResultList();
        return resultList;
    }
    
    
    public void create(Utilisateur user) {
            entityManager.persist(user);
    	
    }
    
    
    
    
    public void delete(Utilisateur user) {
    	entityManager.remove(user);
    }
}