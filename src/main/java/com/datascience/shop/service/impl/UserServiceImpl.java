package com.datascience.shop.service.impl;

import com.datascience.shop.dto.UserDTO;
import com.datascience.shop.entity.User;
import com.datascience.shop.repository.UserRepository;
import com.datascience.shop.service.ServiceException;
import com.datascience.shop.service.UserServise;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServise {
    private final UserRepository userRepository;

    @Override
    public User getById(Integer id) {
        User user=userRepository.findById(id)
                .orElseThrow(()->{
                    throw new RuntimeException("не удалось найти юзера с Id "+id);
                });
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Page<User> getPage(String name,Pageable pageable) {
        return userRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN')")
    public User create(UserDTO userDTO) {
        if(!Objects.isNull(userDTO.getId())){
            throw new IllegalArgumentException("уже существует такой юзер");
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) throws ServiceException {
        if(!userRepository.existsById(id)){
            throw new ServiceException("такого юзера нет");
        }
            userRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, UserDTO userDTO) throws ServiceException {
        if(!userRepository.existsById(id)){
            throw new ServiceException("такого юзера нет");
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public List<User> getByName(String name) {
        List<User> users=userRepository.findAllByNameIs(name);
        return users;
    }
}
