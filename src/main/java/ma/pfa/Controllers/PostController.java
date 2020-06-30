package ma.pfa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.pfa.entities.Post;
import ma.pfa.entities.UserHasDevoir;
import ma.pfa.entities.Cours;
import ma.pfa.entities.Devoir;
import ma.pfa.entities.MzUser;
import ma.pfa.entities.Post;
import ma.pfa.repos.CoursRepository;
import ma.pfa.repos.DevoirRepository;
import ma.pfa.repos.MzUserRepository;
import ma.pfa.repos.PostRepository;
import ma.pfa.repos.UserHasDevoir_Repository;

@RestController
@CrossOrigin("*")
public class PostController {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private MzUserRepository userRepository;
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private DevoirRepository devoirRepository;
	@Autowired
	private UserHasDevoir_Repository userHasDevoirRepository;
	
	 @PostMapping(path = "/postAdd/{id}/{username}")
	    public void postAdd(@PathVariable Long id,@PathVariable String username,@RequestBody Post post) throws Exception{
		 
		 Cours cours = coursRepository.findById(id).get();
	    	MzUser user = userRepository.findByUsername(username);
	    	 if (cours.getId() == null) throw new Exception("Cours Not Found");
	    	 if (user.getId() == null) throw new Exception("User Not Found");
	    	try {
	    		Post com = new Post();
	    	com.setId(post.getId());
	    	com.setTitre(post.getTitre());
	    	com.setDescription(post.getDescription());
	    	com.setDateDebut(post.getDateDebut());
	    	com.setCours(cours);
	    	com.setMzUser(user);
	    	postRepository.save(com);
	    	}catch (Exception e) {
				// TODO: handle exception
			}
		 
	 }
	 
	 @PostMapping(path = "/devoirAdd/{username}")
	    public void devoirAdd(@PathVariable String username,@RequestBody Devoir devoir) throws Exception{
		 
		 //Cours cours = coursRepository.findById(id).get();
	    	MzUser user = userRepository.findByUsername(username);
	    	 //if (cours.getId() == null) throw new Exception("Cours Not Found");
	    	 if (user.getId() == null) throw new Exception("User Not Found");
	    	 
	    	 List<MzUser> users = userRepository.findByOrganisation(user.getOrganisation());
	    	try {
	    		Devoir com = new Devoir();
	    	com.setId(devoir.getId());
	    	com.setTitre(devoir.getTitre());
	    	com.setDescription(devoir.getDescription());
	    	com.setDateDebut(devoir.getDateDebut());
	    	com.setDateFin(devoir.getDateFin());
	    	com.setRegles(devoir.getRegles());
	    	//com.setCours(cours);
	    	devoirRepository.save(com);
	    	for (MzUser u : users) 
	    	{ 
	    	    UserHasDevoir uhd = new UserHasDevoir();
	    	    uhd.setDevoir(com);
	    	    uhd.setMzUser(u);
	    	    uhd.setEtat(false);
	    	    userHasDevoirRepository.save(uhd);
	    	    
	    	}
	    	UserHasDevoir uhdProf = userHasDevoirRepository.chercherUserDevoir(user, com);
    	    uhdProf.setCreatedBy(username);
    	    userHasDevoirRepository.save(uhdProf);
	    	}catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    	
	    	
		 
	 }

}
