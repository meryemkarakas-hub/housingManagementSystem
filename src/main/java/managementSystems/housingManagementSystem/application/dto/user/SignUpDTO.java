package managementSystems.housingManagementSystem.application.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SignUpDTO {
    private String identityNumber;
    private String name;
    private String surname;
    private String emailAddress;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private Boolean kvkk;
    private String userRole;
}
