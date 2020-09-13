package TAA.TP_JPA;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Fiche {

//	Un libellé
//	La date butoire
//	un utilisateur à qui cette tâche est affectée
//	Le temps dont vous estimez avoir besoin en minutes
//	un ensemble de tags
//	un lieu
//	une url
//	il est également possible d'ajouter une note explicative.

	public Long id;
	public Tableau tableau;
	public String libelle;
	public Date date;
	public Utilisateur utilisateur;
	public int temps;
	public String lieu;
	public String url;
	public String note;
	public Etat etat;
	
	public Fiche() {
		
	}
	
	public Fiche(Long id, String l, Date d, Utilisateur u, int t, String lieu, String url, String n, Etat e) {
		this.id = id;
		
		this.libelle = l;
		this.date = d;
		this.utilisateur = u;
		this.temps = t;
		this.lieu = l;
		this.url = url;
		this.note = n;
		this.etat = e;
		
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	public Tableau getTableau() {
		return tableau;
	}

	public void setTableau(Tableau tableau) {
		this.tableau = tableau;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public int getTemps() {
		return temps;
	}
	public void setTemps(int temps) {
		this.temps = temps;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Enumerated(EnumType.STRING)
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	@Override
    public String toString() {
        return "Fiche [id=" + id + ", libellé=" + libelle + ", date butoire="
                + date +", utilisateur=" + utilisateur.getPrenom() + ", temps" +
                temps +", lieu" + lieu + ", url" + url + ", note" + note +", etat" + etat
                +"]";
    }

	
}
