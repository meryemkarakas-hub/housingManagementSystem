package managementSystems.housingManagementSystem.application.entity.reference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "reference_city")
@Getter
@Setter
@NoArgsConstructor
public class ReferenceCity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "city_name", unique = true)
    private String cityName;

    @OneToMany(mappedBy = "referenceCity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ReferenceCountry> referenceCountryList;


}
