package TAA.TP_JPA;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;




public class UtilisateurDAO implements Dao<Utilisateur> {
	private EntityManager entityManager;
    
    public UtilisateurDAO() {
    	this.entityManager = EntityManagerHelper.getEntityManager();
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
            EntityTransaction tx = entityManager.getTransaction();
    		tx.begin();
    		
    		
    		try {
    			entityManager.persist(user);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		tx.commit();
    }
    
    
    
    
    public void delete(Utilisateur user) {
    	
    	  entityManager.persist(user);
          EntityTransaction tx = entityManager.getTransaction();
  		tx.begin();
  		
  		
  		try {
  			entityManager.remove(user);
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		tx.commit();
    }
}