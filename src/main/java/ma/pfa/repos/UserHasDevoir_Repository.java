package ma.pfa.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.Devoir;
import ma.pfa.entities.MzUser;
import ma.pfa.entities.UserHasDevoir;

@RepositoryRestResource
@CrossOrigin("*")
public interface UserHasDevoir_Repository extends JpaRepository<UserHasDevoir,Long>{
	@RestResource(path = "/byUser")
    public List<UserHasDevoir> findBymzUser(@Param("user") MzUser user);
	
	@RestResource(path = "/byUserDevoir")
	@Query("SELECT s FROM UserHasDevoir s WHERE s.mzUser = :user AND s.devoir = :devoir ")
	UserHasDevoir chercherUserDevoir(@Param("user") MzUser user,@Param("devoir") Devoir devoir);

}