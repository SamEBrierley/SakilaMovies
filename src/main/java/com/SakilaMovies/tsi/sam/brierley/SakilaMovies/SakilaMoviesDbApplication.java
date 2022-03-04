package com.SakilaMovies.tsi.sam.brierley.SakilaMovies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
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
									 CountryRepository countryRepository, FilmRepository filmRepository,
									 StaffRepository staffRepository){
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

	@GetMapping("/Language/{language_id}")
	public @ResponseBody
	Optional<Language> getLanguageByID(@PathVariable int language_id) {
		return languageRepository.findById(language_id);
	}

	@DeleteMapping("/Delete/{language_id}")
	public @ResponseBody
	String deleteLanguageByID(@PathVariable int language_id) {
		languageRepository.deleteById(language_id);
		return "deleted";
	}

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/Actor/{actor_id}")
	public @ResponseBody
	Optional<Actor> getActorByID(@PathVariable int actor_id) {
		return actorRepository.findById(actor_id);
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

	@GetMapping("/Category/{category_id}")
	public @ResponseBody
	Optional<Category> getCategoryByID(@PathVariable int category_id) {
		return categoryRepository.findById(category_id);
	}

	@GetMapping("/AllCities")
	public @ResponseBody
	Iterable<City> getAllCities(){
		return cityRepository.findAll();
	}

	@PostMapping("/AddCity")
	public @ResponseBody String addCity(@RequestParam String city, int country_id){
		City addCity = new City(city, country_id);
		cityRepository.save(addCity);
		return save;
	}

	@GetMapping("/AllCountries")
	public @ResponseBody
	Iterable<Country> getAllCountries(){
		return countryRepository.findAll();
	}

	@PostMapping("/AddCountries")
	public @ResponseBody String addCountry(@RequestParam String country){
		Country addCountry = new Country (country);
		countryRepository.save(addCountry);
		return save;
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms(){
		return filmRepository.findAll();
	}

	@PostMapping ("/AddFilm")
	public @ResponseBody String addFilm(@RequestParam String title, String description, int release_year, int rental_duration,
										double rental_rate, int length, double replacement_cost, String rating,
										String special_features){
		Film addFilm = new Film(title, description, release_year, rental_duration,
								rental_rate,length,replacement_cost, rating,
								special_features);
		filmRepository.save(addFilm);
		return save;
	}

	@GetMapping("/Film/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmByID(@PathVariable int film_id) {
		return filmRepository.findById(film_id);
	}

	@DeleteMapping("/Delete/{film_id}")
	public @ResponseBody
	String deleteFilmByID(@PathVariable int film_id) {
		filmRepository.deleteById(film_id);
		return "deleted";
	}

	@GetMapping("/AllStaff")
	public @ResponseBody
	Iterable<Staff> getAllStaff(){
		return staffRepository.findAll();
	}

	@PostMapping("/AddStaff")
	public @ResponseBody String addStaff(@RequestParam String first_name, String last_name,
										  int address_id, String email,
										  int store_id, String username,
										  String password){
		Staff addStaff = new Staff(first_name, last_name, address_id, email, store_id, username, password);
		staffRepository.save(addStaff);
		return save;
	}

	@DeleteMapping("/Delete/{staff_id}")
	public @ResponseBody
	String deleteStaffByID(@PathVariable int staff_id) {
		staffRepository.deleteById(staff_id);
		return "deleted";
	}

	@DeleteMapping("/DeleteCategory/{categoryID}")
	public @ResponseBody String deleteCategoryByID(@PathVariable int categoryID){
		categoryRepository.deleteById(categoryID);
		return "deleted";
	}
}
