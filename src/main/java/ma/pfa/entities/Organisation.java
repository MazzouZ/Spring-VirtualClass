package ma.pfa.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Organisation {
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String label;
		private String email;
		private String photo;
		private String CompteOrganisation;
		public Organisation(Long id, String label, String email, String photo, String compteOrganisation) {
			super();
			this.id = id;
			this.label = label;
			this.email = email;
			this.photo = photo;
			CompteOrganisation = compteOrganisation;
		}
		
		public Organisation() {
			super();
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public String getCompteOrganisation() {
			return CompteOrganisation;
		}
		public void setCompteOrganisation(String compteOrganisation) {
			CompteOrganisation = compteOrganisation;
		}

		@Override
		public String toString() {
			return "Organisation [id=" + id + ", label=" + label + ", email=" + email + ", photo=" + photo
					+ ", CompteOrganisation=" + CompteOrganisation + "]";
		}
		
		

}
