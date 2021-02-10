package com.alexa.movieland.dao;

import com.alexa.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();
    List<Movie> getRandom(int randomCount);
    List<Movie> getMoviesByGenre(int genreId);
}
