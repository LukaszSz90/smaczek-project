package pl.smaczek.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "order_time")
    private String orderTime;

//    @Column(name = "order_restaurant_id")
//    private List<Long> order_restaurant_id = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<MealEntity> meals = new ArrayList<>();
}