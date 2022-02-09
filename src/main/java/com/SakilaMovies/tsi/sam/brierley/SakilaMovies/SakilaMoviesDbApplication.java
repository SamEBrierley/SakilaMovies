package com.SakilaMovies.tsi.sam.brierley.SakilaMovies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class SakilaMoviesDbApplication {

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private ActorRepository actorRepository;

	public SakilaMoviesDbApplication(LanguageRepository languageRepository,
									 ActorRepository actorRepository){
		this.languageRepository = languageRepository;
		this.actorRepository = actorRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(SakilaMoviesDbApplication.class, args);
	}

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable<Language> getAllLanguages(){
		return languageRepository.findAll();
	}

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}
}
