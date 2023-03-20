package com.dto;

public class Director {
    private String directorName;
    private String movieName;

    public Director(String directorName, String movieName) {
        this.directorName = directorName;
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getMovieName() {
        return movieName;
    }

    public Director() {
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
