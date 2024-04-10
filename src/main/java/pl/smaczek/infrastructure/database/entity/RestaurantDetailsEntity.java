package pl.smaczek.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "restaurantDetailsId")
@Table(name = "restaurant_details")
public class RestaurantDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_details_id")
    private Long id;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "nip")
    private Integer nip;

    @Column(name = "phone")
    private String phone;

    @Column(name = "open_hour")
    private String openHour;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user_details")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant_details", cascade = CascadeType.ALL)
    private Set<MealEntity> meal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private DeliveryDetailsEntity deliveryDetails;

}