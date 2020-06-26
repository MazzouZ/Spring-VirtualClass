package ma.pfa.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class DevoirHasFiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Devoir devoir;
    @ManyToOne
    private Fichier fichier;
    

    public DevoirHasFiles(Devoir devoir, Fichier fichier) {
		super();
		this.devoir = devoir;
		this.fichier = fichier;
	}



	public DevoirHasFiles() {
		super();
		// TODO Auto-generated constructor stub
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

    public Devoir getDevoir() {
		return devoir;
	}



	public void setDevoir(Devoir devoir) {
		this.devoir = devoir;
	}



	public Fichier getFichier() {
        return fichier;
    }

    public void setFichier(Fichier fichier) {
        this.fichier = fichier;
    }

    
}

