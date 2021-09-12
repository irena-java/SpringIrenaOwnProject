package com.datascience.shop.service;

import com.datascience.shop.dto.UserDTO;
import com.datascience.shop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserServise {
    User getById(Integer id);
    List<User> getAll();
    Page<User> getPage(String name,Pageable pageable);
    User create(UserDTO userDTO);
    void delete(Integer id) throws ServiceException;
    void update(Integer id, UserDTO userDTO) throws ServiceException;
    List<User> getByName(String name);
}
