package com.revature.dux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class DuxApplicationBackend {
    public static void main(String[] args) {
        SpringApplication.run(DuxApplicationBackend.class, args);
    }

}