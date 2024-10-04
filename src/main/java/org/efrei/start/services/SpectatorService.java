package org.efrei.start.services;

import java.util.List;

import org.efrei.start.dto.CreateSpectator;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Spectator;
import org.efrei.start.repositories.SpectatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class SpectatorService {

    private final SpectatorRepository repository;
    private final MovieService movieService;


    @Autowired
    public SpectatorService(SpectatorRepository repository, MovieService movieService) {
        this.repository = repository;
        this.movieService = movieService;
    }

    @GetMapping
    public List<Spectator> findAll() {
        return repository.findAll();    
    }

    public Spectator findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void create(CreateSpectator createSpectator) {
        Spectator spectator = new Spectator();
        spectator.setName(createSpectator.getName());   
        for (String movieId : createSpectator.getMovieId()) {
            Movie movie = movieService.findById(movieId);
            
            if (movie != null) {
                spectator.getMovies().add(movie);
            } else {
                System.out.println("doesn't exist");
            }
        }
        repository.save(spectator);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Spectator spectator) {
        Spectator updatedSpectator = findById(id);
        updatedSpectator.setName(spectator.getName());
        repository.save(updatedSpectator);
    }
}
