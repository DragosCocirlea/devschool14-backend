package com.ing.tech.pure_functions;

import java.util.function.BiFunction;

@FunctionalInterface
interface MyInterface{
    void display();
}

class Example {
    public void myMethod() {
        System.out.println("Instance Method");
    }

}

class Multiplication{
    public static int multiply(int a, int b){
        return a * b;
    }
}

@FunctionalInterface
interface HelloInterface{
    Hello display(String say);
}
class Hello{
    public Hello(String say){
        System.out.print(say);
    }
}

public class MethodReference {
    public static void main(String[] args) {
        Example example = new Example();
        MyInterface myInterface =  example::myMethod;
        myInterface.display();

        BiFunction<Integer, Integer, Integer> function = Multiplication::multiply;
        System.out.println(function.apply(10, 20));

        HelloInterface helloInterface = Hello::new;
        helloInterface.display("hello");
    }
}
