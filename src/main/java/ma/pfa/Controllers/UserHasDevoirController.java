package ma.pfa.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.pfa.entities.Cours;
import ma.pfa.entities.Devoir;
import ma.pfa.entities.MzUser;
import ma.pfa.entities.Post;
import ma.pfa.entities.UserHasDevoir;
import ma.pfa.repos.DevoirRepository;
import ma.pfa.repos.MzUserRepository;
import ma.pfa.repos.UserHasDevoir_Repository;

@RestController
@CrossOrigin("*")
public class UserHasDevoirController {
	@Autowired
    private UserHasDevoir_Repository userHasDevoirRepo;
	@Autowired
    private MzUserRepository userRepository;
	@Autowired
	private DevoirRepository devoirRepository;
	
	
	@PostMapping(path = "/AssigneNoteToUser/{username}/{note}")
    public void AssigneNoteToUser(@PathVariable String username,@PathVariable Double note,@RequestBody Devoir devoir) throws Exception{
		MzUser mzUser=userRepository.findByUsername(username);
		UserHasDevoir userHasDevoir=userHasDevoirRepo.chercherUserDevoir(mzUser, devoir);
		userHasDevoir.setNote(note);
		userHasDevoirRepo.save(userHasDevoir);
	  }
	/*
	@GetMapping(path = "/getUserDevoir/{username}", produces = MediaType.ALL_VALUE)
	public List<UserHasDevoir> getUserDevoir(@PathVariable("username") String username){
		MzUser user = userRepository.findByUsername(username);
		List<UserHasDevoir> listUserDevoir = userHasDevoirRepo.findBymzUser(user);
		return listUserDevoir;
		
	}*/
	
}
