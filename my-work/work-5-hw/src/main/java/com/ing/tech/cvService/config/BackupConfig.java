package com.ing.tech.cvService.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "backup")
@PropertySource("classpath:application.properties")
@Getter @Setter
public class BackupConfig {
    private String filename;
}
