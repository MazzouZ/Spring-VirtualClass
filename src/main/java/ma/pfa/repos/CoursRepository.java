package ma.pfa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.Cours;

@RepositoryRestResource
@CrossOrigin("*")
public interface CoursRepository extends JpaRepository<Cours,Long>{

}
