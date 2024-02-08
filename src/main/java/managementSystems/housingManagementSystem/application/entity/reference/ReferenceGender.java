package managementSystems.housingManagementSystem.application.entity.reference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reference_gender")
@Getter
@Setter
@NoArgsConstructor
public class ReferenceGender {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "gender", unique = true)
    private String gender;
}
