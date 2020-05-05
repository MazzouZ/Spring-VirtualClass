package ma.pfa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.Equipe_Inscription;

@RepositoryRestResource
@CrossOrigin("*")
public interface Equipe_Inscription_Repository extends JpaRepository<Equipe_Inscription,Long>{

}
