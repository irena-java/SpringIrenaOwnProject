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
        try (final ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class)) {
            final UserRepository userBean=ctx.getBean(UserRepository.class);


            final ItemRepository itemBean=ctx.getBean(ItemRepository.class);
//            final List<Item>items= itemBean.allItem();
//            items.forEach(System.out::println);


            final List<User>userList=userBean.findAll();
//            userList.forEach(System.out::println);
            final List<User> userRrr=userBean.findAllByNameIs("rrr");


            userRrr.forEach(System.out::println);
             List<User>userRrrr=userBean.userRrr("rrr");
            userRrrr.forEach(System.out::println);
            final List<User>userRrrrr=userBean.userRrrrr();
            userRrrr.forEach(System.out::println);


            System.out.println("---------------------------------");



   //         final BasketRepositary basketBean=ctx.getBean(BasketRepositary.class);
     //       final List<Basket> allBaskets=basketBean.allBasket();
       //     System.out.println(allBaskets);

//            User user -new User("rrr", UserRole.ADMIN,)
//            System.out.println("---------------------------------");
//            UserDao userDaoImpl=new UserDaoImpl();
//            User userRrr1= userDaoImpl.findByUsername("rrr");
            System.out.println("!!!userRrr = "+userRrr);
//            Set<User> userSetRrr=new HashSet<>();
//            userSetRrr.addAll(userRrr);
         //   System.out.println("!!!userRrr = "+userSetRrr.getClass());

//            System.out.println("!!!basketOfUser = "+(java.util.Set) userBean.basketOfUser(userSetRrr));
            System.out.println("---------------------------------");

            System.out.println(itemBean.findAllByPriceIs(5000.02));

//            List<User> usera=new ArrayList<>();
//            usera.add(userRrr);
            System.out.println(itemBean.findAllByUsers(userRrr.get(0)));

            System.out.println("!!!!!!!!!!!!!!!!---------------------------------");
            System.out.println("!!!basketOfUser = "+userBean.basketOfUser());

            System.out.println("!!!!!!!!!!!!!!!!---------------------------------");
            System.out.println("UUUbasketINUser = "+itemBean.basketInUser());


      //       System.out.println("!!!basketOfUser = "+userBean.basketOfUser(new HashSet<>()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
