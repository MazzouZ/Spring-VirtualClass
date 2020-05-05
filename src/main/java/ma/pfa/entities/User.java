package ma.pfa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
//@Entity
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User implements Serializable {
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
	private String login;
	private String password;
	private String photo;
	private String telehpone;
	private Date dateCreation;
	private String role;

	public User() {
		super();
	}

	public User(String nom, String prenom, String email, String login, String password, String photo, String telehpone,
			Date dateCreation, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.password = password;
		this.photo = photo;
		this.telehpone = telehpone;
		this.dateCreation = dateCreation;
		this.role = role;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", login=" + login
				+ ", password=" + password + ", photo=" + photo + ", telehpone=" + telehpone + ", dateCreation="
				+ dateCreation + ", role=" + role + "]";
	}
	

}
