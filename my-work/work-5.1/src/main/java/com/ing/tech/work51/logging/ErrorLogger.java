package com.ing.tech.work51.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Primary
//@Profile("dev")
public class ErrorLogger implements LoggerInterface {

    @Override
    public void log(String message) {
        log.error(message);
    }
}
