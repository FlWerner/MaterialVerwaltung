package de.dlrg.materialBackend.Repository;

import de.dlrg.materialBackend.Entity.Kiste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KisteRepository extends JpaRepository<Kiste, Long> {
}
