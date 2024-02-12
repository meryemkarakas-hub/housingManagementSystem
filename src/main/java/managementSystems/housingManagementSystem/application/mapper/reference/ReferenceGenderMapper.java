package managementSystems.housingManagementSystem.application.mapper.reference;

import managementSystems.housingManagementSystem.application.dto.reference.ReferenceGenderDTO;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceGender;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReferenceGenderMapper {
    ReferenceGenderDTO toDto(ReferenceGender entity);
}
