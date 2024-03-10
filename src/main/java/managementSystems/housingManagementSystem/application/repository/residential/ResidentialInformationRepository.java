package managementSystems.housingManagementSystem.application.repository.residential;

import managementSystems.housingManagementSystem.application.entity.management.ResidentialInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentialInformationRepository extends JpaRepository<ResidentialInformation, Long> {
}
