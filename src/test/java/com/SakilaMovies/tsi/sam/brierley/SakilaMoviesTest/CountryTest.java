package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.Country;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountryTest {
    private Country countryInstance = new Country();

    @Test
    public void testCountry(){
        Country testCountry = new Country();
        testCountry.setCountry("England");
        assertEquals("Incorrect Country", "England",
                testCountry.getCountry());
    }

    @Test
    public void test_constructor(){
        assertTrue(countryInstance instanceof Country, "Not an instance of Country");
    }
}
