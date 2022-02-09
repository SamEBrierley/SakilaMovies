package com.SakilaMovies.tsi.sam.brierley.SakilaMovies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class SakilaMoviesDbApplication {

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private FilmTextRepository filmTextRepository;

	@Autowired
	private FilmRepository filmRepository;

	private String save = "save";
	public SakilaMoviesDbApplication(LanguageRepository languageRepository,
									 ActorRepository actorRepository,
									 CategoryRepository categoryRepository,
									 CityRepository cityRepository,
									 CountryRepository countryRepository,
									 FilmTextRepository filmTextRepository,
									 FilmRepository filmRepository){
		this.languageRepository = languageRepository;
		this.actorRepository = actorRepository;
		this.categoryRepository= categoryRepository;
		this.cityRepository=cityRepository;
		this.countryRepository=countryRepository;
		this.filmTextRepository=filmTextRepository;
		this.filmRepository=filmRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(SakilaMoviesDbApplication.class, args);
	}

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable<Language> getAllLanguages(){
		return languageRepository.findAll();
	}

	@PostMapping("/AddLanguage")
	public @ResponseBody String addLanguage(@RequestParam String name){
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}
//	Language addLanguage(@Validated @RequestBody Language language){
//		return languageRepository.save(language);
//	}

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@PostMapping("/AddActors")
	Actor addActor(@Validated @RequestBody Actor actor) {
		return actorRepository.save(actor);
	}

	@GetMapping("/AllCategories")
	public @ResponseBody
	Iterable<Category> getAllCategories(){
		return categoryRepository.findAll();
	}

	@GetMapping("/AllCities")
	public @ResponseBody
	Iterable<City> getAllCities(){
		return cityRepository.findAll();
	}

	@GetMapping("/AllCountries")
	public @ResponseBody
	Iterable<Country> getAllCountries(){
		return countryRepository.findAll();
	}

	@GetMapping("/AllFilmText")
	public @ResponseBody
	Iterable<FilmText> getAllFilmText(){
		return filmTextRepository.findAll();
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms(){
		return filmRepository.findAll();
	}



}
