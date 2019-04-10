package com.chiocchetti.springit;

import com.chiocchetti.springit.config.SpringitProperties;
import com.chiocchetti.springit.domain.Comment;
import com.chiocchetti.springit.domain.Link;
import com.chiocchetti.springit.repository.CommentRepository;
import com.chiocchetti.springit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

	@Autowired
	private SpringitProperties springitProperties;
	private ApplicationContext applicationContext;

	public static void main(String[] args) {

		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {
			System.out.println("Welcome Message: " + springitProperties.getWelcomeMsg());
			System.out.println("Printing out all the bean names in the application context:");
			System.out.println("-----------------------------------------------------------");

			Link link = new Link("Getting Started with Spring Boot 2","https://therealdanvega.com/spring-boot-2");
			linkRepository.save(link);

			Comment comment = new Comment("This Spring Boot 2 Link is awesome",link);
			commentRepository.save(comment);
			link.addComment(comment);

			link.addComment(comment);

			System.out.println("We just inserted a link and a comment");
			System.out.println("=====================================");
		};
	}

}
