package TAA.TP_JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Utilisateur {

	public Long id;
	public String nom;
	public String prenom;
	public String fonction;
	
public Utilisateur() {
		
	}

public Utilisateur(String nom, String prenom, String fonc) {
	this.nom= nom;
	this.prenom = prenom;
	this.fonction = fonc;
}
	
@Id
@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	@Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom="
                + prenom + "]";
    }

	
}
