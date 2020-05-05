package ma.pfa.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cours {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private String code;
	private String specialite;
	public Cours(Long id, String label,String code, String specialite) {
		super();
		this.id = id;
		this.label = label;
		this.specialite = specialite;
		this.code= code;
	}
	
	public Cours() {
		super();
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	@Override
	public String toString() {
		return "Cours [id=" + id + ", label=" + label + ", specialite=" + specialite + "]";
	}
	

}
