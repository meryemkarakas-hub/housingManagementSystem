package managementSystems.housingManagementSystem.application.controller.management.housingManagement;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.dto.management.housingManagement.HousingInformationBlocksDTO;
import managementSystems.housingManagementSystem.application.service.management.housingManagement.HousingManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/housing-management", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class HousingManagementController {
    private final HousingManagementService housingManagementService;

    @GetMapping("/block-names")
    public ResponseEntity<List<HousingInformationBlocksDTO>> getAllBlockNameList() {
        List<HousingInformationBlocksDTO> housingInformationBlocksDTOList = housingManagementService.getAllBlockNameList();
        return new ResponseEntity<>(housingInformationBlocksDTOList, HttpStatus.OK);
    }

    @PostMapping("/add-housing-information")
    public List<Map<String, String>> uploadExcelFile(@RequestParam("blockName") String blockName,@RequestParam("file") MultipartFile file) {
        return housingManagementService.parseExcelFile(blockName,file);
    }
}
