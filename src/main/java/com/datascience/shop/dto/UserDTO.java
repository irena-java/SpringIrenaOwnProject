package com.datascience.shop.dto;

import com.datascience.shop.entity.Country;
import com.datascience.shop.entity.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String name;
    private UserRole userRole;
    private String clientInn;
    private Country country;
    private String contactInfo;
    private String password;
}