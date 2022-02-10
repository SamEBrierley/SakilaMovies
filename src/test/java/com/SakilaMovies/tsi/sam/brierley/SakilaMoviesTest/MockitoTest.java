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
import org.springframework.beans.factory.annotation.Autowired;

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
    private FilmTextRepository filmTextRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private StaffRepository staffRepository;

    //Sets up a new database to test with
    @BeforeEach
    void Setup(){
        sakilaMoviesDbApplication = new SakilaMoviesDbApplication(languageRepository,  actorRepository, categoryRepository,
                cityRepository, countryRepository, filmTextRepository, filmRepository, staffRepository);
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
    public void testAddActor(){
        Actor saveActor = new Actor("Reanu", "Keeves");
        String expected = "save";
        String actual = sakilaMoviesDbApplication.addActor(saveActor.getFirst_name(),saveActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Actor data has not been entered into the mock database");
    }
}
