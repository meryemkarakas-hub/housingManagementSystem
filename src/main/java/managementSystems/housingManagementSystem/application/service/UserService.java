package managementSystems.housingManagementSystem.application.service;

import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.dto.management.ManagementSelectResponseDTO;
import managementSystems.housingManagementSystem.application.dto.residental.ResidentialTypesDTO;
import managementSystems.housingManagementSystem.application.dto.user.ActivationDTO;
import managementSystems.housingManagementSystem.application.dto.user.LoginDTO;
import managementSystems.housingManagementSystem.application.dto.user.ResetPasswordDTO;
import managementSystems.housingManagementSystem.application.dto.user.SignUpDTO;

import java.util.List;

public interface UserService {
    GeneralMessageDTO signUp(SignUpDTO signUpDTO);

    GeneralMessageDTO activation(ActivationDTO activationDTO);

    GeneralMessageDTO login(LoginDTO loginDTO);

    GeneralMessageDTO resetPassword(ResetPasswordDTO resetPasswordDTO);

    List<ResidentialTypesDTO> getResidentialType();

    List<ManagementSelectResponseDTO> getInformationManagementSelect();

}
