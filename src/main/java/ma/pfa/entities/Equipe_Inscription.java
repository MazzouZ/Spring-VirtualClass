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
	private MzUser mzUser;
	@ManyToOne
	private Cours cours;

	public Equipe_Inscription(Date dateInscription, String role, MzUser mzUser, Cours cours) {
		this.dateInscription = dateInscription;
		this.role = role;
		this.mzUser = mzUser;
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

	public MzUser getMzUser() {
		return mzUser;
	}

	public void setMzUser(MzUser mzUser) {
		this.mzUser = mzUser;
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
				", mzRole='" + role + '\'' +
				", mzUser=" + mzUser +
				", cours=" + cours +
				'}';
	}
}
