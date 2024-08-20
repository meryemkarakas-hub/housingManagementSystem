package managementSystems.housingManagementSystem.application.service.management.housingManagement;

import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.dto.management.housingManagement.HousingInformationBlocksDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HousingManagementService {
    List<HousingInformationBlocksDTO> getAllBlockNameList();

    GeneralMessageDTO parseExcelFile(String blockName, MultipartFile file);
}
