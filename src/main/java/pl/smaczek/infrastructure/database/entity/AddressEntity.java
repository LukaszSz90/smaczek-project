package pl.smaczek.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "home_number")
    private String homeNumber;

    @Column(name = "flat_number")
    private String flatNumber;

    @Column(name = "zip_code")
    private String zipCode;

    //todo - poąłczenie tabeli adresu z user i restaurant
}