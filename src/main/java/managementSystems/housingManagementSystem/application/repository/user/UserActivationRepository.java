package managementSystems.housingManagementSystem.application.repository.user;

import managementSystems.housingManagementSystem.application.entity.user.UserActivation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserActivationRepository extends JpaRepository<UserActivation, Long> {
    Optional<UserActivation> findByActivationCode(String activationCode);
}


