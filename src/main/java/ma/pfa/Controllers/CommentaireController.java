package ma.pfa.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ma.pfa.entities.Commentaire;
import ma.pfa.entities.Devoir;
import ma.pfa.entities.MzUser;
import ma.pfa.entities.Post;
import ma.pfa.repos.CommentaireRepository;
import ma.pfa.repos.DevoirRepository;
import ma.pfa.repos.MzUserRepository;
import ma.pfa.repos.PostHasFilesRepository;
import ma.pfa.repos.PostRepository;

@RestController
@CrossOrigin("*")
public class CommentaireController {
	@Autowired
    private CommentaireRepository commentaireRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private DevoirRepository devoirRepository;
    @Autowired
    private MzUserRepository userRepository;
    
    @PostMapping(path = "/ComPost/{id}/{username}")
    public void ComPost(@PathVariable Long id,@PathVariable String username,@RequestBody Commentaire commentaire) throws Exception{
    	
    	Post post = postRepository.findById(id).get();
    	MzUser user = userRepository.findByUsername(username);
    	 if (post.getId() == null) throw new Exception("Post Not Found");
    	 if (user.getId() == null) throw new Exception("User Not Found");
    	try {
    		Commentaire com = new Commentaire();
    	com.setId(commentaire.getId());
    	com.setLabel(commentaire.getLabel());
    	com.setDate(commentaire.getDate());
    	com.setPost(post);
    	com.setMzUser(user);
    	commentaireRepository.save(com);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    @PostMapping(path = "/ComDevoir/{id}/{username}")
    public void ComDevoirPost(@PathVariable Long id,@PathVariable String username,@RequestBody Commentaire commentaire) throws Exception{
    	
    	Devoir devoir = devoirRepository.findById(id).get();
    	MzUser user = userRepository.findByUsername(username);
    	 if (devoir.getId() == null) throw new Exception("Devoir Not Found");
    	 if (user.getId() == null) throw new Exception("User Not Found");
    	try {
    		Commentaire com = new Commentaire();
    	com.setId(commentaire.getId());
    	com.setLabel(commentaire.getLabel());
    	com.setDate(commentaire.getDate());
    	com.setDevoir(devoir);
    	com.setMzUser(user);
    	commentaireRepository.save(com);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    }

}
