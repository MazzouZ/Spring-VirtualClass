package ma.pfa.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Equipe_Inscription {
	private static final long serialVersionUID = 1L;
	
	private Date dateInscription;
	private String role;
	public Equipe_Inscription(Date dateInscription, String role) {
		super();
		this.dateInscription = dateInscription;
		this.role = role;
	}
	public Equipe_Inscription() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "Equipe_Inscription [dateInscription=" + dateInscription + ", role=" + role + "]";
	}
	

}
