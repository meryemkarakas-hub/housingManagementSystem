package managementSystems.housingManagementSystem.application.repository.reference;

import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReferenceCountryRepository extends JpaRepository<ReferenceCountry, Long> {
    @Query("SELECT rc FROM ReferenceCountry rc WHERE rc.referenceCity.id = :cityId")
    List<ReferenceCountry> findReferenceCountryByCityId(@Param("cityId") Long cityId);
}
