package managementSystems.housingManagementSystem.application.controller.user;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private final UserService userService;

    @GetMapping
    ResponseEntity<String> getActiveUserInfomation() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(authentication.getName(), HttpStatus.OK);
    }

    @GetMapping("/residential-types")
    ResponseEntity<?> getResidentialType() {
        return new ResponseEntity<>(userService.getResidentialType(), HttpStatus.OK);
    }

    @GetMapping("/information/management-select")
    ResponseEntity<?> getInformationManagementSelect() {
        return new ResponseEntity<>(userService.getInformationManagementSelect(), HttpStatus.OK);
    }
}
