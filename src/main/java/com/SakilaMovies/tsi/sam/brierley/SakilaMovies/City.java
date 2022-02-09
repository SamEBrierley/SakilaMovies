package com.SakilaMovies.tsi.sam.brierley.SakilaMovies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;

    private String city;
    private int country_id;

    public City(String city){
        this.city=city;
    }

    public City(){

    }

    public int getCity_id() {
        return city_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
