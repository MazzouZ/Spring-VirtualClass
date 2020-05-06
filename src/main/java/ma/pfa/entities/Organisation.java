package ma.pfa.entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Organisation implements Serializable{
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String label;
		private String email;
		private String photo;
		private String CompteOrganisation;
		@OneToMany(mappedBy = "organisation")
		private Collection<User> users;
		@OneToMany(mappedBy = "organisation")
		private Collection<Cours> cours;

	public Organisation(String label, String email, String photo, String compteOrganisation, Collection<User> users, Collection<Cours> cours) {
		this.label = label;
		this.email = email;
		this.photo = photo;
		CompteOrganisation = compteOrganisation;
		this.users = users;
		this.cours = cours;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCompteOrganisation() {
		return CompteOrganisation;
	}

	public void setCompteOrganisation(String compteOrganisation) {
		CompteOrganisation = compteOrganisation;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Collection<Cours> getCours() {
		return cours;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Organisation{" +
				"id=" + id +
				", label='" + label + '\'' +
				", email='" + email + '\'' +
				", photo='" + photo + '\'' +
				", CompteOrganisation='" + CompteOrganisation + '\'' +
				", users=" + users +
				", cours=" + cours +
				'}';
	}
}
