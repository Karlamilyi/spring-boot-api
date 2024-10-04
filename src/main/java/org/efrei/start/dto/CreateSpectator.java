package org.efrei.start.dto;

import java.util.List;

public class CreateSpectator {


    private String name;

    private List<String> movieId;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getMovieId() {
        return this.movieId;
    }

    public void setMovieId(List<String> movieId) {
        this.movieId = movieId;
    }
    

}
