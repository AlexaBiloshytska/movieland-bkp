package com.alexa.movieland.dao.jdbc;

import com.alexa.movieland.dao.MovieDao;
import com.alexa.movieland.entity.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-application-context.xml")
public class JdbcMovieDaoTest {

    @Autowired
    private MovieDao movieDao;

    @Test
    public void getRandom() {

        List<Movie> randomMovies= movieDao.getRandom(3);
        Assert.assertEquals(3,randomMovies.size());
    }
}