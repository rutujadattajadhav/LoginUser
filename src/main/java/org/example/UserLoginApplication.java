package org.example;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import reactor.core.publisher.Hooks;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
public class
UserLoginApplication {
    public static void main(String[] args) {
        MDC.put("correlationId", UUID.randomUUID().toString()+"_app_startup_log");
        Hooks.enableAutomaticContextPropagation();
        SpringApplication.run(UserLoginApplication.class,args);

    }
}