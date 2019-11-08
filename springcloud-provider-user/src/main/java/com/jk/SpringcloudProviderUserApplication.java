package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderUserApplication.class, args);
    }

}
