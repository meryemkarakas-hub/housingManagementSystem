package managementSystems.housingManagementSystem.application.entity.reference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reference_country")
@Getter
@Setter
@NoArgsConstructor
public class ReferenceCountry {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_city_id", referencedColumnName = "id")
    private ReferenceCity referenceCity;

    @Column(name = "country_name")
    private String countryName;

}
