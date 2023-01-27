package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    @Autowired
MovieRepository movieRepository;

    public void addMovie(Movie movie)
    {
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director)
    {
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String movie,String director)
    {
        movieRepository.addMovieDirectorPair(movie,director);
    }
    public Movie  getMovieByName(String name)
    {
        Movie movie=movieRepository.getMovieByName(name);
        return movie;
    }
    public Director getDirectorByName(String name)
    {
        Director director=movieRepository.getDirectorByName(name);
        return director;
    }
    public List<String> getMoviesByDirectorName(String name)
    {
        List<String>movies=movieRepository.getMoviesByDirectorName(name);
        return movies;
    }
    public List<String>  findAllMovies()
    {
        List<String>movies=movieRepository.findAllMovies();
        return movies;
    }
    public void deleteDirector(String directorName)
    {
        movieRepository.deleteDirector(directorName);
    }
    public void  deleteAllDirectors()
    {
        movieRepository.deleteAllDirectors();
    }
}
