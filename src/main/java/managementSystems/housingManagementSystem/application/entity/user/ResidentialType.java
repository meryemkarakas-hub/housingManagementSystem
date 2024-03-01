package managementSystems.housingManagementSystem.application.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "residential_type")
@Getter
@Setter
@NoArgsConstructor
public class ResidentialType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "residential_type", unique = true)
    private String residentialType;

    @ManyToMany(mappedBy = "residentialTypes")
    private List<UserRegistration> userRegistrations;

    @OneToMany(mappedBy = "residentialType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Blocks> blocks;
}
