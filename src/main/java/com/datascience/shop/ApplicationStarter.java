package com.datascience.shop;

import com.datascience.shop.config.ApplicationConfig;
import com.datascience.shop.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
    final ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class);
    }
}

