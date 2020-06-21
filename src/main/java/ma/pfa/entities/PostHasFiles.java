package ma.pfa.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class PostHasFiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Fichier fichier;

    public PostHasFiles(Post post, Fichier fichier) {
        this.post = post;
        this.fichier = fichier;
    }
    
    

    public PostHasFiles() {
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Fichier getFichier() {
        return fichier;
    }

    public void setFichier(Fichier fichier) {
        this.fichier = fichier;
    }

    @Override
    public String toString() {
        return "PostHasFiles{" +
                "id=" + id +
                ", post=" + post +
                ", fichier=" + fichier +
                '}';
    }
}
