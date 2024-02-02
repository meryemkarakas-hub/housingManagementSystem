package managementSystems.housingManagementSystem.application.service.user.impl;

import lombok.RequiredArgsConstructor;
import managementSystems.housingManagementSystem.application.core.dto.GeneralMessageDTO;
import managementSystems.housingManagementSystem.application.core.helper.ActivationCodeHelper;
import managementSystems.housingManagementSystem.application.core.service.MailSenderService;
import managementSystems.housingManagementSystem.application.core.validator.Validator;
import managementSystems.housingManagementSystem.application.dto.user.ActivationDTO;
import managementSystems.housingManagementSystem.application.dto.user.LoginDTO;
import managementSystems.housingManagementSystem.application.dto.user.SignUpDTO;
import managementSystems.housingManagementSystem.application.entity.user.UserActivation;
import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;
import managementSystems.housingManagementSystem.application.mapper.user.UserActivationMapper;
import managementSystems.housingManagementSystem.application.mapper.user.UserMapper;
import managementSystems.housingManagementSystem.application.repository.user.UserActivationRepository;
import managementSystems.housingManagementSystem.application.repository.user.UserRepository;
import managementSystems.housingManagementSystem.application.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private final PasswordEncoder passwordEncoder;


    @Override
    public GeneralMessageDTO signUp(SignUpDTO signUpDTO) {
        Validator validator = new Validator();
        validateLoginDTO(validator, signUpDTO);
        if (!validator.isValid()) {
            return new GeneralMessageDTO(0, validator.getErrorMessage());
        }
        return checkIfUserExists(signUpDTO);
    }

    private void validateLoginDTO(Validator validator, SignUpDTO signUpDTO) {
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

    public GeneralMessageDTO activation(ActivationDTO activationDTO) {
        Validator validator = new Validator();
        validateActivationDTO(validator, activationDTO);
        if (!validator.isValid()) {
            return new GeneralMessageDTO(0, validator.getErrorMessage());
        }
        Optional<UserActivation> userActivationOptional = userActivationRepository.findByActivationCode(activationDTO.getActivationCode());

        if (userActivationOptional.isEmpty()) {
            return new GeneralMessageDTO(0, "Geçersiz aktivasyon kodu.");
        }

        UserActivation userActivation = userActivationOptional.get();

        if (userActivation.getActivationStatus()) {
            return new GeneralMessageDTO(0, "Aktivasyon işlemini daha önce gerçekleştirdiğiniz için tekrar aktivasyon işlemi gerçekleştiremezsiniz..");
        }

        Optional<UserRegistration> userRegistrationOptional = userRepository.findByIdentityNumber(activationDTO.getIdentityNumber());

        if (userRegistrationOptional.isEmpty()) {
            return new GeneralMessageDTO(0, "Geçersiz TC kimlik numarası. Lütfen kaydolurken girmiş olduğunuz TC kimlik numarası ile aktivasyon işlemini gerçekleştiriniz.");
        }

        if (!activationDTO.getPassword().equals(activationDTO.getRePassword())) {
            return new GeneralMessageDTO(0, "Lütfen Şifre ve Şifre Tekrar alanlarına aynı şifre bilgilerini giriniz.");
        }

        String hashedPassword = passwordEncoder.encode(activationDTO.getPassword());
        userActivation.setPassword(hashedPassword);
        userActivation.setActivationStatus(true);
        userActivation.setRegistrationTime(LocalDateTime.now());
        userActivationRepository.save(userActivation);

        return new GeneralMessageDTO(1, "Aktivasyon işleminiz başarıyla gerçekleşmiştir. Sistemimize giriş yapabilirsiniz.");
    }

    private void validateActivationDTO(Validator validator, ActivationDTO activationDTO) {
        validator.validateNotNullOrEmpty(activationDTO.getIdentityNumber(), "TC Kimlik Numarası");
        validator.validateNotNullOrEmpty(activationDTO.getPassword(), "Şifre");
        validator.validateNotNullOrEmpty(activationDTO.getRePassword(), "Şifre Tekrar");
        validator.validateNotNullOrEmpty(activationDTO.getActivationCode(), "Aktivasyon Kodu");
    }

    @Override
    public GeneralMessageDTO login(LoginDTO loginDTO) {
        Optional<UserRegistration> userRegistrationFindByIdentityNumberOptional = userRepository.findByIdentityNumber(loginDTO.getIdentityNumber());
        if (userRegistrationFindByIdentityNumberOptional.isPresent()) {
            if (userRegistrationFindByIdentityNumberOptional.get().getUserActivation().getActivationStatus()) {
                if (isPasswordCorrect(loginDTO.getPassword(), userRegistrationFindByIdentityNumberOptional.get().getUserActivation().getPassword())) {
                    userRegistrationFindByIdentityNumberOptional.get().getUserActivation().setLastLoginTime(LocalDateTime.now());
                    userRepository.save(userRegistrationFindByIdentityNumberOptional.get());
                    return new GeneralMessageDTO(1, "İşleminiz başarıyla gerçekleşmiştir. Sistemimize yönlendiriliyorsunuz.");
                }
                return new GeneralMessageDTO(0, "Lütfen kayıt olurken oluşturmuş olduğunuz şifre ile giriş yapınız");
            }
            return new GeneralMessageDTO(0, "Lütfen aktivasyon işlemini tamamladıktan sonra giriş yapınız.");
        }
        return new GeneralMessageDTO(0, "Giriş yapmak istediğiniz TC kimlik numarası ile daha önce kayıt işlemi gerçekleşmemiştir.");
    }


    private boolean isPasswordCorrect(String enteredPassword, String hashedPasswordFromDB) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, hashedPasswordFromDB);
    }


}



