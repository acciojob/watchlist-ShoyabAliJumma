package com.driver;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
   private HashMap<String,Movie>movieDb=new HashMap<>();
   private HashMap<String,Director>directorDb=new HashMap<>();
   private HashMap<String, List<String>>movieDirectorDb=new HashMap<>();

    public MovieRepository() {
        this.movieDb=new HashMap<String,Movie>();
        this.directorDb=new HashMap<String,Director>();
        this.movieDirectorDb=new HashMap<String, List<String>>();
    }
//adding Movie
    public void addMovie(Movie movie)
    {
      String name=movie.getName();
      movieDb.put(name,movie);

    }
    public void addDirector(Director director)
    {
        String name=director.getName();
        directorDb.put(name,director);
    }
    public void addMovieDirectorPair(String directorName,String movieName)
    {
        if(movieDb.containsKey(movieName) && directorDb.containsKey(directorName))
        {
            List<String>currentMovie=new ArrayList<>();
          if(movieDirectorDb.containsKey(directorName))
          currentMovie=movieDirectorDb.get(movieName);
          currentMovie.add(movieName);
          movieDirectorDb.put(directorName,currentMovie);
        }
    }
    public Movie  getMovieByName(String name)
    {
        //if(!movieDb.containsKey(name))
        return movieDb.get(name);
    }
    public Director  getDirectorByName(String name)
    {
        return directorDb.get(name);
    }
    public List<String> getMoviesByDirectorName(String name)
    {
        List<String>moviesList=new ArrayList<>();
        if(movieDirectorDb.containsKey(name))
            moviesList=movieDirectorDb.get(name);
        return moviesList;
    }
    public List<String>  findAllMovies()
    {
        return new ArrayList<>(movieDb.keySet());
    }
    public void deleteDirectorByName(String directorName)
    {
        List<String>movies=new ArrayList<>();
        if(movieDirectorDb.containsKey(directorName))
        {
            movies=movieDirectorDb.get(directorName);
            for (String movie:movies)
            {
                if(movieDb.containsKey(movie))
                {
                    movieDb.remove(movie);
                }
            }
            movieDirectorDb.remove(directorName);
        }
        if(directorDb.containsKey(directorName))
            directorDb.remove(directorName);
    }
    public void  deleteAllDirectors()
    {
        HashSet<String>movieSet=new HashSet<>();
        for(String director:movieDirectorDb.keySet())
        {
            for (String movie:movieDirectorDb.get(director))
            {
                movieSet.add(movie);
            }
        }
        for(String movie:movieSet)
        {
            if(movieDb.containsKey(movie))
                movieDb.remove(movie);
        }
    }
}
