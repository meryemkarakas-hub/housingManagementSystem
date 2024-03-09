package managementSystems.housingManagementSystem.application.mapper.reference;

import managementSystems.housingManagementSystem.application.dto.reference.ReferenceCityDTO;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReferenceCityMapper {
    ReferenceCityDTO toDto(ReferenceCity entity);

}
