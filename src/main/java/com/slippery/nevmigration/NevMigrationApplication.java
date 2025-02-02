package com.slippery.nevmigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NevMigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NevMigrationApplication.class, args);
    }

}
