package com.ing.tech.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessLogic {

    public void transferMoney() {
        log.info("money transfered");
    }
}
