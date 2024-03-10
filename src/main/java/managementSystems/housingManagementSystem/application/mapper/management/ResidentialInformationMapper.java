package managementSystems.housingManagementSystem.application.mapper.management;

import managementSystems.housingManagementSystem.application.dto.management.AddManagementDTO;
import managementSystems.housingManagementSystem.application.dto.management.ManagementSelectResponseDTO;
import managementSystems.housingManagementSystem.application.entity.management.ResidentialInformation;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ResidentialInformationMapper {
    @Mapping(source = "apartmentName" ,target="informationManagementSelect")
    ManagementSelectResponseDTO toDto(ResidentialInformation entity);



    default ManagementSelectResponseDTO toDto(ResidentialInformation entity, @Context String fixedValue) {
        ManagementSelectResponseDTO dto = toDto(entity);
        dto.setInformationManagementSelect(dto.getInformationManagementSelect()+"-"+fixedValue);
        dto.setUserRole(fixedValue);
        return dto;
    }
    ResidentialInformation toEntity(AddManagementDTO entity);



}
