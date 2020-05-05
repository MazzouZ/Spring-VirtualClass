package ma.pfa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.Commentaire;

@RepositoryRestResource
@CrossOrigin("*")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
