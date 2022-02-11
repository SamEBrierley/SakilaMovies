package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.Film;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilmTest {
    private Film film = new Film();

    @Test
    public void testTitle(){
        Film testTitle = new Film();
        testTitle.setTitle("The Adventures of Joe Danger IV");
        assertEquals("Incorrect title", "The Adventures of Joe Danger IV", testTitle.getTitle());
    }

    @Test
    public void testDescription(){
        Film testDescription = new Film();
        testDescription.setDescription("Guess what? Joe Danger is in danger again");
        assertEquals("Incorrect description", "Guess what? Joe Danger is in danger again",
                testDescription.getDescription());
    }

    @Test
    public void testReleaseYear(){
        Film testReleaseYear = new Film();
        testReleaseYear.setRelease_year(2002);
        assertEquals("Incorrect release year", 2002, testReleaseYear.getRelease_year());
    }

    @Test
    public void testRentalDuration(){
        Film testRentalDuration = new Film();
        testRentalDuration.setRental_duration(1);
        assertEquals("Incorrect rental duration", 1, testRentalDuration.getRental_duration());
    }

    @Test
    public void testRentalRate(){
        Film testRentalRate = new Film();
        testRentalRate.setRental_rate(4.99);
    }

    @Test
    public void test_constructor(){
        assertTrue(film instanceof Film, "Not an instance of Film");
    }
}
