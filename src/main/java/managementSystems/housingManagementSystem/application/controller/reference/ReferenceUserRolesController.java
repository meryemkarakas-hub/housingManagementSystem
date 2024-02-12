package managementSystems.housingManagementSystem.application.controller.reference;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceUserRolesDTO;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceUserRolesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reference", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ReferenceUserRolesController {

    private final ReferenceUserRolesService referenceUserRolesService;

    @GetMapping(value = "/user-roles")
    public ResponseEntity<List<ReferenceUserRolesDTO>> getAllCitiesList() {
        List<ReferenceUserRolesDTO> referenceUserRolesDTOList = referenceUserRolesService.getAllUserRolesList();
        return new ResponseEntity<>(referenceUserRolesDTOList, HttpStatus.OK);
    }
}
