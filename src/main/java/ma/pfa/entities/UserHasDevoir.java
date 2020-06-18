package ma.pfa.entities;
import java.io.Serializable;

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
	private MzUser mzUser;

	public UserHasDevoir(Devoir devoir, MzUser mzUser) {
		this.devoir = devoir;
		this.mzUser = mzUser;
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

	public MzUser getMzUser() {
		return mzUser;
	}

	public void setMzUser(MzUser mzUser) {
		this.mzUser = mzUser;
	}

	@Override
	public String toString() {
		return "UserHasDevoir{" +
				"note=" + note +
				", devoir=" + devoir +
				", mzUser=" + mzUser +
				'}';
	}
}
