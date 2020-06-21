package ma.pfa.repos;

import ma.pfa.entities.Fichier;
import ma.pfa.entities.PostHasFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Collection;

@RepositoryRestResource
@CrossOrigin("*")
public interface PostHasFilesRepository extends JpaRepository<PostHasFiles,Long> {
    ArrayList<PostHasFiles> findByFichier(Fichier fichier);

}
