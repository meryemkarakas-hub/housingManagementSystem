package managementSystems.housingManagementSystem.application.service.user.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.core.validator.Validator;
import managementSystems.housingManagementSystem.application.dto.user.SignUpDTO;
import managementSystems.housingManagementSystem.application.service.UserService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    @Override
    public GeneralMessageDTO signUp(SignUpDTO signUpDTO) {
        Validator validator = new Validator();
        validator.validateNotNullOrEmpty(signUpDTO.getUserRole(), "Kullanıcı Rolü");
        validator.validateNotNullOrEmpty(signUpDTO.getIdentityNumber(), "TC Kimlik Numarası");
        validator.validateNotNullOrEmpty(signUpDTO.getName(), "Ad");
        validator.validateNotNullOrEmpty(signUpDTO.getSurname(), "Soyad");
        validator.validateNotNullOrEmpty(signUpDTO.getEmailAddress(), "E-Posta Adresi");
        validator.validateNotNullOrEmpty(signUpDTO.getMobileNumber(), "Cep Telefonu");
        validator.validateNotNull(signUpDTO.getDateOfBirth(), "Doğum Tarihi");
        validator.validateDateOfBirthNotUnderAge(signUpDTO.getDateOfBirth(), 18, "Doğum Tarihi");
        validator.validateNotNullOrEmpty(signUpDTO.getGender(), "Cinsiyet");
        validator.validateNotNull(signUpDTO.getKvkk(), "KVKK Aydınlatma Metni'ni okudum.");

        if (!validator.isValid()) {
            return new GeneralMessageDTO(0, validator.getErrorMessage());
        }

        return new GeneralMessageDTO(1, "İşleminiz başarıyla gerçekleşmiştir.");
    }
}
