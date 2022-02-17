package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.Language;
import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageTest {
    private Language language = new Language();
    private int language_id;

    public void setLanguage_id(int actor_id) {
        this.language_id = language_id;
    }

    @Test
    public void testName(){
        Language testLanguageName = new Language();
        testLanguageName.setName("Spanish");
        assertEquals("Incorrect Language", "Spanish", testLanguageName.getName());

    }

    @Test
    public void test_constructor(){
        assertTrue(language instanceof Language, "Not an instance of Language");
    }
}
