package ma.pfa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Commentaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private Date date;
	@ManyToOne
	private User user;
	@ManyToOne
	private Post post;

	public Commentaire(String label, Date date, User user, Post post) {
		this.label = label;
		this.date = date;
		this.user = user;
		this.post = post;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Commentaire{" +
				"id=" + id +
				", label='" + label + '\'' +
				", date=" + date +
				", user=" + user +
				", post=" + post +
				'}';
	}
}
