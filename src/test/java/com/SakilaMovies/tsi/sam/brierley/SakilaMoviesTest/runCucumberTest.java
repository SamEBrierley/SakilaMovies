package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
    features = "src/test/resources/Cucumber",
        glue = "com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest")
public class runCucumberTest {

}
