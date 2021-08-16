package com.datascience.shop;


import com.datascience.shop.config.ApplicationConfig;
import com.datascience.shop.entity.Basket;
import com.datascience.shop.entity.Item;
import com.datascience.shop.entity.User;
import com.datascience.shop.service.BasketService;
import com.datascience.shop.service.ItemService;
import com.datascience.shop.service.ServiceException;
import com.datascience.shop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) throws ServiceException {
        // ApplicationContext
        try (
                //final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring-app.xml")) {
                //final AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext("com/datascience/shop")) {
                AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig.class)) {

                final String[] beanDefinitionNames =ctx.getBeanDefinitionNames();

            System.out.println(Arrays.toString(beanDefinitionNames));
            final ItemService itemService=ctx.getBean(ItemService.class);
            final List<Item> allItems=itemService.findAll();
            System.out.println(allItems.toString());

            final UserService userService=ctx.getBean(UserService.class);
            final User userRrr=userService.findByUserName("rrr");
            System.out.println(userRrr);

            final BasketService basketService=ctx.getBean(BasketService.class);
            final Basket basketRrr=basketService.findOrCreateForUser(userRrr);
            System.out.println(basketRrr);

        }
    }
}
