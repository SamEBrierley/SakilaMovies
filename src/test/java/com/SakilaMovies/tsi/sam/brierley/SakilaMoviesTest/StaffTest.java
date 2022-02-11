package com.SakilaMovies.tsi.sam.brierley.SakilaMoviesTest;

import com.SakilaMovies.tsi.sam.brierley.SakilaMovies.Staff;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaffTest {
    private Staff staff = new Staff();

    @Test
    public void testFirstName(){
        Staff testFirstName = new Staff();
        testFirstName.setFirst_name("Carl");
        assertEquals("Incorrect First Name", "Carl", testFirstName.getFirst_name());
    }

    @Test
    public void testLastName(){
        Staff testLastName = new Staff();
        testLastName.setLast_name("Carlson");
        assertEquals("Incorrect Last Name", "Carlson", testLastName.getLast_name());
    }

    @Test
    public void testAddressID(){
        Staff testAddressID = new Staff();
        testAddressID.setAddress_id(3);
        assertEquals("Incorrect AddressID", 3, testAddressID.getAddress_id());
    }

    @Test
    public void testEmail(){
        Staff testEmail = new Staff();
        testEmail.setEmail("CarlCarlson325@gmail.com");
        assertEquals("Incorrect Email", "CarlCarlson325@gmail.com", testEmail.getEmail());
    }

    @Test
    public void testStoreID(){
        Staff testStoreID = new Staff();
        testStoreID.setStore_id(1);
        assertEquals("Incorrect Store ID",1, testStoreID.getStore_id());
    }

    @Test
    public void testUsername(){
        Staff testUsername = new Staff();
        testUsername.setUsername("2Carl");
        assertEquals("Incorrect Username", "2Carl", testUsername.getUsername());
    }

    @Test
    public void testPassword(){
        Staff testPassword = new Staff();
        testPassword.setPassword("root");
        assertEquals("Incorrect Password", "root", testPassword.getPassword());
    }

    @Test
    public void test_constructor(){
        assertTrue(staff instanceof Staff, "Not an instance of Staff");
    }
}
