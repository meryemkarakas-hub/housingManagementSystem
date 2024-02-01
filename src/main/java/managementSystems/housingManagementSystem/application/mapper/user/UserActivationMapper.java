package managementSystems.housingManagementSystem.application.mapper.user;

import managementSystems.housingManagementSystem.application.dto.user.ActivationDTO;
import managementSystems.housingManagementSystem.application.entity.user.UserActivation;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserActivationMapper {
    UserActivation toEntity(ActivationDTO dto);
}


