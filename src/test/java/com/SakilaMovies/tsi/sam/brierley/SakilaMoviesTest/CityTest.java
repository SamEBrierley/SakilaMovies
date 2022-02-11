package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.City;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.assertEquals;

public class CityTest {
    private City cityInstance = new City();

    @Test
    public void testCity(){
        City testCity = new City();
        testCity.setCity("Sydney");
        assertEquals("Incorrect City", "Sydney", testCity.getCity());
    }

    @Test
    public void testCountryID(){
        City testCountryID = new City();
        testCountryID.setCountry_id(8);
        assertEquals("Incorrect Country ID", 8,
                testCountryID.getCountry_id());
    }

    @Test
    public void test_constructor(){
        assertTrue(cityInstance instanceof City, "Not an instance of City");
    }
}
