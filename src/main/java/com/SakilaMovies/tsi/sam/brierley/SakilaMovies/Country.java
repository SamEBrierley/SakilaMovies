package com.SakilaMovies.tsi.sam.brierley.SakilaMovies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    @GeneratedValue
    private int country_id;

    private String country;

    public Country(String country){
        this.country=country;
    }

    public Country(){

    }

    public int getCountry_id() {
        return country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
