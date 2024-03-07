package managementSystems.housingManagementSystem.application.dto.management;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SelectManagementDTO {
    private Long id;
    private String informationManagementSelect;
    private String userRole;
}
