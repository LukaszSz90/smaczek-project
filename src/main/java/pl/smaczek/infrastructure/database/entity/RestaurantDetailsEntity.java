package pl.smaczek.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "restaurantDetailsId")
@ToString(of = {"restaurantDetailsId", "name"})
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

    @Column(name = "min_value_of_order")
    private BigDecimal minValueOfDelivery;

    @Column(name = "delivery_cost")
    private BigDecimal deliveryCost;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "delivery_detail_id")
//    private DeliveryDetailsEntity deliveryDetails;


    //todo połączenie tabeli z adresem
    //todo dodać listę posiłków w ofercie restauracji
}