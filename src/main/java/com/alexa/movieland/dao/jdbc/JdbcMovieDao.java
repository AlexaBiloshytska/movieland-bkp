package com.alexa.movieland.dao.jdbc;

import com.alexa.movieland.dao.MovieDao;
import com.alexa.movieland.entity.Movie;
import com.alexa.movieland.dao.mapper.MovieMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class JdbcMovieDao  implements MovieDao {
    private static final String GET_ALL_MOVIES = "select * from movies";
    private static final String RANDOM = "select * from movies  order by random() limit ?";
    private static final MovieMapper MOVIE_MAPPER = new MovieMapper();
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getAll() {
        long startTime = System.currentTimeMillis();

        List<Movie> movies = jdbcTemplate.query(GET_ALL_MOVIES, MOVIE_MAPPER);
        long stopTime = System.currentTimeMillis();
        log.info("Getting all movies in {} ms: ",stopTime-startTime);
        return movies;

    }


    @Override
    public List<Movie> getRandom(int randomCount) {
        long startTime = System.currentTimeMillis();

        List<Movie> randomQuery = jdbcTemplate.query(RANDOM, MOVIE_MAPPER, randomCount);
        log.info("Getting 3 random movies in {} ms: ", System.currentTimeMillis()-startTime);
        return randomQuery;
    }
}
