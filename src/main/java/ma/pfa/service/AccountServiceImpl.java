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

import java.util.Date;

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
        mzUser.setDateCreation(new Date(System.currentTimeMillis()));
        mzUser.setPassword(bCryptPasswordEncoder.encode(password));
        mzUser.setOrganisation(organisation);
        mzUserRepository.save(mzUser);
        addRoleToUser(username,"AdminOrganisation");
        return mzUser;
    }
    @Override
    public MzUser addUser(MzUser mzUserParam,Long idOrganisation,String selectedRole) {
        MzUser user= mzUserRepository.findByUsername(mzUserParam.getUsername());
        if(user!=null) throw new RuntimeException("User already exists");
        MzUser mzUser =new MzUser();
        Organisation organisation=organisationRepository.findById(idOrganisation).get();
        mzUser.setUsername(mzUserParam.getUsername());
        mzUser.setEmail(mzUserParam.getEmail());
        mzUser.setActived(true);
        mzUser.setPassword(bCryptPasswordEncoder.encode(mzUserParam.getPassword()));
        mzUser.setOrganisation(organisation);
        mzUser.setNom(mzUserParam.getNom());
        mzUser.setPrenom(mzUserParam.getPrenom());
        mzUser.setTelehpone(mzUserParam.getTelehpone());
        mzUser.setDateCreation(mzUserParam.getDateCreation());
        mzUserRepository.save(mzUser);
        addRoleToUser(mzUserParam.getUsername(),selectedRole);
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
