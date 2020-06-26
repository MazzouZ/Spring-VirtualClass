package ma.pfa.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Devoir implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	private String regles;
	@ManyToOne
	private Cours cours;
	@OneToMany(mappedBy = "devoir")
	private Collection<UserHasDevoir>  userHasDevoirs;
	@OneToMany(mappedBy = "devoir")
	private Collection<Commentaire> commentaires;
	@OneToMany(mappedBy = "devoir")
	private Collection<DevoirHasFiles> devoirHasFiles=new ArrayList<>();	
	

	public Devoir(String titre, String description, Date dateDebut, Date dateFin, String regles,
			Cours cours, Collection<UserHasDevoir> userHasDevoirs, Collection<Commentaire> commentaires,
			Collection<DevoirHasFiles> devoirHasFiles) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.regles = regles;
		this.cours = cours;
		this.userHasDevoirs = userHasDevoirs;
		this.commentaires = commentaires;
		this.devoirHasFiles = devoirHasFiles;
	}



	public Devoir() {
		super();
		// TODO Auto-generated constructor stub
	}



	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	



	public Collection<UserHasDevoir> getUserHasDevoirs() {
		return userHasDevoirs;
	}



	public void setUserHasDevoirs(Collection<UserHasDevoir> userHasDevoirs) {
		this.userHasDevoirs = userHasDevoirs;
	}



	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}



	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}



	public Collection<DevoirHasFiles> getDevoirHasFiles() {
		return devoirHasFiles;
	}



	public void setDevoirHasFiles(Collection<DevoirHasFiles> devoirHasFiles) {
		this.devoirHasFiles = devoirHasFiles;
	}





	@Override
	public String toString() {
		return "Devoir [id=" + id + ", titre=" + titre + ", description=" + description + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", regles=" + regles + ", cours=" + cours + ", userHasDevoirs="
				+ userHasDevoirs + ", commentaires=" + commentaires + ", devoirHasFiles=" + devoirHasFiles + "]";
	}

	
}
