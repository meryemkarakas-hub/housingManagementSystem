package managementSystems.housingManagementSystem.application.entity.management;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCity;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceCountry;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceHousingTypes;
import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;
import managementSystems.housingManagementSystem.application.entity.user.UserRoles;

import java.util.List;

@Entity
@Table(name = "add_management")
@Getter
@Setter
@NoArgsConstructor
public class AddManagement {
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_registration_add_management",
            joinColumns = @JoinColumn(name = "add_management_id"),
            inverseJoinColumns = @JoinColumn(name = "user_registration_id"))
    private List<UserRegistration> userRegistrationList;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_registration_add_management",
//            joinColumns = @JoinColumn(name = "add_management_id"),
//            inverseJoinColumns = @JoinColumn(name = "users_rol_id"))
//    @OneToMany(mappedBy = "addManagement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<UserRoles> userRolesList;
}
