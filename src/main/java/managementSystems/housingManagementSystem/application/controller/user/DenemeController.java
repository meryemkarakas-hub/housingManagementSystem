package managementSystems.housingManagementSystem.application.controller.user;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/deneme", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DenemeController {

    private final UserService userService;

    @GetMapping("/test")
    ResponseEntity<String> signUp() {
        return new ResponseEntity<>("İşlem başarılı!", HttpStatus.OK);
    }

}
