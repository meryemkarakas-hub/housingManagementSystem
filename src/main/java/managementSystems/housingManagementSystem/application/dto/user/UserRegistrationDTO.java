package managementSystems.housingManagementSystem.application.dto.user;

import lombok.Getter;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.dto.management.ManagerDTO;
import managementSystems.housingManagementSystem.application.dto.management.ResidentDTO;
import managementSystems.housingManagementSystem.application.dto.residental.ResidentialTypesDTO;
import managementSystems.housingManagementSystem.application.entity.residential.ResidentialType;

import java.util.List;

@Getter
@Setter
public class UserRegistrationDTO extends SignUpDTO {
    private List<ResidentialTypesDTO> residentialTypes;
    private List<ManagerDTO> managerList;
    private ResidentDTO resident;
}
