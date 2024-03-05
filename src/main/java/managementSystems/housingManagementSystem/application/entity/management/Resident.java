package managementSystems.housingManagementSystem.application.entity.management;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.user.UserActivation;
import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;

@Entity
@Table(name = "resident")
@Getter
@Setter
@NoArgsConstructor
public class Resident {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "users_registration_id", referencedColumnName = "id")
    private UserRegistration userRegistration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resindential_info_id", referencedColumnName = "id")
    private ResidentialInformation residentialInformation;
}
