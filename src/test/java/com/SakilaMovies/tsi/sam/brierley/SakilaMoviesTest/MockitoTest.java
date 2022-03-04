package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;
import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.*;
import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.SakilaMoviesDbApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    private SakilaMoviesDbApplication sakilaMoviesDbApplication;

    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CountryRepository countryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private StaffRepository staffRepository;

    //Sets up a new database to test with
    @BeforeEach
    void Setup(){
        sakilaMoviesDbApplication = new SakilaMoviesDbApplication(languageRepository,  actorRepository, categoryRepository,
                cityRepository, countryRepository, filmRepository, staffRepository);
    }
    @Test
    public void testGetLanguage(){
        Language testLanguage = new Language("name");
        List<Language> languageList = new ArrayList<>();
        languageList.add(testLanguage);
        when(sakilaMoviesDbApplication.getAllLanguages()).thenReturn(languageList);
        Assertions.assertEquals(languageList, sakilaMoviesDbApplication.getAllLanguages(), "This Language getting test has failed");
    }

    @Test
    public void testGetFilm(){
        Film testFilm = new Film("Danger Island 3D", "Danger Island but in 3D", 2022, '3', 3.99, 94, 10.99,
                "NC-17", "Trailers,Deleted Scenes");
        List<Film> filmList = new ArrayList<>();
        filmList.add(testFilm);
        when(sakilaMoviesDbApplication.getAllFilms()).thenReturn(filmList);
        Assertions.assertEquals(filmList, sakilaMoviesDbApplication.getAllFilms(), "This film getting test has failed");
    }

    @Test
    public void testGetActor(){
        Actor testActor = new Actor("Reanu", "Keeves");
        List<Actor> actorList = new ArrayList<>();
        actorList.add(testActor);
        when(sakilaMoviesDbApplication.getAllActors()).thenReturn(actorList);
        Assertions.assertEquals(actorList, sakilaMoviesDbApplication.getAllActors(), "This Actor getting test has failed");
    }

    @Test
    public void testGetCategory(){
        Category testCategory = new Category("Name");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(testCategory);
        when(sakilaMoviesDbApplication.getAllCategories()).thenReturn(categoryList);
        Assertions.assertEquals(categoryList, sakilaMoviesDbApplication.getAllCategories(), "This Category getting test has failed");
    }
    @Test
    public void testGetStaff(){
        Staff testStaff = new Staff("Carl", "Carlson", '3',
                "CarlCarlson325@gmail.com", '1', "2Carl", "root");
        List<Staff> staffList = new ArrayList<>();
        staffList.add(testStaff);
        when(sakilaMoviesDbApplication.getAllStaff()).thenReturn(staffList);
        Assertions.assertEquals(staffList, sakilaMoviesDbApplication.getAllStaff(), "This Staff getting test has failed");
    }

    @Test
    public void testAddLanguage(){
        Language saveLanguage = new Language("Portuguese");
        String expected = "save";
        String actual = sakilaMoviesDbApplication.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Language data has not been entered into the mock database");
    }

    @Test
    public void testAddCategory(){
        Category saveCategory = new Category("Indie");
        String expected = "save";
        String actual = sakilaMoviesDbApplication.addCategory(saveCategory.getName());
        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        categoryArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual,"Category data has not been entered into the mock database");
    }

    @Test
    public void testGetCategoryById(){
        Category testCategory = new Category("Indie");
        when(sakilaMoviesDbApplication.getCategoryByID(0)).thenReturn(Optional.of(testCategory));
        Assertions.assertEquals(Optional.of(testCategory), sakilaMoviesDbApplication.getCategoryByID(0), "This Category ID test has failed");
    }

    @Test
    public void testAddActor(){
        Actor saveActor = new Actor("Reanu", "Keeves");
        String expected = "save";
        String actual = sakilaMoviesDbApplication.addActor(saveActor.getFirst_name(),saveActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Actor data has not been entered into the mock database");
    }

    @Test
    public void testGetActorById(){
        Actor testActor = new Actor("Reanu", "Keeves");
        when(sakilaMoviesDbApplication.getActorByID(0)).thenReturn(Optional.of(testActor));
        Assertions.assertEquals(Optional.of(testActor), sakilaMoviesDbApplication.getActorByID(0), "This Actor Id getting test has failed");
    }

    @Test
    public void testAddStaff(){
        Staff saveStaff = new Staff("Carl", "Carlson", '3',
                "CarlCarlson325@gmail.com", '1', "2Carl", "root");
        String expected = "save";
        String actual = sakilaMoviesDbApplication.addStaff(saveStaff.getFirst_name(), saveStaff.getLast_name(),
                saveStaff.getAddress_id(), saveStaff.getEmail(), saveStaff.getStore_id(), saveStaff.getUsername(),
                saveStaff.getPassword());
        ArgumentCaptor<Staff> staffArgumentCaptor = ArgumentCaptor.forClass(Staff.class);
        verify(staffRepository).save(staffArgumentCaptor.capture());
        staffArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Staff data has not been entered into the mock database");
    }

    @Test
    public void testAddCountry(){
        Country saveCountry = new Country("England");
        String expected = "save";
        String actual = sakilaMoviesDbApplication.addCountry((saveCountry.getCountry()));
        ArgumentCaptor<Country> countryArgumentCaptor = ArgumentCaptor.forClass(Country.class);
        verify(countryRepository).save(countryArgumentCaptor.capture());
        countryArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Country data has not been entered into the mock database");
    }
    @Test
    public void testAddCity(){
        City saveCity = new City("Sydney",'8');
        String expected = "save";
        String actual = sakilaMoviesDbApplication.addCity(saveCity.getCity(), saveCity.getCountry_id());
        ArgumentCaptor<City> cityArgumentCaptor = ArgumentCaptor.forClass(City.class);
        verify(cityRepository).save(cityArgumentCaptor.capture());
        cityArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Staff data has not been entered into the mock database");

    }

    @Test
    public void testAddFilm(){
        Film saveFilm = new Film("Danger Island 3D", "Danger Island but in 3D", 2022, '3', 3.99, 94, 10.99,
                "NC-17", "Trailers,Deleted Scenes");
        String expected = "save";
        String actual = sakilaMoviesDbApplication.addFilm(saveFilm.getTitle(),saveFilm.getDescription(), saveFilm.getRelease_year(),
                saveFilm.getRental_duration(), saveFilm.getRental_rate(), saveFilm.getLength(), saveFilm.getReplacement_cost(),
                saveFilm.getRating(), saveFilm.getSpecial_features());
        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Film data has not been entered into the mock database");
    }
    @Test
    public void testGetFilmById(){
        Film testFilm = new Film("Danger Island 3D", "Danger Island but in 3D", 2022, '3', 3.99, 94, 10.99,
                "NC-17", "Trailers,Deleted Scenes");
        when(sakilaMoviesDbApplication.getFilmByID(0)).thenReturn(Optional.of(testFilm));
        Assertions.assertEquals(Optional.of(testFilm), sakilaMoviesDbApplication.getFilmByID(0), "This Film Id getting test has failed");
    }

    @Test
    void testDeleteCategory(){
        String actual = sakilaMoviesDbApplication.deleteCategoryByID(1);
        String expected = "deleted";
        ArgumentCaptor<Integer> categoryArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(categoryRepository).deleteById(categoryArgumentCaptor.capture());
        categoryArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "The specified category was not successfully deleted.");
    }
}
