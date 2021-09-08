package com.datascience.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.datascience.shop")
@EnableJpaRepositories(basePackages = "com.datascience.shop.repository")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Autowired
    Environment env;
}