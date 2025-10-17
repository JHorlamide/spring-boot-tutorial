package jhorlamide.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "name")
  private String name;

  @Column(nullable = false, name = "email")
  private String email;

  @Column(nullable = false, name = "password")
  private String password;

  @OneToMany(mappedBy = "user")
  @Builder.Default
  @ToString.Exclude
  private List<Address> addresses = new ArrayList<>();

  @ManyToMany
  @Builder.Default
  @JoinTable(
      name = "user_tags",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  @ToString.Exclude
  private Set<Tag> tags = new HashSet<>();

  @OneToOne(mappedBy = "user")
  private Profile profile;

  @ManyToMany
  @JoinTable(
      name = "wishlist",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private Set<Product> products = new HashSet<>();

  public void addAddress(Address address) {
    addresses.add(address);
    address.setUser(this);
  }

  public void removeAddress(Address address) {
    addresses.remove(address);
    address.setUser(null);
  }

  public void addTag(String tagName) {
    var tag = new Tag(tagName);
    tags.add(tag);
    tag.getUsers().add(this);
  }

  public void removeTag(Tag tag) {
    tags.remove(tag);
    tag.setUsers(null);
  }

  public void addProfile(Profile profile) {
    this.setProfile(profile);
    profile.setUser(this);
  }

}
