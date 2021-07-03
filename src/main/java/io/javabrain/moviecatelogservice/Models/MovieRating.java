package io.javabrain.moviecatelogservice.Models;

public class MovieRating {
    private String rating;
    private String movieId;


    public MovieRating(){

    }
    public MovieRating(String rating, String movieId) {
        this.rating = rating;
        this.movieId = movieId;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
