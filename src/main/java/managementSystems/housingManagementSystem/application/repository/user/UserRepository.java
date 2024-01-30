package managementSystems.housingManagementSystem.application.repository.user;

import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Long> {

}
