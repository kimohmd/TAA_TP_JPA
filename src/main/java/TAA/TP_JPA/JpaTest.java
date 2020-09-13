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

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		
		Utilisateur u = new Utilisateur();
		
		Fiche fiche1 = new Fiche();
		Fiche fiche2 = new Fiche();
		Fiche fiche3 = new Fiche();
		
		Tableau tableau = new Tableau();
		
		

		u.setNom("HAMMAD");
		u.setPrenom("Abdel Karim");
		u.setFonction("Développeur ");
		
		fiche1.setLibelle("tester l'exemple de mise en place de persistence JPA");
		fiche1.setDate(new Date());
		fiche1.setLieu("ISTIC");
		fiche1.setTemps(30);
		fiche1.setNote("cette tâche est à faire en premier..");
		fiche1.setUrl("https://docs.google.com/document/d/1XksDBYnQmaqVoNPZ3ZfGVpEPxlP9ATsBQRW1h48j_go/edit");
		fiche1.setEtat(Etat.REALISE);
		fiche1.setUtilisateur(u);
		
		fiche2.setLibelle("mettre en place la persistence de données");
		fiche2.setDate(new Date());
		fiche2.setLieu("ISTIC");
		fiche2.setTemps(240);
		fiche2.setNote("cette tâche est à faire avant la fin de la journée..");
		fiche2.setUrl("https://docs.google.com/document/d/1XksDBYnQmaqVoNPZ3ZfGVpEPxlP9ATsBQRW1h48j_go/edit");
		fiche2.setEtat(Etat.EN_COURS);
		fiche2.setUtilisateur(u);
		
		fiche3.setLibelle("tester la connexion à une base mysql");
		fiche3.setDate(new Date());
		fiche3.setLieu("ISTIC");
		fiche3.setTemps(60);
		fiche3.setNote("cette tâche est à faire avant la fin..");
		fiche3.setUrl("https://docs.google.com/document/d/1XksDBYnQmaqVoNPZ3ZfGVpEPxlP9ATsBQRW1h48j_go/edit");
		fiche3.setEtat(Etat.EN_ATTANTE);
		fiche3.setUtilisateur(u);
		
		List<Fiche> fiches = new ArrayList<Fiche>();
		fiches.add(fiche1);
		fiches.add(fiche2);
		fiches.add(fiche3);
		
		tableau.setTitre("kanban TP JPA TAA");
		tableau.setFiches(fiches);
		
		manager.persist(u);
		
		
		manager.persist(fiche1);
		manager.persist(fiche2);
		manager.persist(fiche3);
		
		manager.persist(tableau);
		
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

}
