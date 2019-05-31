package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.jdbc","com.learnspring"})
@EntityScan(basePackages = {"com.jdbc","com.learnspring"})
@ComponentScan(basePackages = {"com.jdbc","com.learnspring"})
@SpringBootApplication
//@EnableAdminServer
public class LearnspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnspringApplication.class, args);
    }

}
