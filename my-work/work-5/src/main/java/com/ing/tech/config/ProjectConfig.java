package com.ing.tech.config;

import com.ing.tech.bean.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.ing.tech.bean", "com.ing.tech.atm"})
public class ProjectConfig {

    // no need because of service annotation in PersonService
//    @Bean
//    public PersonService createPersonService() {
//        return new PersonService("David");
//    }

}
