package managementSystems.housingManagementSystem.application.controller.reference;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceHousingTypesDTO;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceHousingTypesService;
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
public class ReferenceHousingTypesController {

    private final ReferenceHousingTypesService referenceHousingTypesService;
    @GetMapping(value = "/housing-types")
    public ResponseEntity<List<ReferenceHousingTypesDTO>> getAllHousingTypesList() {
        List<ReferenceHousingTypesDTO> referenceHousingTypesDTOList = referenceHousingTypesService.getAllHousingTypesList();
        return new ResponseEntity<>(referenceHousingTypesDTOList, HttpStatus.OK);
    }
}
