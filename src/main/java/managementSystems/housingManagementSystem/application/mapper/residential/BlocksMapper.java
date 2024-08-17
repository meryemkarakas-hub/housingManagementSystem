package managementSystems.housingManagementSystem.application.mapper.residential;

import managementSystems.housingManagementSystem.application.dto.management.BlocksDTO;
import managementSystems.housingManagementSystem.application.dto.management.housingManagement.HousingInformationBlocksDTO;
import managementSystems.housingManagementSystem.application.entity.residential.Blocks;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BlocksMapper {
    Blocks toEntity(BlocksDTO dto);

    HousingInformationBlocksDTO toDto(Blocks entity);




}
