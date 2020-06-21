package ma.pfa.Controllers;

import ma.pfa.entities.Fichier;
import ma.pfa.entities.Post;
import ma.pfa.entities.PostHasFiles;
import ma.pfa.repos.FichierRepository;
import ma.pfa.repos.PostHasFilesRepository;
import ma.pfa.repos.PostRepository;
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
    private PostHasFilesRepository postHasFilesRepository;

    @GetMapping(path = "/getFile/{fileName}", produces = MediaType.ALL_VALUE)
    public byte[] getFile(@PathVariable("fileName") String fileName) throws Exception {
        Fichier fichier = fichierRepository.findByNom(fileName).get(0);
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/PostFichiers/" + fichier.getNom()));
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

}


