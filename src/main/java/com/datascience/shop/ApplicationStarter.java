package com.datascience.shop;

import com.datascience.shop.entity.User;
import com.datascience.shop.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        try (final ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class)) {
            final UserRepository bean=ctx.getBean(UserRepository.class);
            final List<User>userList=bean.findAll();
            userList.forEach(System.out::println);
            final List<User>userRrr=bean.findAllByNameIs("rrr");
            userRrr.forEach(System.out::println);
            final List<User>userRrrr=bean.userRrr("rrr");
            userRrrr.forEach(System.out::println);
            final List<User>userRrrrr=bean.userRrrrr();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
