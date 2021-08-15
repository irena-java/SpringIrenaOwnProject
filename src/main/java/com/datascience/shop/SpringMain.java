package com.datascience.shop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // ApplicationContext
        try (final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/spring-app.xml")) {
        final String[] beanDefinitionNames =ctx.getBeanDefinitionNames();
            System.out.println(Arrays.toString(beanDefinitionNames));
        }
    }
}
