package managementSystems.housingManagementSystem.application.entity.management;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCity;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCountry;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceHousingTypes;

@Entity
@Table(name = "residential_info")
@Getter
@Setter
@NoArgsConstructor
public class ResidentialInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_housing_types_id", referencedColumnName = "id")
    private ReferenceHousingTypes referenceHousingTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_city_id", referencedColumnName = "id")
    private ReferenceCity referenceCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_country_id", referencedColumnName = "id")
    private ReferenceCountry referenceCountry;

    @Column(name = "address")
    private String address;

    @Column(name = "apartment_name")
    private String apartmentName;

    @Column(name = "number_of_flats")
    private String numberOfFlats;

}
