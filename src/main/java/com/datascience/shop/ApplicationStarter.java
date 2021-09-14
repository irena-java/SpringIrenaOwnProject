package com.datascience.shop;

import com.datascience.shop.entity.User;
import com.datascience.shop.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
    final ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class);
        System.out.println("БИны в контексте - "+ Arrays.toString(ctx.getBeanDefinitionNames()));
        final UserRepository bean=ctx.getBean(UserRepository.class);
        List<User> users= bean.findAll();
        users.forEach(System.out::println);
    }
}

