package com.peachmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class, MongoAutoConfiguration.class, H2ConsoleAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class peachMarketGeoApplication {
    public static void main(String[] args) {
        SpringApplication.run(peachMarketGeoApplication.class, args);
    }
}
