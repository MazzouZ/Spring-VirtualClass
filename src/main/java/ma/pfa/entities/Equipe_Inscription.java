package ma.pfa.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Equipe_Inscription implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateInscription;
	private String role;
	@ManyToOne
	private User user;
	@ManyToOne
	private Cours cours;

	public Equipe_Inscription(Date dateInscription, String role, User user, Cours cours) {
		this.dateInscription = dateInscription;
		this.role = role;
		this.user = user;
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

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Equipe_Inscription{" +
				"id=" + id +
				", dateInscription=" + dateInscription +
				", role='" + role + '\'' +
				", user=" + user +
				", cours=" + cours +
				'}';
	}
}
