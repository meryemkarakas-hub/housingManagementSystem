package managementSystems.housingManagementSystem.application.mapper.reference;

import managementSystems.housingManagementSystem.application.dto.reference.ReferenceUserRolesDTO;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceUserRoles;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ReferenceUserRolesMapper {
    ReferenceUserRolesDTO toDto(ReferenceUserRoles entity);
}
