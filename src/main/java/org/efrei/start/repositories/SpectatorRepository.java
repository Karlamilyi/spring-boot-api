package org.efrei.start.repositories;

import org.efrei.start.models.Spectator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpectatorRepository extends JpaRepository<Spectator, String> {

}
