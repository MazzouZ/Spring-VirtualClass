package ma.pfa.service;


import ma.pfa.entities.MzRole;
import ma.pfa.entities.MzUser;

public interface AccountService {
    public MzUser saveUser(String username, String password, String confirmedPassword,String email,String organisationName);
    public MzRole save(MzRole role);
    public MzUser loadUserByUsername(String username);
    public void addRoleToUser(String username, String rolename);
}
