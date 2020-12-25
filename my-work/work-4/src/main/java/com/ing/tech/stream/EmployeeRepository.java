package com.ing.tech.stream;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private List<Employee> empList;

    public EmployeeRepository(List<Employee> empList) {
        this.empList = empList;

    }
    public Employee findById(Integer id) {
        for (Employee emp : empList) {
            if (emp.getId() == id) {
                return emp;
            }
        }

        return null;
    }

    public Optional<Employee> findEmployeeById(Integer id) {

        for (Employee emp : empList) {
            if (emp.getId() == id) {
                return Optional.ofNullable(emp);
            }
        }

        return Optional.empty();
    }

}