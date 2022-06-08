package de.dlrg.materialBackend.Repository;

import de.dlrg.materialBackend.Entity.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {

    Optional<Benutzer> findBenutzerByUsername(String username);
}
