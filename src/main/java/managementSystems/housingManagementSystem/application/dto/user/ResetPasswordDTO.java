package managementSystems.housingManagementSystem.application.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResetPasswordDTO {
    private String identityNumber;
    private String emailAddress;
}
