package com.gabrielnz.hrapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class HrApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrApiGatewayApplication.class, args);
    }

}
