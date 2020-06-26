package ma.pfa.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.DevoirHasFiles;
import ma.pfa.entities.Fichier;


@RepositoryRestResource
@CrossOrigin("*")
public interface DevoirHasFilesRepository extends JpaRepository<DevoirHasFiles,Long>{
	 ArrayList<DevoirHasFiles> findByFichier(Fichier fichier);
}
