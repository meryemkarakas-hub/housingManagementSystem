package managementSystems.housingManagementSystem.application.repository.reference;

import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceCityRepository extends JpaRepository<ReferenceCity, Long> {
    @Query("select u from ReferenceCity u order by u.city asc")
    List<ReferenceCity> getAllCityList();
}
