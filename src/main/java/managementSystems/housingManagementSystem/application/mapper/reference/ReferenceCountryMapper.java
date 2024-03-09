package managementSystems.housingManagementSystem.application.mapper.reference;

import managementSystems.housingManagementSystem.application.dto.reference.ReferenceCountryDTO;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCountry;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReferenceCountryMapper {
    ReferenceCountryDTO toDto(ReferenceCountry entity);

}
