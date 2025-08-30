package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringBootAppConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppConfigServerApplication.class, args);
    }
}