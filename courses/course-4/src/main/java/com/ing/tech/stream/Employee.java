package com.ing.tech.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Double salary;

    public Employee salaryIncrement(Double percentage) {
        salary = salary + percentage * salary / 100;
        return this;
    }
}
