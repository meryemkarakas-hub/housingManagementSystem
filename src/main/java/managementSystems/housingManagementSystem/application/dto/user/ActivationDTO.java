package managementSystems.housingManagementSystem.application.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivationDTO {
    private String identityNumber;
    private String password;
    private String rePassword;
    private String activationCode;
}
