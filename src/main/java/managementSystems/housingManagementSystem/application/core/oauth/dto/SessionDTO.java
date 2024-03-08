package managementSystems.housingManagementSystem.application.core.oauth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {
    private String identityNumber;
    private Long residentialInfoId;
    private String userRole;

}
