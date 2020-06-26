package ma.pfa.Controllers;

import lombok.Data;
import ma.pfa.entities.Fichier;
import ma.pfa.entities.MzUser;
import ma.pfa.entities.Post;
import ma.pfa.entities.PostHasFiles;
import ma.pfa.repos.MzUserRepository;
import ma.pfa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    MzUserRepository mzUserRepository;
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public MzUser register(@RequestBody UserForm userForm){
        return  accountService.saveUser(
                userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword(),userForm.getEmail(),userForm.getOrganisationName());
    }
    @PostMapping("/addUser/{id}/{selectedRole}")
    public MzUser addUser(@RequestBody MzUser mzUser, @PathVariable Long id,@PathVariable String selectedRole){
        return  accountService.addUser(mzUser,id,selectedRole);
    }
    @PostMapping(path = "/addProfile/{username}")
    public void addProfile(MultipartFile file, @PathVariable String username) throws Exception {

        MzUser mzUser=mzUserRepository.findByUsername(username);
        if (mzUser == null) throw new RuntimeException("User Not Found ;) ");

        mzUser.setPhoto(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home") + "/PostFichiers/" + mzUser.getPhoto()), file.getBytes());
        mzUserRepository.save(mzUser);
    }
    @GetMapping(path = "/getProfile/{username}", produces = MediaType.ALL_VALUE)
    public byte[] getProfile(@PathVariable("username") String username) throws Exception {
        MzUser mzUser=mzUserRepository.findByUsername(username);
        if (mzUser == null) throw new RuntimeException("User Not Found ;) ");
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/PostFichiers/" + mzUser.getPhoto()));
    }
}


class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;
    private String email;
    private String organisationName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }
}
