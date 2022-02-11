package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.Actor;
import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.Category;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryTest {

    private Category category = new Category();

    @Test
    public void testCategory(){
        Category testCategory = new Category();
        testCategory.setName("Indie");
        assertEquals("Incorrect Category", "Indie", testCategory.getName());
    }

    @Test
    public void test_constructor(){
        assertTrue(category instanceof Category, "Not an instance of Category");
    }


}
