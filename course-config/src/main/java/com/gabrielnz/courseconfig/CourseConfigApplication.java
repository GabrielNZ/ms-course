package com.gabrielnz.courseconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CourseConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseConfigApplication.class, args);
    }

}
