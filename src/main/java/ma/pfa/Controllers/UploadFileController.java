package ma.pfa.Controllers;

import ma.pfa.entities.Devoir;
import ma.pfa.entities.DevoirHasFiles;
import ma.pfa.entities.Fichier;
import ma.pfa.entities.MzUser;
import ma.pfa.entities.Post;
import ma.pfa.entities.PostHasFiles;
import ma.pfa.entities.UserHasDevoir;
import ma.pfa.repos.DevoirHasFilesRepository;
import ma.pfa.repos.DevoirRepository;
import ma.pfa.repos.FichierRepository;
import ma.pfa.repos.MzUserRepository;
import ma.pfa.repos.PostHasFilesRepository;
import ma.pfa.repos.PostRepository;
import ma.pfa.repos.UserHasDevoir_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;


@RestController
@CrossOrigin("*")
public class UploadFileController {
    @Autowired
    private FichierRepository fichierRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private DevoirRepository devoirRepository;
    @Autowired
    private MzUserRepository userRepository;
    @Autowired
    private PostHasFilesRepository postHasFilesRepository;
    @Autowired
    private DevoirHasFilesRepository devoirHasFilesRepository;
    @Autowired
    private UserHasDevoir_Repository userHasDevoirRepository;

    @GetMapping(path = "/getFile/{fileName}", produces = MediaType.ALL_VALUE)
    public byte[] getFile(@PathVariable("fileName") String fileName) throws Exception {
        Fichier fichier = fichierRepository.findByNom(fileName).get(0);
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/PostFichiers/" + fichier.getNom()));
    }
    
    @GetMapping(path = "/getDevoirFile/{fileName}", produces = MediaType.ALL_VALUE)
    public byte[] getDevoirFile(@PathVariable("fileName") String fileName) throws Exception {
        Fichier fichier = fichierRepository.findByNom(fileName).get(0);
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/DevoirFichiers/" + fichier.getNom()));
    }

    @PostMapping(path = "/chargerFichier/{id}")
    public void chargerFichier(MultipartFile file, @PathVariable Long id) throws Exception {
        Post post = postRepository.findById(id).get();

        if (post.getId() == null) throw new Exception("Post Not Found ;) ");

        Fichier fichier = new Fichier();
        try {
            fichier = fichierRepository.findByNom(file.getOriginalFilename()).get(0);
        } catch (Exception e) {
            fichier = new Fichier();
        } finally {
            fichier.setNom(file.getOriginalFilename());
            Files.write(Paths.get(System.getProperty("user.home") + "/PostFichiers/" + fichier.getNom()), file.getBytes());
            fichierRepository.save(fichier);
            PostHasFiles postHasFiles = new PostHasFiles();
            try {
                postHasFiles = postHasFilesRepository.findByFichier(fichier).get(0);
            } catch (Exception e) {
                postHasFiles = new PostHasFiles();
            } finally {
                postHasFiles.setFichier(fichier);
                postHasFiles.setPost(post);
                postHasFilesRepository.save(postHasFiles);
            }
        }
    }
    
    @PostMapping(path = "/chargerDevoirFichier/{id}/{username}")
    public void chargerDevoirFichier(MultipartFile file, @PathVariable Long id,@PathVariable String username) throws Exception {
        Devoir dev = devoirRepository.findById(id).get();
        MzUser user = userRepository.findByUsername(username);
        if (dev.getId() == null) throw new Exception("Devoir Not Found ");

        Fichier fichier = new Fichier();
        try {
            fichier = fichierRepository.findByNom(file.getOriginalFilename()).get(0);
        } catch (Exception e) {
            fichier = new Fichier();
        } finally {
            fichier.setNom(file.getOriginalFilename());
            Files.write(Paths.get(System.getProperty("user.home") + "/DevoirFichiers/" + fichier.getNom()), file.getBytes());
            fichierRepository.save(fichier);
            DevoirHasFiles devoirHasFiles = new DevoirHasFiles();
            UserHasDevoir userHasDevoir = userHasDevoirRepository.chercherUserDevoir(user, dev);
            try {
            	devoirHasFiles = devoirHasFilesRepository.findByFichier(fichier).get(0);
            } catch (Exception e) {
            	devoirHasFiles = new DevoirHasFiles();
            } finally {
            	devoirHasFiles.setFichier(fichier);
            	devoirHasFiles.setDevoir(dev);
            	devoirHasFilesRepository.save(devoirHasFiles);
            	userHasDevoir.setEtat(true);
            	userHasDevoirRepository.save(userHasDevoir);
            }
        }
    }

    @DeleteMapping(path = "/deleteFile/{fileName}")
    public void deleteFile(@PathVariable("fileName") String fileName) throws Exception {
        Fichier fichier = new Fichier();
        try {
            fichier = fichierRepository.findByNom(fileName).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<PostHasFiles> postHasFiles = new ArrayList<>();
        postHasFiles = postHasFilesRepository.findByFichier(fichier);
        postHasFiles.forEach(pHf -> {
            postHasFilesRepository.delete(pHf);
        });

    }
    
    @DeleteMapping(path = "/deleteDevoirFile/{fileName}")
    public void deleteDevoirFile(@PathVariable("fileName") String fileName) throws Exception {
        Fichier fichier = new Fichier();
        try {
            fichier = fichierRepository.findByNom(fileName).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<DevoirHasFiles> devoirHasFiles = new ArrayList<>();
        devoirHasFiles = devoirHasFilesRepository.findByFichier(fichier);
        devoirHasFiles.forEach(pHf -> {
        	devoirHasFilesRepository.delete(pHf);
        });

    }

}


