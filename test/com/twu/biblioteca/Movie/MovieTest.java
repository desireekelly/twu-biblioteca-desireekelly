package com.twu.biblioteca.Movie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Movie class.
 *
 * @author Desiree Kelly
 * @version 2.0
 * @see Movie
 */
public class MovieTest {

    public static final Movie MOVIE_1 = new Movie("The Matrix", 1999, "The Wachowski Brothers", "10");
    public static final Movie MOVIE_2 = new Movie("Inception", 2010, "Christopher Nolan", "8");

    @Test
    public void testGetName() throws Exception {
        assertEquals(MOVIE_1.getName(), "The Matrix");
    }

    @Test
    public void testGetYear() throws Exception {
        assertEquals(MOVIE_1.getYear(), 1999);
    }

    @Test
    public void testGetDirector() throws Exception {
        assertEquals(MOVIE_1.getDirector(), "The Wachowski Brothers");
    }

    @Test
    public void testGetMovieRating() throws Exception {
        assertEquals(MOVIE_1.getMovieRating(), "10");
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(MOVIE_1.toString(), "The Matrix, 1999, The Wachowski Brothers, 10");
    }

    @Test
    public void testIfTwoMoviesAreTheSame() throws Exception {
        assertFalse(MOVIE_1.equals("The Matrix, 1999, The Wachowski Brothers, 10"));
        assertTrue(MOVIE_1.equals(MOVIE_1));
        assertFalse(MOVIE_1.equals(MOVIE_2));
    }
}