package com.alexa.movieland.service;

import com.alexa.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    List<Movie> getRandom();
}
