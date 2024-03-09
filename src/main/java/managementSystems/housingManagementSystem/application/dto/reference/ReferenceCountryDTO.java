package managementSystems.housingManagementSystem.application.dto.reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReferenceCountryDTO {
    private Long id;
    private Long cityId;
    private String country;
}
