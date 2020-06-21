package ma.pfa.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Fichier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(mappedBy = "fichier")
	private Collection<PostHasFiles> postHasFiles;

	public Fichier() {
	}

	public Fichier(String nom, Collection<PostHasFiles> postHasFiles) {
		this.nom = nom;
		this.postHasFiles = postHasFiles;
	}
	
	

	public Fichier() {
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<PostHasFiles> getPostHasFiles() {
		return postHasFiles;
	}

	public void setPostHasFiles(Collection<PostHasFiles> postHasFiles) {
		this.postHasFiles = postHasFiles;
	}

	@Override
	public String toString() {
		return "Fichier{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", postHasFiles=" + postHasFiles +
				'}';
	}
}
