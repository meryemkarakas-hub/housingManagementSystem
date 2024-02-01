package managementSystems.housingManagementSystem.application.service.user.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.core.helper.ActivationCodeHelper;
import managementSystems.housingManagementSystem.application.core.service.MailSenderService;
import managementSystems.housingManagementSystem.application.core.validator.Validator;
import managementSystems.housingManagementSystem.application.dto.user.ActivationDTO;
import managementSystems.housingManagementSystem.application.dto.user.SignUpDTO;
import managementSystems.housingManagementSystem.application.entity.user.UserActivation;
import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;
import managementSystems.housingManagementSystem.application.mapper.user.UserActivationMapper;
import managementSystems.housingManagementSystem.application.mapper.user.UserMapper;
import managementSystems.housingManagementSystem.application.repository.user.UserActivationRepository;
import managementSystems.housingManagementSystem.application.repository.user.UserRepository;
import managementSystems.housingManagementSystem.application.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final MailSenderService mailSenderService;

    @Value("${origin.activation-url}")
    private String activationUrl;

    private static final String ICERIK = "Aktivasyon işleminizi gerçekleştirmek için lütfen linke tıklayınız. ";

    private final UserActivationRepository userActivationRepository;

    private final UserActivationMapper userActivationMapper;

    //private final PasswordEncoder passwordEncoder;


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
        return checkIfUserExists(signUpDTO);
    }

    private GeneralMessageDTO checkIfUserExists(SignUpDTO signUpDTO) {
        List<Supplier<Optional<UserRegistration>>> checks = Arrays.asList(
                () -> userRepository.findByIdentityNumber(signUpDTO.getIdentityNumber()),
                () -> userRepository.findByEmailAddress(signUpDTO.getEmailAddress()),
                () -> userRepository.findByMobileNumber(signUpDTO.getMobileNumber()),
                () -> userRepository.findByIdentityNumberAndEmailAddressAndMobileNumber(signUpDTO.getIdentityNumber(), signUpDTO.getEmailAddress(), signUpDTO.getMobileNumber()),
                () -> userRepository.findByIdentityNumberAndEmailAddress(signUpDTO.getIdentityNumber(), signUpDTO.getEmailAddress()),
                () -> userRepository.findByIdentityNumberAndMobileNumber(signUpDTO.getIdentityNumber(), signUpDTO.getMobileNumber()),
                () -> userRepository.findByEmailAddressAndMobileNumber(signUpDTO.getEmailAddress(), signUpDTO.getMobileNumber())
        );

        if (checks.stream().anyMatch(supplier -> supplier.get().isPresent())) {
            return new GeneralMessageDTO(0, "Kaydolmak istediğiniz bilgiler ile daha önce kayıt işlemi gerçekleşmiştir.Aynı TC kimlik numarası, e-posta adresi ve cep telefonu bilgisi ile kaydolamazsınız.");
        }
        UserRegistration userRegistration = userMapper.toEntity(signUpDTO);
        String activationCode = ActivationCodeHelper.generateActivationCode();
        String activationUrlContent = activationUrl + activationCode;
        //mailSenderService.sendMail(signUpDTO.getEmailAddress(), "Aktivasyon", ICERIK + activationUrlContent);
        UserActivation userActivation = new UserActivation();
        userActivation.setActivationCode(activationCode);
        userActivation.setActivationStatus(false);
        userRegistration.setUserActivation(userActivation);
        userActivation.setUserRegistration(userRegistration);
        userRepository.save(userRegistration);
        return new GeneralMessageDTO(1, "Belirtmiş olduğunuz e-posta adresine aktivasyon linki gönderilmiştir. Linke tıklayarak aktivasyon işlemini gerçekleştirip kayıt işlemini tamamlayınız.");
    }

    @Override
    public GeneralMessageDTO activation(ActivationDTO activationDTO) {
        Optional<UserRegistration> userRegistrationFindByIdentityNumberOptional = userRepository.findByIdentityNumber(activationDTO.getIdentityNumber());
        Optional<UserActivation> userActivationfindByActivationCodeOptional = userActivationRepository.findByActivationCode(activationDTO.getActivationCode());
        if (userRegistrationFindByIdentityNumberOptional.isPresent()) {
            if (userActivationfindByActivationCodeOptional.isPresent() && !userActivationfindByActivationCodeOptional.get().getActivationStatus()) {
                if (activationDTO.getPassword().equals(activationDTO.getRePassword())) {
                    UserActivation userActivation = userActivationfindByActivationCodeOptional.get(); // Retrieve the existing record
                    //String hashedPassword = passwordEncoder.encode(activationDTO.getPassword());
                    userActivation.setPassword(activationDTO.getPassword());
                    userActivation.setActivationStatus(true);
                    userActivation.setRegistrationTime(LocalDateTime.now());
                    userActivationRepository.save(userActivation);
                    return new GeneralMessageDTO(1, "Aktivasyon işleminiz başarıyla gerçekleşmiştir. Sistemimize giriş yapabilirsiniz.");
                }
                return new GeneralMessageDTO(0, "Lütfen Şifre ve Şifre Tekrar alanlarına aynı şifre bilgilerini giriniz.");
            }
            return new GeneralMessageDTO(0, "Aktivasyon işlemini daha önce gerçekleştirdiğiniz için tekrar aktivasyon işlemi gerçekleştiremezsiniz");

        }
        return new GeneralMessageDTO(0, "Lütfen kaydolurken girmiş olduğunuz TC kimlik numarası ile aktivasyon işlemini gerçekleştiriniz.");
    }
}


