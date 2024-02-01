package managementSystems.housingManagementSystem.application.controller.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.user.ActivationDTO;
import managementSystems.housingManagementSystem.application.dto.user.SignUpDTO;
import managementSystems.housingManagementSystem.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    ResponseEntity<?> signUp(@Valid @RequestBody SignUpDTO signUpDTO) {
        return new ResponseEntity<>(userService.signUp(signUpDTO), HttpStatus.OK);
    }

    @PostMapping("/activation")
    ResponseEntity<?> activation(@Valid @RequestBody ActivationDTO activationDTO) {
        return new ResponseEntity<>(userService.activation(activationDTO), HttpStatus.OK);
    }


}
