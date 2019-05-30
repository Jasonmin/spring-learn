package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.learnspring")
@EntityScan("com.learnspring")
@SpringBootApplication
public class LearnspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnspringApplication.class, args);
    }

}
