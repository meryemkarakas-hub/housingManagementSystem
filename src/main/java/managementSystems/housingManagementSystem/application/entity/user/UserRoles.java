package managementSystems.housingManagementSystem.application.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceUserRoles;

@Entity
@Table(name = "users_roles")
@Getter
@Setter
@NoArgsConstructor
public class UserRoles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_registration_id", referencedColumnName = "id")
    private UserRegistration userRegistration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_user_roles_id",referencedColumnName = "id")
    private ReferenceUserRoles referenceUserRoles;
}
