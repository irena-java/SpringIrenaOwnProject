package com.datascience.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String name;
    @Column(name = "user_role_id")
    private UserRole userRole;
    private String clientInn;
    @Column(name = "country_id")
    private Country country;
    @Column(name = "contact_info")
    private String contactInfo;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "baskets",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))

    private List<Item> items;

    @Override
    public String toString() {
        return "User{" +
                "Id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", userRole=" + userRole +
                ", clientInn='" + clientInn + '\'' +
                ", country='" + country + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}