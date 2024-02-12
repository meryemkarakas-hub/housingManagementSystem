package managementSystems.housingManagementSystem.application.controller.reference;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceGenderDTO;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceGenderService;
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
public class ReferenceGenderController {
    private final ReferenceGenderService referenceGenderService;

    @GetMapping(value = "/gender")
    public ResponseEntity<List<ReferenceGenderDTO>> getAllGenderList() {
        List<ReferenceGenderDTO> referenceGenderDTOList = referenceGenderService.getAllGenderList();
        return new ResponseEntity<>(referenceGenderDTOList, HttpStatus.OK);
    }
}
