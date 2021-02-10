package com.alexa.movieland.web.controller;

import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.service.MovieService;
import com.alexa.movieland.web.dto.MovieLto;
import com.alexa.movieland.web.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private MovieService movieService;
    private MovieMapper movieMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieLto> getAll() {
        return movieMapper.map(movieService.getAll());
    }

    @GetMapping(value = "/random")
    public List<Movie> getRandom (){
        return movieService.getRandom();
    }

    @GetMapping(value = "/genre")
    public List<Movie> getMoviesByGenre(@RequestParam int genreId){
        return movieService.getMoviesByGenre(genreId);
    }
}
