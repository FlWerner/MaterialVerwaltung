package de.dlrg.materialBackend.Repository;

import de.dlrg.materialBackend.Entity.material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface materialRepository extends JpaRepository<material, Long> {
}
