package org.efrei.start.dto;

import java.util.List;

public class CreateDirector {


    private String fullname;
    
    private List<String> movieId;

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<String> getMovieId() {
        return this.movieId;
    }

    public void setMovieId(List<String> movieId) {
        this.movieId = movieId;
    }
 
}
