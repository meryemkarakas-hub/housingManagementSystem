package managementSystems.housingManagementSystem.application.repository.reference;

import managementSystems.housingManagementSystem.application.entity.reference.ReferenceGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceGenderRepository extends JpaRepository<ReferenceGender, Long> {
    @Query("select u from ReferenceGender u order by u.gender asc")
    List<ReferenceGender> getAllGenderList();
}
