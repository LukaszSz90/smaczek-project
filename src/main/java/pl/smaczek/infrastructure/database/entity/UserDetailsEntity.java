package pl.smaczek.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.smaczek.infrastructure.database.entity.UserEntity;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "userDetailsId")
@ToString(of = {"userDetailsId", "name", "surneme", "phone"})
@Table(name = "user_details")
public class UserDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_details_id")
    private Long userDetailsId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user_details")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private UserEntity user;

    //todo - połączenie tabeli z address
    //todo - połączenie z my_rating, order i favourite
}