package managementSystems.housingManagementSystem.application.repository.residential;

import managementSystems.housingManagementSystem.application.entity.residential.Blocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<Blocks, Long> {
}
