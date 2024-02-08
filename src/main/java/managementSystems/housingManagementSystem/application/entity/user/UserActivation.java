package managementSystems.housingManagementSystem.application.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users_activation")
@Getter
@Setter
@NoArgsConstructor
public class UserActivation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "users_registration_id", referencedColumnName = "id")
    private UserRegistration userRegistration;

    @Column(name = "activation_status")
    private Boolean activationStatus;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "registration_time")
    private LocalDateTime registrationTime;

    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;


}
