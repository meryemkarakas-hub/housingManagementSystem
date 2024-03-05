package managementSystems.housingManagementSystem.application.entity.residential;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceHousingTypes;
import managementSystems.housingManagementSystem.application.entity.user.UserRegistration;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_housing_types_id", referencedColumnName = "id")
    private ReferenceHousingTypes referenceHousingTypes;

    @ManyToMany(mappedBy = "residentialTypes")
    private List<UserRegistration> userRegistrations;

    @OneToMany(mappedBy = "residentialType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Blocks> blocks;
}
