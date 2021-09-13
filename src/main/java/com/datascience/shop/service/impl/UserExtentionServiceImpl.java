package com.datascience.shop.service.impl;

import com.datascience.shop.dto.ItemDTO;
import com.datascience.shop.dto.UserDTO;
import com.datascience.shop.dto.UserExtentionDTO;
import com.datascience.shop.entity.Item;
import com.datascience.shop.entity.User;
import com.datascience.shop.repository.UserRepository;
import com.datascience.shop.service.UserExtentionService;
import com.datascience.shop.service.UserServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserExtentionServiceImpl implements UserExtentionService {
    private final UserRepository userRepository;

    @Override
    public List<Item> getAllItemsOfUser(String name) {
        return null;
    }


}