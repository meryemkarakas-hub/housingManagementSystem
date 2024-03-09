package managementSystems.housingManagementSystem.application.repository.reference;

import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCity;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReferenceCountryRepository extends JpaRepository<ReferenceCountry, Long> {
    @Query("select u from ReferenceCountry u order by u.country asc")
    List<ReferenceCountry> getAllCountryList();
}
