package io.javabrain.moviecatelogservice.Controller;


import io.javabrain.moviecatelogservice.Models.CatalogItem;
import io.javabrain.moviecatelogservice.Models.Movie;
import io.javabrain.moviecatelogservice.Models.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String id) {
        //for each movie ID, call movie info service and get details;
        // then, put them together

        RestTemplate restTemplate = new RestTemplate();


        List<MovieRating> ratings = Arrays.asList(
                new MovieRating("4", "124"),
                new MovieRating("3", "223")

        );
        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movie/"
                    + rating.getMovieId(), Movie.class);

            return new CatalogItem(movie.getName(), "test", rating.getRating());
        })
                .collect(Collectors.toList());

    }
}