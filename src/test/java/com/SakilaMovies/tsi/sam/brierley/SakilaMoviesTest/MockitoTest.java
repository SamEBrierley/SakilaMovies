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
        Language saveLanguage = new Language("Test Language");
        String expected = "save";
        String actual = sakilaMoviesDbApplication.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data has not been entered into the mock database");
    }
}
