package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.Film;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(4.99, testRentalRate.getRental_rate(), "Incorrect rental rate");
    }

    @Test
    public void testLength(){
        Film testLength = new Film();
        testLength.setLength(99);
        assertEquals("Incorrect movie length", 99, testLength.getLength());
    }

    @Test
    public void testReplacementCost(){
        Film testReplacementCost = new Film();
        testReplacementCost.setReplacement_cost(10.99);
        Assertions.assertEquals(10.99, testReplacementCost.getReplacement_cost(),
                "Incorrect replacement cost");
    }

    @Test
    public void testRating(){
        Film testRating = new Film();
        testRating.setRating("PG-13");
        assertEquals("Incorrect Rating","PG-13", testRating.getRating());
    }

    @Test
    public void testSpecialFeatures(){
        Film testSpecialFeatures = new Film();
        testSpecialFeatures.setSpecial_features("Deleted Scenes");
        assertEquals("Incorrect special Features", "Deleted Scenes",
                testSpecialFeatures.getSpecial_features());

    }

    @Test
    public void test_constructor(){
        assertTrue(film instanceof Film, "Not an instance of Film");
    }
}
