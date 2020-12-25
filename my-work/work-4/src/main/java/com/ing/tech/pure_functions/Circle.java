package com.ing.tech.pure_functions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Circle {
    private double radius;

    double circumference() {
        return 2.0 * Math.PI * this.radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
    }
}
