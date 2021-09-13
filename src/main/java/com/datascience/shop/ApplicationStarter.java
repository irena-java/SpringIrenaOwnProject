package com.datascience.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
    final ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class);
        System.out.println("БИны в контексте - "+ Arrays.toString(ctx.getBeanDefinitionNames()));
    }
}

