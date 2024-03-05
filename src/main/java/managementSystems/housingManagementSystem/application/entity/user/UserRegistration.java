package managementSystems.housingManagementSystem.application.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceGender;
import managementSystems.housingManagementSystem.application.entity.residential.ResidentialType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users_registration")
@Getter
@Setter
@NoArgsConstructor
public class UserRegistration {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "identity_number", unique = true)
    private String identityNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email_address", unique = true)
    private String emailAddress;

    @Column(name = "mobile_number", unique = true)
    private String mobileNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref erence_gender_id", referencedColumnName = "id")
    private ReferenceGender referenceGender;

    @Column(name = "kvkk")
    private Boolean kvkk;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "userRegistration", cascade = CascadeType.ALL)
    private UserActivation userActivation;

    @OneToMany(mappedBy = "userRegistration", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserRoles> userRolesList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_registration_residential_type",
            joinColumns = @JoinColumn(name = "user_registration_id"),
            inverseJoinColumns = @JoinColumn(name = "residential_type_id"))
    private List<ResidentialType> residentialTypes;
}
