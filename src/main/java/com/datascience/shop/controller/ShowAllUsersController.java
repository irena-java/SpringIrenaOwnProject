package com.datascience.shop.controller;

import com.datascience.shop.entity.User;
import com.datascience.shop.service.ServiceException;
import com.datascience.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowAllUsersController implements Controller {
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(ShowAllUsersController.class);

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<User> users = userService.findAll();
            req.setAttribute("users", users);
            return new ControllerResultDto("users");
        } catch (ServiceException e) {
            logger.error("Failed executing ShowAllUsersController" + e);
            return new ControllerResultDto("error-500");
        }
    }
}