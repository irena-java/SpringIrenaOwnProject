package com.datascience.shop;

import com.datascience.shop.dao.UserDao;
import com.datascience.shop.dao.impl.UserDaoImpl;
//import com.datascience.shop.entity.Basket;
import com.datascience.shop.entity.Item;
import com.datascience.shop.entity.User;
//import com.datascience.shop.repository.BasketRepositary;
import com.datascience.shop.entity.UserRole;
import com.datascience.shop.repository.ItemRepository;
import com.datascience.shop.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class);
    //        try (final ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class)) {
//            final UserRepository userBean=ctx.getBean(UserRepository.class);
//            final ItemRepository itemBean=ctx.getBean(ItemRepository.class);
//            final List<User>userList=userBean.findAll();
//            final List<User> userRrr=userBean.findAllByNameIs("rrr");
//            userRrr.forEach(System.out::println);
//            List<User>userRrrr=userBean.userRrr("rrr");
//            userRrrr.forEach(System.out::println);
//            final List<User>userRrrrr=userBean.userRrrrr();
//            userRrrr.forEach(System.out::println);
//            System.out.println("---------------------------------");
//            System.out.println("!!!userRrr = "+userRrr);
//            System.out.println("---------------------------------");
//            System.out.println(itemBean.findAllByPriceIs(5000.02));
//            System.out.println(itemBean.findAllByUsers(userRrr.get(0)));
//            System.out.println("!!!!!!!!!!!!!!!!---------------------------------");
//            System.out.println("!!!basketOfUser = "+userBean.basketOfUser());
//            System.out.println("!!!!!!!!!!!!!!!!---------------------------------");
//            System.out.println("UUUbasketINUser = "+itemBean.basketInUser());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
    }
}
