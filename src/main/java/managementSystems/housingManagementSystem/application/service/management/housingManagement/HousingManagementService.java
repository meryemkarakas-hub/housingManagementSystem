package managementSystems.housingManagementSystem.application.service.management.housingManagement;

import managementSystems.housingManagementSystem.application.dto.management.housingManagement.HousingInformationBlocksDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface HousingManagementService {
    List<HousingInformationBlocksDTO> getAllBlockNameList();

    List<Map<String, String>> parseExcelFile(MultipartFile file);
}
