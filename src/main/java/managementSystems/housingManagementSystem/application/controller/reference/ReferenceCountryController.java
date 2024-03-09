package managementSystems.housingManagementSystem.application.controller.reference;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceCountryDTO;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceCountryService;
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
public class ReferenceCountryController {

    private ReferenceCountryService referenceCountryService;

    @GetMapping(value = "/country")
    public ResponseEntity<List<ReferenceCountryDTO>> getAllCountryList() {
        List<ReferenceCountryDTO> referenceCountryDTOList = referenceCountryService.getAllCountryList();
        return new ResponseEntity<>(referenceCountryDTOList, HttpStatus.OK);
    }
}
