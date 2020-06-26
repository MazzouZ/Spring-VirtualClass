package ma.pfa.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ma.pfa.entities.MzUser;
import ma.pfa.entities.UserHasDevoir;
import ma.pfa.repos.MzUserRepository;
import ma.pfa.repos.UserHasDevoir_Repository;

@RestController
@CrossOrigin("*")
public class UserHasDevoirController {
	/*@Autowired
    private UserHasDevoir_Repository userHasDevoirRepo;
	@Autowired
    private MzUserRepository userRepository;
	
	@GetMapping(path = "/getUserDevoir/{username}", produces = MediaType.ALL_VALUE)
	public List<UserHasDevoir> getUserDevoir(@PathVariable("username") String username){
		MzUser user = userRepository.findByUsername(username);
		List<UserHasDevoir> listUserDevoir = userHasDevoirRepo.findBymzUser(user);
		return listUserDevoir;
		
	}*/
	
}
