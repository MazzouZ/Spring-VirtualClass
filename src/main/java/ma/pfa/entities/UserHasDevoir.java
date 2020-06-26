package ma.pfa.entities;
import java.io.Serializable;

import javax.persistence.*;

@Entity
public class UserHasDevoir implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double note;
	private boolean etat;
	@ManyToOne
	private Devoir devoir;
	@ManyToOne
	private MzUser mzUser;

	
	
	

	public UserHasDevoir(double note, boolean etat, Devoir devoir, MzUser mzUser) {
		super();
		this.note = note;
		this.etat = etat;
		this.devoir = devoir;
		this.mzUser = mzUser;
	}



	public UserHasDevoir() {
		super();
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
	
	

	public boolean isEtat() {
		return etat;
	}



	public void setEtat(boolean etat) {
		this.etat = etat;
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
