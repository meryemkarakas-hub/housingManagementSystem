package managementSystems.housingManagementSystem.application.controller.reference;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.reference.ReferenceCityDTO;
import managementSystems.housingManagementSystem.application.service.reference.ReferenceCityService;
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
public class ReferenceCityController {

    private final ReferenceCityService referenceCityService;

    @GetMapping(value = "/city")
    public ResponseEntity<List<ReferenceCityDTO>> getAllCityList() {
        List<ReferenceCityDTO> referenceCityDTOList = referenceCityService.getAllCityList();
        return new ResponseEntity<>(referenceCityDTOList, HttpStatus.OK);
    }
}
