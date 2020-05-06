package ma.pfa.repos;

import ma.pfa.entities.PostHasFiles;
import ma.pfa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface PostHasFilesRepository extends JpaRepository<PostHasFiles,Long> {
}
