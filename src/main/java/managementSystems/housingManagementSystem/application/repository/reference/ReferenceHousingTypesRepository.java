package managementSystems.housingManagementSystem.application.repository.reference;

import managementSystems.housingManagementSystem.application.entity.reference.ReferenceHousingTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceHousingTypesRepository extends JpaRepository<ReferenceHousingTypes, Long> {
    @Query("select u from ReferenceHousingTypes u order by u.housingTypes asc")
    List<ReferenceHousingTypes> getAllHousingTypesList();
}
