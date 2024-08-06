package managementSystems.housingManagementSystem.application.repository.user;

import managementSystems.housingManagementSystem.application.entity.user.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRolesRepository extends JpaRepository<UserRoles, Long> {
    Optional<UserRoles> findByUserRegistrationId(Long userRegistrationId);
}
