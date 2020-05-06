package ma.pfa.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class UserHasDevoir implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private double note;
	@ManyToOne
	private Devoir devoir;
	@ManyToOne
	private User user;

	public UserHasDevoir(Devoir devoir, User user) {
		this.devoir = devoir;
		this.user = user;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Devoir getDevoir() {
		return devoir;
	}

	public void setDevoir(Devoir devoir) {
		this.devoir = devoir;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserHasDevoir{" +
				"note=" + note +
				", devoir=" + devoir +
				", user=" + user +
				'}';
	}
}
