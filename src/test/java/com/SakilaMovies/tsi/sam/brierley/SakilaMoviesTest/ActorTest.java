package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.Actor;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorTest {

    private Actor actor = new Actor();
    private int actor_id;

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    @Test
    public void testFirstName() {

        Actor testFirstName = new Actor();
        testFirstName.setFirst_name("Reanu");
        assertEquals( "Incorrect first name!", "Reanu", testFirstName.getFirst_name());
    }

    @Test
    public void testLastName() {

        Actor testLastName = new Actor();
        testLastName.setLast_name("Keeves");
        assertEquals("Incorrect first name!","Keeves", testLastName.getLast_name());
    }

    @Test
    public void test_constructor(){
        assertTrue(actor instanceof Actor, "Not an instance of Actor");
    }

}
