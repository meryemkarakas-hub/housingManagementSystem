package managementSystems.housingManagementSystem.application.repository.management;

import managementSystems.housingManagementSystem.application.entity.residential.HousingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingInformationRepository extends JpaRepository<HousingInformation, Long> {
}
