package ma.pfa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.UserHasDevoir;

@RepositoryRestResource
@CrossOrigin("*")
public interface UserHasDevoir_Repository extends JpaRepository<UserHasDevoir,Long>{

}