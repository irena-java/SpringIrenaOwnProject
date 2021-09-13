package com.datascience.shop.service;

import com.datascience.shop.dto.ItemDTO;
import com.datascience.shop.dto.UserDTO;
import com.datascience.shop.dto.UserExtentionDTO;
import com.datascience.shop.entity.Item;

import java.util.List;

public interface UserExtentionService {
List<Item> getAllItemsOfUser(String name);
}
