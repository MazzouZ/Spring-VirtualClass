package ma.pfa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private Date dateDebut;
	@ManyToOne
	private Cours cours;
	@ManyToOne
	private MzUser mzUser;
	@OneToMany(mappedBy = "post")
	private Collection<Commentaire> commentaires;
	@OneToMany(mappedBy = "post")
	private Collection<PostHasFiles> postHasFiles;


	public Post(String titre, String description, Date dateDebut, Cours cours, MzUser mzUser, Collection<Commentaire> commentaires, Collection<PostHasFiles> postHasFiles) {
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.cours = cours;
		this.mzUser = mzUser;
		this.commentaires = commentaires;
		this.postHasFiles = postHasFiles;
	}
	
	

	public Post() {
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

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public MzUser getMzUser() {
		return mzUser;
	}

	public void setMzUser(MzUser mzUser) {
		this.mzUser = mzUser;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Collection<PostHasFiles> getPostHasFiles() {
		return postHasFiles;
	}

	public void setPostHasFiles(Collection<PostHasFiles> postHasFiles) {
		this.postHasFiles = postHasFiles;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", titre='" + titre + '\'' +
				", description='" + description + '\'' +
				", dateDebut=" + dateDebut +
				", cours=" + cours +
				", mzUser=" + mzUser +
				", commentaires=" + commentaires +
				", postHasFiles=" + postHasFiles +
				'}';
	}
}
