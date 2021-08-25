   package com.datascience.shop.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//
// @Data
@Setter
@Getter
@Builder
//@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@Getter
//@Setter
@Entity
@Table(name="users")
public class User extends BaseEntity {
    private String name;
    @Column(name="user_role_id")
    private UserRole userRole;
    private String clientInn;
    @Column(name="country_id")
    private String country;
    @Column(name="contact_info")
    private String contactInfo;
    private String password;

//    @ManyToMany (fetch = FetchType.EAGER, mappedBy = "users")
//    private Set<Item> items;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "baskets",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
//
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

//@ManyToMany (fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //private List<Item> items=new ArrayList<>();




//       public User() {
//    }

//    public User(Integer id, String name, UserRole userRole, String clientInn, String country, String contactInfo, String password) {
//        super(id);
//        if (name != null && password != null) {
//            this.name = name;
//            this.userRole = userRole;
//            this.clientInn = clientInn;
//            this.country = country;
//            this.contactInfo = contactInfo;
//            this.password = password;
//        }
//    }

//    public User(String name, UserRole userRole, String clientInn, String country, String contactInfo, String password) {
//        if (name != null && password != null) {
//            this.name = name;
//            this.userRole = userRole;
//            this.clientInn = clientInn;
//            this.country = country;
//            this.contactInfo = contactInfo;
//            this.password = password;
//        }
//    }
//
//    public User(Integer id, String name, String password) {
//        super(id);
//        if (name != null && password != null) {
//            this.name = name;
//            this.password = password;
//        }
//    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public UserRole getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(UserRole userRole) {
//        this.userRole = userRole;
//    }
//
//    public String getClientInn() {
//        return clientInn;
//    }
//
//    public void setClientInn(String clientInn) {
//        this.clientInn = clientInn;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getContactInfo() {
//        return contactInfo;
//    }
//
//    public void setContactInfo(String contactInfo) {
//        this.contactInfo = contactInfo;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "ID='" + super.getId() + '\'' +
//                ",      name='" + name + '\'' +
//                ", userRole=" + userRole +
//                ", clientInn='" + clientInn + '\'' +
//                ", country='" + country + '\'' +
//                ", contactInfo=" + contactInfo + "}" + '\n';
//    }
//
//    public String toStringShort() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", userRole=" + userRole +
//                ", clientInn='" + clientInn + '\'' +
//                ", country='" + country + '\'' +
//                ", contactInfo=" + contactInfo.toString();
//
//    }
}