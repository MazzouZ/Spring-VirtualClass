package ma.pfa.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import ma.pfa.entities.MzRole;
import ma.pfa.entities.MzUser;


@CrossOrigin("*")
@RepositoryRestResource
public interface MzRoleRepository extends JpaRepository<MzRole,Long>{
    public MzRole findByRoleName(String roleName);
    

}
