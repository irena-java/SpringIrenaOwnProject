package com.datascience.shop.service;

import com.datascience.shop.dao.DaoException;
import com.datascience.shop.dao.UserDao;
import com.datascience.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() throws ServiceException {
        try {
            return userDao.findAll();
        } catch (DaoException e) {
            logger.error("Failed to find all users - DaoException" + e);
            throw new ServiceException("Failed to find all users" + e);
        }
    }

    public User findByUserName(String username) throws ServiceException {
        try {
            return userDao.findByUsername(username);
        } catch (DaoException e) {
            logger.error("Failed to find user by userName (failed method findByUserName(): DaoException, catch in class UserService. " + e);
            throw new ServiceException("Failed to find user by userName (failed method findByUserName(): DaoException, catch in class UserService. " + e);
        }
    }

    public User findById(Integer id) throws ServiceException {
        try {
            return userDao.findById(id);
        } catch (DaoException e) {
            logger.error("Failed to find user by id - DaoException" + e);
            throw new ServiceException("Failed to find user by id " + e);

        }
    }

    @Transactional
    public void delete(User user, Connection connection) throws ServiceException {
        if (user == null) {
            throw new ServiceException("fdf");
        } else {
            try {
                userDao.delete(user, connection);
            } catch (DaoException e) {
                logger.error("Failed to delete user " + user.getName() + e);
                throw new ServiceException("Failed to delete user");
            }
        }
    }
}