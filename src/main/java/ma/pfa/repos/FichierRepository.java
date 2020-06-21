package ma.pfa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.Fichier;

import java.util.ArrayList;

@RepositoryRestResource
@CrossOrigin("*")
public interface FichierRepository extends JpaRepository<Fichier, Long> {
        ArrayList<Fichier> findByNom(String fileName);
}
