package ma.pfa;

import ma.pfa.entities.MzRole;
import ma.pfa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringVirtualClassApplication {

	@Autowired
	AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(SpringVirtualClassApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AccountService accountService){
		return args->{
			accountService.save(new MzRole("SuperAdmin"));
			accountService.save(new MzRole("AdminOrganisation"));
			accountService.save(new MzRole("Student"));
			accountService.save(new MzRole("Professor"));
		};
	}
	@Bean
	BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}

}
