package managementSystems.housingManagementSystem.application.entity.reference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.management.ResidentialInformation;
import managementSystems.housingManagementSystem.application.entity.residential.ResidentialType;

import java.util.List;

@Entity
@Table(name = "reference_housing_types")
@Getter
@Setter
@NoArgsConstructor
public class ReferenceHousingTypes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "housing_types", unique = true)
    private String housingTypes;

    @OneToMany(mappedBy = "referenceHousingTypes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ResidentialType> residentialTypeList;

    @OneToMany(mappedBy = "referenceHousingTypes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ResidentialInformation> residentialInformationList;

}
