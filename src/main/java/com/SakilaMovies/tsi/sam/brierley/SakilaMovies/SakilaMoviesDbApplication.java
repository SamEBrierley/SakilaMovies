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
	private FilmRepository filmRepository;
	@Autowired
	private StaffRepository staffRepository;

	private String save = "save";

	public SakilaMoviesDbApplication(LanguageRepository languageRepository, ActorRepository actorRepository,
									 CategoryRepository categoryRepository, CityRepository cityRepository,
									 CountryRepository countryRepository,
									 FilmRepository filmRepository, StaffRepository staffRepository){
		this.languageRepository = languageRepository;
		this.actorRepository = actorRepository;
		this.categoryRepository= categoryRepository;
		this.cityRepository=cityRepository;
		this.countryRepository=countryRepository;
		this.filmRepository=filmRepository;
		this.staffRepository=staffRepository;
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

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@PostMapping("/AddActor")
	public @ResponseBody String addActor(@RequestParam String first_name, @RequestParam String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return save;
	}

	@GetMapping("/AllCategories")
	public @ResponseBody
	Iterable<Category> getAllCategories(){
		return categoryRepository.findAll();
	}

	@PostMapping("/AddCategory")
	public @ResponseBody String addCategory(@RequestParam String name){
		Category addCategory = new Category(name);
		categoryRepository.save(addCategory);
		return save;
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


	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/AllStaff")
	public @ResponseBody
	Iterable<Staff> getAllStaff(){
		return staffRepository.findAll();
	}

	@PostMapping("/AddStaff")
	public @ResponseBody String addStaff(@RequestParam String first_name, @RequestParam String last_name,
										 @RequestParam int address_id, @RequestParam String email,
										 @RequestParam int store_id, @RequestParam String username,
										 @RequestParam String password){
		Staff addStaff = new Staff(first_name, last_name, address_id, email, store_id, username, password);
		staffRepository.save(addStaff);
		return save;
	}

}
