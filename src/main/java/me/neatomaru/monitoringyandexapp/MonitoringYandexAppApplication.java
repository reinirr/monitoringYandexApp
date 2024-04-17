package me.neatomaru.monitoringyandexapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableConfigurationProperties
@EnableScheduling
@SpringBootApplication
public class    MonitoringYandexAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringYandexAppApplication.class, args);
    }

}
