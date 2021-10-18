package controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.ResourceNotFoundException;
import model.Movie;
import repository.MovieRepository;


@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Movie movie) {
        return "add-movie";
    }

    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable(value="id") int movieId, Model model) throws ResourceNotFoundException{
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Invalid Movie id:" + movieId));
        model.addAttribute("movie", movie);
        return "update-movie";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable(value="id") int movieId, Model model) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie not found: " + movieId));
        movieRepository.delete(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "view";
    }

    @PostMapping("/add")
    public String addMovie(@Validated Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-movie";
        }
        movieRepository.save(movie);
        return "redirect:list";
    }

    @PostMapping("update/{id}")
    public String updateMovie(@PathVariable(value="id") int movieId, @Validated Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            movie.setMovieId(movieId);
            return "update-movie";
        }
        movieRepository.save(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "view";
    }

}