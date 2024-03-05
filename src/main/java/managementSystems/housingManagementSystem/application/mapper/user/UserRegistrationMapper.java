package managementSystems.housingManagementSystem.application.mapper.user;

import managementSystems.housingManagementSystem.application.dto.user.SignUpDTO;
import managementSystems.housingManagementSystem.application.dto.user.UserRegistrationDTO;
import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserRegistrationMapper {
    UserRegistration toEntity(SignUpDTO dto);
    UserRegistrationDTO toDto(UserRegistration entity);
}
