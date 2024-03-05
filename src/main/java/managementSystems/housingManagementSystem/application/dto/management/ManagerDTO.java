package managementSystems.housingManagementSystem.application.dto.management;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.dto.residental.ResidentialInformationDTO;

@Getter
@Setter
@NoArgsConstructor
public class ManagerDTO {
    private Long id;
    private ResidentialInformationDTO residentialInformation;
}
