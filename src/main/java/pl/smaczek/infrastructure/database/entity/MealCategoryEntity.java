package pl.smaczek.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "name")
@Table(name = "meal_category")
public class MealCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_category_id")
    private Long mealCategoryId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "meal_category", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<MealEntity> meals;
}