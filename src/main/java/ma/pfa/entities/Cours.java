package ma.pfa.entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Cours implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private String code;
	private String specialite;
	@OneToMany(mappedBy = "cours")
	private Collection<Equipe_Inscription> equipeInscriptions;
	@ManyToOne
	private Organisation organisation;
	@OneToMany(mappedBy = "cours")
	private Collection<Devoir> devoirs;
	@OneToMany(mappedBy = "cours")
	private Collection<Post> posts;

	public Cours() {
	}

	public Cours(String label, String code, String specialite, Collection<Equipe_Inscription> equipeInscriptions, Organisation organisation, Collection<Devoir> devoirs, Collection<Post> posts) {
		this.label = label;
		this.code = code;
		this.specialite = specialite;
		this.equipeInscriptions = equipeInscriptions;
		this.organisation = organisation;
		this.devoirs = devoirs;
		this.posts = posts;
	}
	

	public Cours() {
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Collection<Equipe_Inscription> getEquipeInscriptions() {
		return equipeInscriptions;
	}

	public void setEquipeInscriptions(Collection<Equipe_Inscription> equipeInscriptions) {
		this.equipeInscriptions = equipeInscriptions;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public Collection<Devoir> getDevoirs() {
		return devoirs;
	}

	public void setDevoirs(Collection<Devoir> devoirs) {
		this.devoirs = devoirs;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Cours{" +
				"id=" + id +
				", label='" + label + '\'' +
				", code='" + code + '\'' +
				", specialite='" + specialite + '\'' +
				", equipeInscriptions=" + equipeInscriptions +
				", organisation=" + organisation +
				", devoirs=" + devoirs +
				", posts=" + posts +
				'}';
	}
}
