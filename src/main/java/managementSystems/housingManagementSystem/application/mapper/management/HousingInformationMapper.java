package managementSystems.housingManagementSystem.application.mapper.management;

import managementSystems.housingManagementSystem.application.dto.management.housingManagement.HousingInformationBlocksDTO;
import managementSystems.housingManagementSystem.application.entity.residential.HousingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HousingInformationMapper {
    HousingInformationBlocksDTO toDto(HousingInformation entity);

}
