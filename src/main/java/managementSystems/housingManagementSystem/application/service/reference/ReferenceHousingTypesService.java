package managementSystems.housingManagementSystem.application.service.reference;

import managementSystems.housingManagementSystem.application.dto.reference.ReferenceHousingTypesDTO;

import java.util.List;

public interface ReferenceHousingTypesService {
    List<ReferenceHousingTypesDTO> getAllHousingTypesList();
}