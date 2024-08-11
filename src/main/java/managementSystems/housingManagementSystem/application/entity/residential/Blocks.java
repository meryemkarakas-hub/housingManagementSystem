package managementSystems.housingManagementSystem.application.entity.residential;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.management.ResidentialInformation;

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

    @Column(name = "block_name")
    private String blockName;

    @Column(name = "number_of_flats")
    private Integer numberOfFlatsForBlock;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "residential_type_id", referencedColumnName = "id")
//    private ResidentialType residentialType;

    @OneToMany(mappedBy = "blocks", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Homes> homes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resindential_info_id", referencedColumnName = "id")
    private ResidentialInformation residentialInformation;

    @OneToMany(mappedBy = "blocks", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HousingInformation> housingInformationList;
}
