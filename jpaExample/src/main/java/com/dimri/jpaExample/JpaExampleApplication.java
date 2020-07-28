package com.dimri.jpaExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dimri.jpaExample.data.User;
import com.dimri.jpaExample.data.UserRepository;

@SpringBootApplication
public class JpaExampleApplication {
	
	 private static final Logger log = LoggerFactory.getLogger(JpaExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(UserRepository repository) {
	    return (args) -> {
	      // Save some user into database
	      repository.save(new User("Kailash", "Dimri"));
	      repository.save(new User("Jagmohan", "Negi"));
	      repository.save(new User("Harish", "Sharma"));
	      repository.save(new User("Ram", "Charan"));
	      repository.save(new User("Kim", "Jing"));

	      // fetch all Users
	      log.info("User found with findAll():");
	      log.info("-------------------------------");
	      for (User user : repository.findAll()) {
	        log.info(user.toString());
	      }
	      log.info("");

	      User user = repository.findById(1L).get(); // get user by ID
	      log.info("User found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(user.toString());
	      log.info("");
	     
	      log.info("User found with findByLastName('Dimri'):");
	      log.info("--------------------------------------------");
	      repository.findByLastName("Dimri").forEach(dimri -> {
	        log.info(dimri.toString());
	      });  // fetch user by last name
	      
	      log.info("");
	    };
	  }

}
