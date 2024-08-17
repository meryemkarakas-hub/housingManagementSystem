package managementSystems.housingManagementSystem.application.controller.management.housingManagement;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.management.housingManagement.HousingInformationBlocksDTO;
import managementSystems.housingManagementSystem.application.service.management.housingManagement.HousingManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class HousingManagementController {
    private final HousingManagementService housingManagementService;

    @GetMapping("/block-names")
    public ResponseEntity<List<HousingInformationBlocksDTO>> getAllBlockNameList() {
        List<HousingInformationBlocksDTO> housingInformationBlocksDTOList = housingManagementService.getAllBlockNameList();
        return new ResponseEntity<>(housingInformationBlocksDTOList, HttpStatus.OK);
    }
}
