package com.datascience.shop;

import com.datascience.shop.config.ApplicationConfig;
import com.datascience.shop.entity.Item;
import com.datascience.shop.entity.User;
import com.datascience.shop.repository.UserRepository;
import com.datascience.shop.service.ServiceException;
import com.datascience.shop.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) throws ServiceException {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            final String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
            System.out.println(Arrays.toString(beanDefinitionNames));

            final UserRepository userRepository=ctx.getBean(UserRepository.class);
            final List<User> allUsers=userRepository.findAll();
            allUsers.forEach(System.out::println);
        }
    }
}
