package ma.pfa.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Devoir {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	private String regles;
	public Devoir() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Devoir(Long id, String titre, String description, Date dateDebut, Date dateFin, String regles) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.regles = regles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getRegles() {
		return regles;
	}
	public void setRegles(String regles) {
		this.regles = regles;
	}
	@Override
	public String toString() {
		return "Devoir [id=" + id + ", titre=" + titre + ", description=" + description + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", regles=" + regles + "]";
	}
	
}
