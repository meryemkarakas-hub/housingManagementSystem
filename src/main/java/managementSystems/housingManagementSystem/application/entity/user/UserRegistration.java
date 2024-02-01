package managementSystems.housingManagementSystem.application.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users_registration")
@Getter
@Setter
@NoArgsConstructor
public class UserRegistration {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

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

    @Column(name = "gender")
    private String gender;

    @Column(name = "kvkk")
    private Boolean kvkk;

    @Column(name = "user_role")
    private String userRole;

    @OneToOne(mappedBy = "userRegistration", cascade = CascadeType.ALL)
    private UserActivation userActivation;
}
