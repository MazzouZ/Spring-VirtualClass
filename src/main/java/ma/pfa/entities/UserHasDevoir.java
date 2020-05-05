package ma.pfa.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserHasDevoir {
	private static final long serialVersionUID = 1L;
	
	private double note;

	public UserHasDevoir(double note) {
		super();
		this.note = note;
	}

	public UserHasDevoir() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "UserHasDevoir [note=" + note + "]";
	}
	

}
