package managementSystems.housingManagementSystem.application.core.oauth.service;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;
import managementSystems.housingManagementSystem.application.repository.user.UserRegistrationRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRegistrationRepository userRegistrationRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String identityNumber) throws UsernameNotFoundException {
        UserRegistration userRegistration = userRegistrationRepository.findByIdentityNumber(identityNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with identityNumber: " + identityNumber));

        return UserDetailsImpl.build(userRegistration);
    }

}
