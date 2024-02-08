package managementSystems.housingManagementSystem.application.controller.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.dto.user.ActivationDTO;
import managementSystems.housingManagementSystem.application.dto.user.LoginDTO;
import managementSystems.housingManagementSystem.application.dto.user.ResetPasswordDTO;
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
    ResponseEntity<GeneralMessageDTO> signUp(@Valid @RequestBody SignUpDTO signUpDTO) {
        return new ResponseEntity<>(userService.signUp(signUpDTO), HttpStatus.OK);
    }

    @PostMapping("/activation")
    ResponseEntity<GeneralMessageDTO> activation(@Valid @RequestBody ActivationDTO activationDTO) {
        return new ResponseEntity<>(userService.activation(activationDTO), HttpStatus.OK);
    }

    @PostMapping("/login")
    ResponseEntity<GeneralMessageDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(userService.login(loginDTO), HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    ResponseEntity<GeneralMessageDTO> resetPassword(@Valid @RequestBody ResetPasswordDTO resetPasswordDTO) {
        return new ResponseEntity<>(userService.resetPassword(resetPasswordDTO), HttpStatus.OK);
    }
}
