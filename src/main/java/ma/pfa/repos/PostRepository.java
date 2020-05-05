package ma.pfa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.Post;

@RepositoryRestResource
@CrossOrigin("*")
public interface PostRepository extends JpaRepository<Post,Long>{

}
