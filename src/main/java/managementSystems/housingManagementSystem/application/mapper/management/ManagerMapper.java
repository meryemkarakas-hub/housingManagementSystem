package managementSystems.housingManagementSystem.application.mapper.management;

import managementSystems.housingManagementSystem.application.dto.management.ManagementSelectResponseDTO;
import managementSystems.housingManagementSystem.application.entity.management.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ManagerMapper {
    @Mappings({
            @Mapping(source = "residentialInformation.apartmentName" ,target="informationManagementSelect"),
            @Mapping(source = "residentialInformation.id" ,target="id")
    })
    ManagementSelectResponseDTO toDto(Manager entity);


}
