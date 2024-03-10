package managementSystems.housingManagementSystem.application.dto.management;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddManagementDTO {
    private String housingTypes;
    private String city;
    private String country;
    private String address;
    private String apartmentName;
    private Integer numberOfFlats;
    private String siteApartmentName;
    private String siteSingleHouseName;
    private String numberOfSingleHouse;
    private String blockCount;
    private List<BlocksDTO> blocks;
}
