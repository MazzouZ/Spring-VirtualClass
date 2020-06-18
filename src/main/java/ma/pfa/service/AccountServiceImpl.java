package ma.pfa.service;

import ma.pfa.entities.MzRole;
import ma.pfa.entities.MzUser;
import ma.pfa.entities.Organisation;
import ma.pfa.repos.MzRoleRepository;
import ma.pfa.repos.MzUserRepository;
import ma.pfa.repos.OrganisationRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private MzUserRepository mzUserRepository;
    private OrganisationRepository organisationRepository;
    private MzRoleRepository mzRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(MzUserRepository mzUserRepository, MzRoleRepository mzRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder,OrganisationRepository organisationRepository) {
        this.mzUserRepository = mzUserRepository;
        this.mzRoleRepository = mzRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.organisationRepository =organisationRepository;
    }

    @Override
    public MzUser saveUser(String username, String password, String confirmedPassword,String email,String organisationName) {
        MzUser user= mzUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        MzUser mzUser =new MzUser();
        Organisation organisation=new Organisation();
        organisation.setLabel(organisationName);
        organisation.setEmail(email);
        organisation.setCompteOrganisation(organisationName+".com");
        organisationRepository.save(organisation);
        mzUser.setUsername(username);
        mzUser.setEmail(email);
        mzUser.setActived(true);
        mzUser.setPassword(bCryptPasswordEncoder.encode(password));
        mzUser.setOrganisation(organisation);
        mzUserRepository.save(mzUser);
        addRoleToUser(username,"AdminOrganisation");
        return mzUser;
    }

    @Override
    public MzRole save(MzRole role) {
        return mzRoleRepository.save(role);
    }

    @Override
    public MzUser loadUserByUsername(String username) {
        return mzUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        MzUser mzUser = mzUserRepository.findByUsername(username);
        MzRole mzRole = mzRoleRepository.findByRoleName(rolename);
        mzUser.getRoles().add(mzRole);
    }
}
