package managementSystems.housingManagementSystem.application.repository.reference;

import managementSystems.housingManagementSystem.application.entity.reference.ReferenceUserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferenceUserRolesRepository extends JpaRepository<ReferenceUserRoles, Long> {
    @Query("select u from ReferenceUserRoles u order by u.userRoles asc")
    List<ReferenceUserRoles> getAllCitiesList();
}

