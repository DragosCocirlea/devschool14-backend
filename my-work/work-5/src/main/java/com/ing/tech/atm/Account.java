package com.ing.tech.atm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Account {
    @Getter
    private final int id;
    private final int pin;

    @Getter
    @Setter
    private double balance;

    public boolean checkPin(int pin) {
        return this.pin == pin;
    }

    @Override public String toString() {
        return id + "-" + pin + "-" + balance;
    }
}
