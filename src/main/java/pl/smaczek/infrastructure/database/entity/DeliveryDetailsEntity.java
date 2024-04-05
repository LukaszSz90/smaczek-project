package pl.smaczek.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Builder
@Getter
@Setter
@ToString(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery_details")
public class DeliveryDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @Column(name = "preparing_time")
    private String preparingTime;

    @Column(name = "delivery_price")
    private BigDecimal deliveryPrice;

    @Column(name = "min_order_value")
    private BigDecimal minOrderValue;

    @Column(name = "max_delivery_distance")
    private Integer maxDeliveryDistance;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "delivery_details")
    private RestaurantDetailsEntity restaurantDetails;
}