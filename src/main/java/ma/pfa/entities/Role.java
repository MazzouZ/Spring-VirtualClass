package ma.pfa.entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	@OneToMany(mappedBy = "role")
	private Collection<UserHasRole> roles;

	public Role(String label, Collection<UserHasRole> roles) {
		this.label = label;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", label='" + label + '\'' +
				", roles=" + roles +
				'}';
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

	public Collection<UserHasRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<UserHasRole> roles) {
		this.roles = roles;
	}
}
