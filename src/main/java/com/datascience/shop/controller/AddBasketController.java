package com.datascience.shop.controller;

import com.datascience.shop.config.ApplicationConfig;
import com.datascience.shop.dao.impl.BasketDaoImpl;
import com.datascience.shop.dao.impl.UserDaoImpl;
import com.datascience.shop.entity.Basket;
import com.datascience.shop.entity.Item;
import com.datascience.shop.entity.User;
import com.datascience.shop.service.BasketService;
import com.datascience.shop.service.ItemService;
import com.datascience.shop.service.ServiceException;
import com.datascience.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBasketController implements Controller {

    private  UserService userService = new UserService(new UserDaoImpl());
    private final BasketService basketService = new BasketService(new BasketDaoImpl());
    private static final Logger logger = LoggerFactory.getLogger(AddBasketController.class);
    private ItemService itemService;


    public AddBasketController(ItemService itemService) {
        this.itemService = itemService;
    }



    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String itemId = req.getParameter("itemId");
 /*убиваю эти строки при введении бина, меняю без параметров
            ItemService itemService = new ItemService(new ItemDaoImpl());*/
            //ItemService itemService;
            //= new ItemService();

            Item item = itemService.findById(Integer.parseInt(itemId));
            Integer userId = (Integer) req.getSession().getAttribute("userId");
            User user = userService.findById(userId);
            Basket basket = basketService.findOrCreateForUser(user);
            basket.getItems().add(item);
            basketService.createOrUpdate(basket);
            return new ControllerResultDto("items", true);
        } catch (ServiceException e) {
            logger.error("Failed executing AddBasketController" + e);
            return new ControllerResultDto("error-500");
        }
    }
}