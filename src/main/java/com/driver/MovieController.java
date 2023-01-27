package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

        @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie( @RequestBody Movie movie)
        {
            movieService.addMovie(movie);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
        {
            movieService.addDirector(director);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        @PutMapping("add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director )
        {
            movieService.addMovieDirectorPair(movie,director);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        @GetMapping("get-movie-by-name/{name}")
        public ResponseEntity<String> getMovieByName(@PathVariable String name)
        {
            Movie movie=movieService.getMovieByName(name);
            return new ResponseEntity<>("success",HttpStatus.CREATED);

        }
        @GetMapping("get-director-by-name/{name}")
        public ResponseEntity<String> getDirectorByName(@PathVariable  String name)
        {
            Director director=movieService.getDirectorByName(name);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        @GetMapping("get-movies-by-director-name/{director}")
        public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name)
        {
            List<String>movies=new ArrayList<>();
            movies=movieService.getMoviesByDirectorName(name);
            return new ResponseEntity<>(movies,HttpStatus.CREATED);
        }
        @GetMapping("get-all-movies")
        public ResponseEntity<List<String>> findAllMovies()
        {
            List<String>movies=movieService.findAllMovies();
            return new ResponseEntity<>(movies,HttpStatus.CREATED);
        }
        @DeleteMapping("delete-director-by-name")
        public ResponseEntity deleteDirectorByName(@RequestParam String DirectorName)
        {
            movieService.deleteDirectorByName(DirectorName);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        @DeleteMapping("delete-all-directors")
        public ResponseEntity deleteAllDirectors()
        {
            movieService.deleteAllDirectors();
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }

}
