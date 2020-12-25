package com.ing.tech.pure_functions;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface MyFunctionalInterface2 {

    //A method with no parameter
    public String sayHello();
}

@FunctionalInterface
interface MyFunctionalInterface {

    //A method with single parameter
    public int incrementByFive(int a);

}

@FunctionalInterface
interface StringConcat {

    public String sconcat(String a, String b);
}


public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        MyFunctionalInterface2 f = () -> "hello";
        System.out.println(f.sayHello());

        MyFunctionalInterface f2 = x -> x + 5;
        System.out.println(f2.incrementByFive(10));

        StringConcat f3 = (a, b) -> a.concat(b);
        System.out.println(f3.sconcat("ana", " are mere"));

        list.add("ana");
        list.add("maria");
        list.add("alexandru");

        list.forEach(System.out::println);
    }
}
