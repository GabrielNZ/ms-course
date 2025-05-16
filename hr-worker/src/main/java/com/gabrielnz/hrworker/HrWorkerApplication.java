package com.gabrielnz.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HrWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrWorkerApplication.class, args);
    }

}
