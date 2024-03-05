package managementSystems.housingManagementSystem.application.dto.residental;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.dto.management.ManagerDTO;
import managementSystems.housingManagementSystem.application.dto.management.ResidentDTO;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCity;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCountry;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceHousingTypes;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResidentialInformationDTO {
    private Long id;

    private String address;
    private String apartmentName;
    private String numberOfFlats;

}
