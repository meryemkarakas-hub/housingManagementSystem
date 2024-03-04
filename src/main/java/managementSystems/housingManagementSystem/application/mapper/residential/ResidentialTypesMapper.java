package managementSystems.housingManagementSystem.application.mapper.residential;

import managementSystems.housingManagementSystem.application.dto.residental.ResidentialTypesDTO;
import managementSystems.housingManagementSystem.application.entity.residential.ResidentialType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ResidentialTypesMapper {
    @Mapping(source = "referenceHousingTypes.housingTypes" ,target="residentialType")
    List<ResidentialTypesDTO> toDtoList(List<ResidentialType> entityList);

    @Mapping(source = "referenceHousingTypes.housingTypes" ,target="residentialType")
    ResidentialTypesDTO toDto(ResidentialType entity);
}

