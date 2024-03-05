package managementSystems.housingManagementSystem.application.entity.management;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;

@Entity
@Table(name = "manager")
@Getter
@Setter
@NoArgsConstructor
public class Manager {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_registration_id", referencedColumnName = "id")
    private UserRegistration userRegistration;

    @OneToOne
    @JoinColumn(name = "residential_info_id", referencedColumnName = "id")
    private ResidentialInformation residentialInformation;

}
