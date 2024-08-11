package managementSystems.housingManagementSystem.application.entity.residential;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import managementSystems.housingManagementSystem.application.entity.reference.ReferenceHousingTypes;

@Entity
@Table(name = "housing_information")
@Getter
@Setter
@NoArgsConstructor
public class HousingInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_housing_types_id", referencedColumnName = "id")
    private ReferenceHousingTypes referenceHousingTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blocks_id", referencedColumnName = "id")
    private Blocks blocks;

    @Column(name = "flat_number")
    private String flatNumber;

    @Column(name = "home_number")
    private String homeNumber;

    @Column(name = "home_square_meters")
    private Float homeSquareMeters;

    @Column(name = "number_of_rooms")
    private String numberOfRooms;

    @Column(name = "number_of_bathrooms")
    private String numberOfBathrooms;

    @Column(name = "number_of_balconies")
    private String numberOfBalconies;

    @Column(name = "aspect")
    private String aspect;

    @Column(name = "home_owner_name")
    private String homeOwnerName;

    @Column(name = "home_owner_surname")
    private String homeOwnerSurname;

    @Column(name = "home_owner_identity_number")
    private String homeOwnerIdentityNumber;

    @Column(name = "home_owner_email_address")
    private String homeOwnerEmailAddress;

    @Column(name = "leaseholder_name")
    private String leaseholderName;

    @Column(name = "leaseholder_surname")
    private String leaseholderSurname;

    @Column(name = "leaseholder_identity_number")
    private String leaseholderIdentityNumber;

    @Column(name = "leaseholder_email_address")
    private String leaseholderEmailAddress;

    @Column(name = "electricity_subscription_number")
    private String electricitySubscriptionNumber;

    @Column(name = "water_subscription_number")
    private String waterSubscriptionNumber;

    @Column(name = "natural_gas_subscription_number")
    private String naturalGasSubscriptionNumber;
}
