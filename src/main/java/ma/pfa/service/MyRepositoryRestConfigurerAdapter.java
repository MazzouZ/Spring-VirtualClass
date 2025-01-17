package ma.pfa.service;
import ma.pfa.entities.Cours;
import ma.pfa.entities.Devoir;
import ma.pfa.entities.Organisation;
import ma.pfa.entities.Post;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class MyRepositoryRestConfigurerAdapter implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Post.class,Devoir.class,Cours.class, Organisation.class);
    }
}
