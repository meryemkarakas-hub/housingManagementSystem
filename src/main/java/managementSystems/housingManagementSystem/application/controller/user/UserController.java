package managementSystems.housingManagementSystem.application.controller.user;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.dto.management.AddManagementDTO;
import managementSystems.housingManagementSystem.application.dto.management.SelectManagementDTO;
import managementSystems.housingManagementSystem.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private final UserService userService;

    private final HttpServletRequest request;


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

    @PostMapping("/management-select")
    ResponseEntity<GeneralMessageDTO> selectManagement(@Valid @RequestBody SelectManagementDTO selectManagementDTO) {
        return new ResponseEntity<>(userService.selectManagement(selectManagementDTO), HttpStatus.OK);
    }

    @PostMapping("/management-add")
    ResponseEntity<GeneralMessageDTO> selectManagement(@Valid @RequestBody AddManagementDTO addManagementDTO) {
        return null;
    }



}

