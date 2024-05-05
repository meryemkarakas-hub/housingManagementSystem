package managementSystems.housingManagementSystem.application.mapper.management;

import managementSystems.housingManagementSystem.application.dto.management.AddManagementDTO;
import managementSystems.housingManagementSystem.application.dto.management.ManagementSelectResponseDTO;
import managementSystems.housingManagementSystem.application.entity.management.ResidentialInformation;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ResidentialInformationMapper {
    @Mapping(target = "informationManagementSelect", expression = "java(entity.getApartmentName() != null ? entity.getApartmentName() : (entity.getSiteApartmentName() != null ? entity.getSiteApartmentName() : entity.getSiteSingleHouseName()))")
    ManagementSelectResponseDTO toDto(ResidentialInformation entity);



    default ManagementSelectResponseDTO toDto(ResidentialInformation entity, @Context String fixedValue) {
        ManagementSelectResponseDTO dto = toDto(entity);
        String informationType = "";

        if (entity.getApartmentName() != null) {
            informationType = "Apartman";
        } else if (entity.getSiteApartmentName() != null) {
            informationType = "Site(Apartman)";
        } else if (entity.getSiteSingleHouseName() != null) {
            informationType = "Site(Müstakil)";
        }

        dto.setInformationManagementSelect(dto.getInformationManagementSelect() + "-" + informationType + "-" + fixedValue);
        dto.setUserRole(fixedValue);

        return dto;
    }

    @Mappings({
            @Mapping(source = "housingTypes" ,target="referenceHousingTypes.id"),
            @Mapping(source = "city" ,target="referenceCity.id"),
            @Mapping(source = "country" ,target="referenceCountry.id"),
    })
    ResidentialInformation toEntity(AddManagementDTO entity);



}
