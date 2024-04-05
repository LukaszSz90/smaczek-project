package pl.smaczek.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "meal")
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    @Length(max = 800)
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_details_id")
    private RestaurantDetailsEntity restaurantDetails;

    @ManyToOne
    @JoinColumn(name = "meal_category_id")
    @ToString.Exclude
    private MealCategoryEntity mealCategory;

}
