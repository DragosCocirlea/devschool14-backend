package com.ing.tech.work51;

import com.ing.tech.work51.logging.LoggerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
//    @Qualifier("infoLogger") - option 2
    private  LoggerInterface loggerInterface;
//    private List<LoggerInterface> loggerInterface; - option 1

    @Value("${key:dsa}")
    private String key;

    @Autowired
    MysqlProperties properties;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        loggerInterface.forEach(it -> it.log("Application started")); - option 1
        loggerInterface.log(key);
        System.out.println(properties.getUsername());
    }
}
