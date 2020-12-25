package com.ing.tech.work51;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "mysql")
@Getter @Setter
@PropertySource("classpath:mysql.properties")
public class MysqlProperties {

    private String username, password, host, database;

}
