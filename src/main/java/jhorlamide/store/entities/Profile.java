package jhorlamide.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Entity()
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "profiles")
public class Profile {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "bio")
  private String bio;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;

  @Column(name = "loyalty_points")
  private int loyaltyPoints;

  @OneToOne
  @JoinColumn(name = "id")
  @MapsId
  @ToString.Exclude
  private User user;
}
