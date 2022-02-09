package com.SakilaMovies.tsi.sam.brierley.SakilaMovies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FilmText {
    @Id
    @GeneratedValue
    private int film_id;

    private String title;
    private String description;

    public FilmText(String title, String description){
        this.title = title;
        this.description=description;
    }

    public FilmText(){

    }

    public int getFilm_id() {
        return film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}