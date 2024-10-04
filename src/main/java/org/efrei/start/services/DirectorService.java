package org.efrei.start.services;

import java.util.List;

import org.efrei.start.dto.CreateDirector;
import org.efrei.start.models.Director;
import org.efrei.start.models.Movie;
import org.efrei.start.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class DirectorService {

    private final DirectorRepository repository;
    private final MovieService movieService;

    @Autowired
    public DirectorService(DirectorRepository repository, MovieService movieService) {
        this.repository = repository;
        this.movieService = movieService;
    }

    @GetMapping
    public List<Director> findAll() {
        return repository.findAll();    
    }

    public Director findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void create(CreateDirector createDirector) {
        Director director = new Director();
        director.setFullname(createDirector.getFullname());   
        for (String movieId : createDirector.getMovieId()) {
            Movie movie = movieService.findById(movieId);
            
            if (movie != null) {
                director.getMovies().add(movie);
            } else {
                System.out.println("doesn't exist");
            }
        }
        repository.save(director);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Director director) {
        Director updatedDirector = findById(id);
        updatedDirector.setFullname(director.getFullname());
        repository.save(updatedDirector);
    }
}
