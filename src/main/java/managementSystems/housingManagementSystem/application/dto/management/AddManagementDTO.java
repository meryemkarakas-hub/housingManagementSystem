package managementSystems.housingManagementSystem.application.dto.management;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddManagementDTO {
    private Long housingTypes;
    private Long city;
    private Long country;
    private String address;
    private String apartmentName;
    private Integer numberOfFlats;
    private String siteApartmentName;
    private String siteSingleHouseName;
    private Integer numberOfSingleHouse;
    private Integer blockCount;
    private List<BlocksDTO> blocks;
}
