package ma.pfa.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.MzUser;
import ma.pfa.entities.Organisation;

@RepositoryRestResource
@CrossOrigin("*")
public interface MzUserRepository extends JpaRepository<MzUser,Long>{
	@RestResource(path = "/byUsername")
    public MzUser findByUsername(@Param("username") String username);
	
	@RestResource(path = "/byOrganisation")
    public List<MzUser> findByOrganisation(@Param("organisation") Organisation organisation);

}
