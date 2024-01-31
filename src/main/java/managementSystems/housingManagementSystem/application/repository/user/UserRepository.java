package managementSystems.housingManagementSystem.application.repository.user;

import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Long> {
    Optional<UserRegistration> findByIdentityNumber(String identityNumber);

    Optional<UserRegistration> findByEmailAddress(String emailAddress);

    Optional<UserRegistration> findByMobileNumber(String mobileNumber);

    Optional<UserRegistration> findByIdentityNumberAndEmailAddressAndMobileNumber(String identityNumber, String emailAddress, String mobileNumber);

    Optional<UserRegistration> findByIdentityNumberAndEmailAddress(String identityNumber, String emailAddress);

    Optional<UserRegistration> findByIdentityNumberAndMobileNumber(String identityNumber, String mobileNumber);

    Optional<UserRegistration> findByEmailAddressAndMobileNumber(String emailAddress, String mobileNumber);
}




