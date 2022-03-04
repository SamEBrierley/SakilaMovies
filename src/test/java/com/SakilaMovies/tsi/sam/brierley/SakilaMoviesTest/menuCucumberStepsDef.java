package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class menuCucumberStepsDef {
    private SakilaMoviesDbApplication sakilaMoviesDbApplication;

    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CountryRepository countryRepository;
    @Mock
    private StaffRepository staffRepository;

    @BeforeEach
    void setup() {
        languageRepository = mock(LanguageRepository.class);
        actorRepository = mock(ActorRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        filmRepository = mock(FilmRepository.class);
        cityRepository = mock(CityRepository.class);
        countryRepository= mock(CountryRepository.class);
        staffRepository = mock(StaffRepository.class);

        sakilaMoviesDbApplication = new SakilaMoviesDbApplication(languageRepository, actorRepository,
                categoryRepository, cityRepository, countryRepository, filmRepository, staffRepository);
    }

    String actualResult;
    String expectedResult = "save";

    Language saveLanguage;
    @Given("We have a language entry to add")
    public void we_have_a_language_entry_to_add() {
        setup();
        saveLanguage = new Language("Portuguese");
    }
    @When("We add the language entry")
    public void we_add_the_language_entry() {
        actualResult = sakilaMoviesDbApplication.addLanguage(saveLanguage.getName());
    }

    @Then("The new language should be added to the database and we should return that the new language was saved")
    public void the_new_language_should_be_added_to_the_database_and_we_should_return_that_the_new_language_was_saved() {
        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expectedResult, actualResult, "Language data has not been entered into the mock database");

    }


    Actor storedActor;
    @Given("We have a new Actor to add")
    public void weHaveANewActorToAdd() {
        setup();
        storedActor = new Actor("Test", "Actor");
    }

    @When("We add the new Actor")
    public void weAddTheNewActor() {
        actualResult = sakilaMoviesDbApplication.addActor(storedActor.getFirst_name(), storedActor.getLast_name());
    }

    @Then("The new Actor should be added and a saved conformation returned")
    public void theNewActorShouldBeAddedAndASavedConformationReturned() {
        Assertions.assertEquals(expectedResult, actualResult, "Save new Actor failed.");

        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
    }

    Category storedCategory;
    @Given("We have a new Category to add")
    public void weHaveANewCategoryToAdd() {
        setup();
        storedCategory = new Category("TestCat");
    }

    @When("We add the new Category")
    public void weAddTheNewCategory() {
        actualResult =sakilaMoviesDbApplication.addCategory(storedCategory.getName());
    }

    @Then("The new Category should be added and a saved conformation returned")
    public void theNewCategoryShouldBeAddedAndASavedConformationReturned() {
        Assertions.assertEquals(expectedResult, actualResult, "Save new Category failed.");

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        categoryArgumentCaptor.getValue();
    }

    Film storedFilm;
    @Given("We have a new Film to add")
    public void weHaveANewFilmToAdd() {
        setup();
        storedFilm = new Film("Danger Island 3D", "Danger Island but in 3D", 2022, '3', 3.99, 94, 10.99,
                "NC-17", "Trailers,Deleted Scenes");
    }

    @When("We add the new Film")
    public void weAddTheNewFilm() {
        actualResult = sakilaMoviesDbApplication.addFilm(storedFilm.getTitle(), storedFilm.getDescription(), storedFilm.getRelease_year(), storedFilm.getRental_duration(),
                storedFilm.getRental_rate(), storedFilm.getLength(), storedFilm.getReplacement_cost(), storedFilm.getRating(), storedFilm.getSpecial_features());
    }

    @Then("The new Film should be added and a saved conformation returned")
    public void theNewFilmShouldBeAddedAndASavedConformationReturned() {
        Assertions.assertEquals(expectedResult, actualResult, "Save new Film failed.");

        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
    }

    List<Category> categoryList = new ArrayList<>();
    @Given("There are categorys available")
    public void thereAreCategorysAvailable() {
        setup();
        Category cat1 = new Category("TestCat1");
        Category cat2 = new Category("TestCat2");
        categoryList.add(cat1);
        categoryList.add(cat2);
    }

    @When("The categorys are requested")
    public void theCategorysAreRequested() {
        when(sakilaMoviesDbApplication.getAllCategories()).thenReturn(categoryList);
    }

    @Then("All available categorys should be returned")
    public void allAvailableCategorysShouldBeReturned() {
        Assertions.assertEquals(categoryList, sakilaMoviesDbApplication.getAllCategories(), "Category data was not retreived from Category database table.");
    }

    List<Film> filmList = new ArrayList<>();
    @Given("There are films available")
    public void thereAreFilmsAvailable() {
        setup();
        Film film1 = new Film("Danger Island 3D", "Danger Island but in 3D", 2022, '3', 3.99, 94, 10.99,
                "NC-17", "Trailers,Deleted Scenes");
        Film film2 = new Film("Danger Island 4D", "Danger Island but in 4D", 2024, '4', 4.99, 104, 11.99,
                "NC-17", "Trailers,Deleted Scenes");
        filmList.add(film1);
        filmList.add(film2);
    }

    @When("The films are requested")
    public void theFilmsAreRequested() {
        when(sakilaMoviesDbApplication.getAllFilms()).thenReturn(filmList);
    }

    @Then("All available films should be returned")
    public void allAvailableFilmsShouldBeReturned() {
        Assertions.assertEquals(filmList, sakilaMoviesDbApplication.getAllFilms(), "Film data was not retreived from Film database table.");
    }

    List<Actor> actorList = new ArrayList<>();
    @Given("There are actors available")
    public void thereAreActorsAvailable() {
        setup();
        Actor actor1 = new Actor("Test", "Actor1");
        Actor actor2 = new Actor("Test", "Actor2");
        actorList.add(actor1);
        actorList.add(actor2);
    }

    @When("The actors are requested")
    public void theActorsAreRequested() {
        when(sakilaMoviesDbApplication.getAllActors()).thenReturn(actorList);
    }

    @Then("All available actors should be returned")
    public void allAvailableActorsShouldBeReturned() {
        Assertions.assertEquals(actorList, sakilaMoviesDbApplication.getAllActors(), "Actor data was not retreived from Actor database table.");
    }

    List<Language> languageList = new ArrayList<>();
    @Given("There are languages available")
    public void thereAreLanguagesAvailable() {
        setup();
        Language lang1 = new Language("TestL1");
        Language lang2 = new Language("TestL2");
        languageList.add(lang1);
        languageList.add(lang2);
    }

    @When("The languages are requested")
    public void theLanguagesAreRequested() {
        when(sakilaMoviesDbApplication.getAllLanguages()).thenReturn(languageList);
    }

    @Then("All available languages should be returned")
    public void allAvailableLanguagesShouldBeReturned() {
        Assertions.assertEquals(languageList, sakilaMoviesDbApplication.getAllLanguages(), "Languages data was not retreived from Language database table.");
    }

    Film storedFilm1;
    @Given("There are films available to select from")
    public void thereAreFilmsAvailableToSelectFrom() {
        setup();
        storedFilm1 = new Film("Danger Island 3D", "Danger Island but in 3D", 2022, '3', 3.99, 94, 10.99,
                "NC-17", "Trailers,Deleted Scenes");
    }

    @When("The user requests a specific film")
    public void theUserRequestsASpecificFilm() {
        when(sakilaMoviesDbApplication.getFilmByID(0)).thenReturn(Optional.of(storedFilm1));
    }

    @Then("The specified film will be returned")
    public void theSpecifiedFilmWillBeReturned() {
        Assertions.assertEquals(Optional.of(storedFilm1), sakilaMoviesDbApplication.getFilmByID(0), "Film specified by id was not retrieved from the Film database.");
    }

    //-------------------------------------------------------------------------------------------------------------------------------

    City saveCity;
    @Given("We have a new City to add")
    public void we_have_a_new_city_to_add() {
        setup();
        saveCity = new City("Sydney",'8');

    }
    @When("We add the new city")
    public void we_add_the_new_city() {
        actualResult = sakilaMoviesDbApplication.addCity(saveCity.getCity(), saveCity.getCountry_id());

    }
    @Then("The new city should be added and a saved conformation returned")
    public void the_new_city_should_be_added_and_a_saved_conformation_returned() {
        ArgumentCaptor<City> cityArgumentCaptor = ArgumentCaptor.forClass(City.class);
        verify(cityRepository).save(cityArgumentCaptor.capture());
        cityArgumentCaptor.getValue();
        Assertions.assertEquals(expectedResult,actualResult,"Staff data has not been entered into the mock database");

    }

    Country saveCountry;
    @Given("We have a new Country to add")
    public void we_have_a_new_country_to_add() {
        setup();
        saveCountry = new Country("England");

    }
    @When("We add the new Country")
    public void we_add_the_new_country() {
        actualResult = sakilaMoviesDbApplication.addCountry((saveCountry.getCountry()));
    }
    @Then("The new Country should be added and a saved conformation returned")
    public void the_new_country_should_be_added_and_a_saved_conformation_returned() {
        ArgumentCaptor<Country> countryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        verify(countryRepository).save(countryArgumentCaptor.capture());
        countryArgumentCaptor.getValue();
        Assertions.assertEquals(expectedResult,actualResult,"Country data has not been entered into the mock database");

    }


    @Given("There are film to select from")
    public void there_are_film_to_select_from() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("A film is selected for deletion")
    public void a_film_is_selected_for_deletion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The film should be deleted")
    public void the_film_should_be_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("There are Language to select from")
    public void there_are_language_to_select_from() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("A language is selected for deletion")
    public void a_language_is_selected_for_deletion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The language should be deleted")
    public void the_language_should_be_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("There are staff members to select from")
    public void there_are_staff_members_to_select_from() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("A staff member is selected for deletion")
    public void a_staff_member_is_selected_for_deletion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The staff member should be deleted")
    public void the_staff_member_should_be_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    Actor testActor;
    @Given("There are actors available to select from")
    public void there_are_actors_available_to_select_from() {
        testActor = new Actor("Reanu", "Keeves");
    }
    @When("The user requests a specific actor by ID")
    public void the_user_requests_a_specific_actor_by_id() {
        when(sakilaMoviesDbApplication.getActorByID(1)).thenReturn(Optional.of(testActor));
    }
    @Then("The specified actor will be returned")
    public void the_specified_actor_will_be_returned() {
        Assertions.assertEquals(Optional.of(testActor), sakilaMoviesDbApplication.getActorByID(1), "This Actor Id getting test has failed");
    }

    Category testCategory;
    @Given("There are categories available to select from")
    public void there_are_categories_available_to_select_from() {
        testCategory = new Category("Indie");
    }
    @When("The user requests a specific category by ID")
    public void the_user_requests_a_specific_category_by_id() {
        when(sakilaMoviesDbApplication.getCategoryByID(0)).thenReturn(Optional.of(testCategory));
    }
    @Then("The specified category will be returned")
    public void the_specified_category_will_be_returned() {
        Assertions.assertEquals(Optional.of(testCategory), sakilaMoviesDbApplication.getCategoryByID(0), "This Category ID test has failed");
    }


    @Given("There are cities available")
    public void there_are_cities_available() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The cities are requested")
    public void the_cities_are_requested() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("All available cities should be returned")
    public void all_available_cities_should_be_returned() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("There are countries available")
    public void there_are_countries_available() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The counties are requested")
    public void the_counties_are_requested() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("All available countries should be returned")
    public void all_available_countries_should_be_returned() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("There are staff members available")
    public void there_are_staff_members_available() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The staff members are requested")
    public void the_staff_members_are_requested() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("All available staff members should be returned")
    public void all_available_staff_members_should_be_returned() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}
