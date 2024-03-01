package managementSystems.housingManagementSystem.application.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "homes")
@Getter
@Setter
@NoArgsConstructor
public class Homes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "home_no", unique = true)
    private String homeNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blocks_id", referencedColumnName = "id")
    private Blocks blocks;
}
