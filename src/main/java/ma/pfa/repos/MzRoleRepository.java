package ma.pfa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.pfa.entities.MzRole;

@RepositoryRestResource
@CrossOrigin("*")
public interface MzRoleRepository extends JpaRepository<MzRole,Long>{
    public MzRole findByRoleName(String roleName);
}
