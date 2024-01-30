package managementSystems.housingManagementSystem.application.service;

import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.dto.user.SignUpDTO;

public interface UserService {
    GeneralMessageDTO signUp(SignUpDTO signUpDTO);
}
