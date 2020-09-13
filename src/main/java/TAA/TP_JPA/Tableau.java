package TAA.TP_JPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tableau {

	public int id;
	public String titre;
	public List<Fiche> fiches = new ArrayList<Fiche>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	@OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)

	public List<Fiche> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}
	
	@Override
    public String toString() {
        return "Tableau Kanban [id=" + id + ", titre=" + titre + ", nombre de fiches ="
                + fiches.size() + "]";
    }


}

