package ma.pfa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
//@Entity

@Entity
public class MzUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String username;
	private String password;
	private String photo;
	private String telehpone;
	private Date dateCreation;
	private boolean actived;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<MzRole> roles=new ArrayList<>();

	@OneToMany(mappedBy = "mzUser")
	private Collection<Equipe_Inscription> equipeInscriptions;
	@OneToMany(mappedBy = "mzUser")
	private Collection<UserHasDevoir> userHasDevoirs;
	@OneToMany(mappedBy = "mzUser")
	private Collection<Post> posts;
	@OneToMany(mappedBy = "mzUser")
	private Collection<Commentaire> commentaires;
	@ManyToOne
	private Organisation organisation;

	public MzUser(String nom, String prenom, String email, String username, String password, String photo, String telehpone, Date dateCreation, boolean actived, Collection<MzRole> roles, Collection<Equipe_Inscription> equipeInscriptions, Collection<UserHasDevoir> userHasDevoirs, Collection<Post> posts, Collection<Commentaire> commentaires, Organisation organisation) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.password = password;
		this.photo = photo;
		this.telehpone = telehpone;
		this.dateCreation = dateCreation;
		this.actived = actived;
		this.roles=roles;
		this.equipeInscriptions = equipeInscriptions;
		this.userHasDevoirs = userHasDevoirs;
		this.posts = posts;
		this.commentaires = commentaires;
		this.organisation = organisation;
	}

	public MzUser() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTelehpone() {
		return telehpone;
	}

	public void setTelehpone(String telehpone) {
		this.telehpone = telehpone;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Collection<MzRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<MzRole> roles) {
		this.roles = roles;
	}

	public Collection<Equipe_Inscription> getEquipeInscriptions() {
		return equipeInscriptions;
	}

	public void setEquipeInscriptions(Collection<Equipe_Inscription> equipeInscriptions) {
		this.equipeInscriptions = equipeInscriptions;
	}

	

	public Collection<UserHasDevoir> getUserHasDevoirs() {
		return userHasDevoirs;
	}

	public void setUserHasDevoirs(Collection<UserHasDevoir> userHasDevoirs) {
		this.userHasDevoirs = userHasDevoirs;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	@Override
	public String toString() {
		return "MzUser{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", photo='" + photo + '\'' +
				", telehpone='" + telehpone + '\'' +
				", dateCreation=" + dateCreation +
				", roles=" + roles +
				", equipeInscriptions=" + equipeInscriptions +
				", userHasDevoirs=" + userHasDevoirs +
				", posts=" + posts +
				", commentaires=" + commentaires +
				", organisation=" + organisation +
				'}';
	}
}
