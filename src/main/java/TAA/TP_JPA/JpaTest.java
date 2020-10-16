package TAA.TP_JPA;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class JpaTest {
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        EntityManagerFactory factory = Persistence
//                .createEntityManagerFactory("dev");
//        EntityManager manager = factory.createEntityManager();
//
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        try {
//            
//            
//        
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        tx.commit();
//        
//        manager.close();
//        factory.close();
//    }
//
//}


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

public class JpaTest {

    

	
	public static void main(String[] args) {

		
        UtilisateurDAO userDao= new UtilisateurDAO();
        FicheDAO  ficheDao = new FicheDAO();
        TableauDAO tableauDao = new TableauDAO();
		
			Utilisateur u = new Utilisateur("HA", "Abdel", "dev");
			userDao.create(u);
			Tableau tableau = new Tableau("kanban TP2");
			tableauDao.create(tableau);
			ficheDao.create(new Fiche("mettre en place des servlets",
					new Date(),u, 30, "ISTIC","https://docs.google.com/document/d/1XksDBYnQmaqVoNPZ3ZfGVpEPxlP9ATsBQRW1h48j_go/edit",
					"cette tâche est à faire en dernier..",
					Etat.REALISE,tableau));
			
		
	}

}
