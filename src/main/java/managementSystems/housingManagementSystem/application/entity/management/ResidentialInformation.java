package managementSystems.housingManagementSystem.application.entity.management;


import jakarta.persistence.*;
import lombok.*;
import managementSystems.housingManagementSystem.application.dto.management.ManagerDTO;
import managementSystems.housingManagementSystem.application.dto.management.ResidentDTO;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCity;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCountry;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceHousingTypes;

import java.util.List;

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

    @Column(name = "site_apartment_name")
    private String siteApartmentName;

    @Column(name = "site_single_house_name")
    private String siteSingleHouseName;

    @Column(name = "number_of_flats")
    private Integer numberOfFlats;

    @Column(name = "number_of_blocks")
    private Integer blockCount;

    @Column(name = "number_of_single_house")
    private Integer numberOfSingleHouse;

    @OneToOne(mappedBy = "residentialInformation", cascade = CascadeType.ALL)
    private Manager manager;

    @OneToMany(mappedBy = "residentialInformation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Resident> residentList;
}
