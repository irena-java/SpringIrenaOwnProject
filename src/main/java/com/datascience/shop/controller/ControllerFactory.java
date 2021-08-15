package com.datascience.shop.controller;

import com.datascience.shop.config.ApplicationConfig;
import com.datascience.shop.dao.ItemDaoImpl;
import com.datascience.shop.service.ItemService;
import com.datascience.shop.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



public class ControllerFactory {
    private static final Logger logger = LoggerFactory.getLogger(DeleteUserController.class);
    private Map<String, Controller> controllerMap = new HashMap<>();

    private void init() throws SQLException {
        controllerMap.put("GET/profile", new ShowPageController("profile"));
        controllerMap.put("GET/login", new ShowPageController("login"));
        controllerMap.put("GET/main", new ShowPageController("main"));
        controllerMap.put("GET/client", new ShowPageController("login"));
        controllerMap.put("GET/items", new ShowAllItemsController());

        //?? controllerMap.put("GET/addToBasket", new AddBasketController());
        try {
            ApplicationConfig applicationConfig=new ApplicationConfig();
            controllerMap.put("GET/addToBasket", new AddBasketController(new ItemService(new ItemDaoImpl(applicationConfig.getDataSource()))));
        }
        catch (Exception e) {
            logger.error("Failed dataSource" + e);
            throw new SQLException("Failed dataSource");
        }



        controllerMap.put("GET/basket", new ShowBasketController());
        controllerMap.put("GET/deleteFromBasket", new DeleteFromBasketController());
        controllerMap.put("GET/deleteUser", new DeleteUserController());
        controllerMap.put("GET/users", new ShowAllUsersController());
        controllerMap.put("GET/rates", new ShowRatesController());
        controllerMap.put("POST/login", new LoginController());
    }

    public Controller getController(HttpServletRequest request) throws SQLException{
        if (controllerMap.isEmpty()) {
            try {
                init();
            } catch (SQLException e) {
                logger.error("Failed dataSource" + e);
                throw new SQLException("Failed dataSource");
            }
        }
        return controllerMap.get(request.getMethod() + request.getPathInfo());
    }
}