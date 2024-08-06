package com.revature.dux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;

@SpringBootApplication
public class DuxApplicationBackend {
    private static String path = "src/main/resources/ducky.jpg";
    private static File file = new File(path);

    public static void main(String[] args) {
        if(file.exists())
            SpringApplication.run(DuxApplicationBackend.class, args);
    }

}