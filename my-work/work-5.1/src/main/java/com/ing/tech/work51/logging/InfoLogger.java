package com.ing.tech.work51.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Profile("!dev")
public class InfoLogger implements LoggerInterface {

    @Override
    public void log(String message) {
        log.info(message);
    }
}
