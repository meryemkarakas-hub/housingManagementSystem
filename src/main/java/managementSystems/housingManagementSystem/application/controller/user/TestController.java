package managementSystems.housingManagementSystem.application.controller.user;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;
import managementSystems.housingManagementSystem.application.repository.user.UserRegistrationRepository;
import managementSystems.housingManagementSystem.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/test", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    private final UserRegistrationRepository userRegistrationRepository;

    @GetMapping("/test")
    ResponseEntity<UserRegistration> signUp() {
        Optional<UserRegistration> userRegistration=userRegistrationRepository.findByIdentityNumber("49546385486");
        return new ResponseEntity<>(userRegistration.get(), HttpStatus.OK);
    }

}
