package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TAA.TP_JPA.EntityManagerHelper;
import TAA.TP_JPA.Etat;
import TAA.TP_JPA.Fiche;
import TAA.TP_JPA.FicheDAO;
import TAA.TP_JPA.Tableau;
import TAA.TP_JPA.TableauDAO;
import TAA.TP_JPA.Utilisateur;
import TAA.TP_JPA.UtilisateurDAO;

@WebServlet(name="mybddservlet",
urlPatterns={"/bdd"})
public class MybddServlet extends HttpServlet {
	EntityManager manager;
	UtilisateurDAO userDao;
	FicheDAO  ficheDao ;
	TableauDAO tableauDao ;
	
	public void init(ServletConfig config) throws ServletException { 
		super.init(config); 
		manager = EntityManagerHelper.getEntityManager();
        userDao= new UtilisateurDAO(manager);
        ficheDao = new FicheDAO(manager);
        tableauDao = new TableauDAO(manager);
		} 
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	resp.setContentType("text/html");
        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.println("<html><body>\n" +
				"<h1>BDD</h1>\n");

        p.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
        p.println("<th>Utilisateur</th>\n"+
        		"<tr>\n"+
          	  "<td>id</td>"+
          	  "<td>nom</td>"+
          	  "<td>prenom</td>"+
          	  "<td>fonction</td>"+
          	  "<tr>\n");
        for(Utilisateur u : userDao.getAll()) {
        	p.println("<tr>\n"+
        	  "<td>"+u.getId()+"</td>"+
        	  "<td>"+u.getNom()+"</td>"+
        	  "<td>"+u.getPrenom()+"</td>"+
        	  "<td>"+u.getFonction()+"</td>"+
        	  "<tr>\n");
        }
        	p.println("</table>\n");
        	
        
        	p.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
            p.println("<th>Tableau</th>\n"+
            		"<tr>\n"+
              	  "<td>id</td>"+
              	  "<td>titre</td>"+
              	  
              	  "<tr>\n");
            for(Tableau t : tableauDao.getAll()) {
            	p.println("<tr>\n"+
            	  "<td>"+t.getId()+"</td>"+
            	  "<td>"+t.getTitre()+"</td>"+
            	 
            	  "<tr>\n");
            }
            	p.println("</table>\n");
            
        	
            
            p.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n");
            p.println("<th>Fiche</th>\n"+
            		"<tr>\n"+
              	  "<td>id</td>"+
              	  "<td>date</td>"+
              	  "<td>etat</td>"+
              	  "<td>libelle</td>"+
              	  "<td>lieu</td>"+
              	  "<td>note</td>"+
              	  "<td>temps</td>"+
              	"<td>url</td>"+
              	"<td>tableauId</td>"+
              	"<td>utilisateurId</td>"+
              	
              	  "<tr>\n");
            for(Fiche f : ficheDao.getAll()) {
            	p.println("<tr>\n"+
            	  "<td>"+f.getId()+"</td>"+
            	  "<td>"+f.getDate()+"</td>"+
            	  "<td>"+f.getEtat()+"</td>"+
            	  "<td>"+f.getLibelle()+"</td>"+
            	  "<td>"+f.getLieu()+"</td>"+
            	  "<td>"+f.getNote()+"</td>"+
            	  "<td>"+f.getTemps()+"</td>"+
            	  "<td>"+f.getUrl()+"</td>"+
            	  "<td>"+f.getTableau().getId()+"</td>"+
            	  "<td>"+f.getUtilisateur().getId()+"</td>"+
            	 
            	  "<tr>\n");
            }
            	p.println("</table>\n");
            
        
//  
       p.println("</body></html>");
       p.flush();
    }

    public void doPost(HttpServletRequest request,
		            HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Tableau t = new Tableau(request.getParameter("titre"));
		tableauDao.create(t);
		
		Utilisateur u = new Utilisateur(request.getParameter("nom"),
				request.getParameter("prenom"), 
				request.getParameter("fonction"));
		userDao.create(u);
		
		ficheDao.create(new Fiche(request.getParameter("libelle"),
				new Date(),
						u,
						Integer.valueOf(request.getParameter("temps")),
						request.getParameter("lieu"),
						request.getParameter("url"),
						request.getParameter("note"),
						Etat.EN_ATTANTE,
				t));
		
		
		tx.commit();
		doGet(request, response);
			}
			
			
}