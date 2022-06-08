package de.dlrg.materialBackend.Repository;

import de.dlrg.materialBackend.Entity.materialProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialProblemInterface extends JpaRepository<materialProblem, Long> {
}
