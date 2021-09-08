package com.datascience.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserExtentionDTO {
    private UserDTO userDTO;
    private ItemDTO itemDTO;
}