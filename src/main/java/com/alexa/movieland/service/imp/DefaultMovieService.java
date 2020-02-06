package com.alexa.movieland.service.imp;

import com.alexa.movieland.dao.MovieDao;
import com.alexa.movieland.dao.jdbc.JdbcMovieDao;
import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultMovieService implements MovieService {
    private MovieDao movieDao;
    private int randomCount = 3;

    @Autowired
    public DefaultMovieService(JdbcMovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public List<Movie> getRandom() {
        return movieDao.getRandom(randomCount);
    }
}
