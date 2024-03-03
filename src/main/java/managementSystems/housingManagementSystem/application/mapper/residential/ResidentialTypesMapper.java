package managementSystems.housingManagementSystem.application.mapper.residential;

import managementSystems.housingManagementSystem.application.dto.residental.ResidentialTypesDTO;
import managementSystems.housingManagementSystem.application.entity.residential.ResidentialType;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ResidentialTypesMapper {
    List<ResidentialTypesDTO> toDto(List<ResidentialType> entity);

}

