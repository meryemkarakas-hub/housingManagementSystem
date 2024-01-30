package managementSystems.housingManagementSystem.application.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GeneralMessageDTO {
    private int status;
    private String message;
}
