package com.ballot.rigging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ballot.rigging.*"})
public class RiggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiggingApplication.class, args);
    }

}
