package managementSystems.housingManagementSystem.application.mapper.reference;

import managementSystems.housingManagementSystem.application.dto.reference.ReferenceHousingTypesDTO;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceHousingTypes;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReferenceHousingTypesMapper {
    ReferenceHousingTypesDTO toDto(ReferenceHousingTypes entity);

}
