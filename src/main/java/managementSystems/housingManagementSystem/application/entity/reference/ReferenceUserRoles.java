package managementSystems.housingManagementSystem.application.entity.reference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reference_user_roles")
@Getter
@Setter
@NoArgsConstructor
public class ReferenceUserRoles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_roles", unique = true)
    private String userRoles;
}
