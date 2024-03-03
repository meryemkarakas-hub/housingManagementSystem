package managementSystems.housingManagementSystem.application.entity.residential;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "blocks")
@Getter
@Setter
@NoArgsConstructor
public class Blocks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "block_name", unique = true)
    private String blockName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "residential_type_id", referencedColumnName = "id")
    private ResidentialType residentialType;

    @OneToMany(mappedBy = "blocks", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Homes> homes;
}
