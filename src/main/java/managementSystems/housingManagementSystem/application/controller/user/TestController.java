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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/test", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @GetMapping("/test")
    ResponseEntity<String> signUp() {
        return new ResponseEntity<>("İşlem başarılı!", HttpStatus.OK);
    }

}
