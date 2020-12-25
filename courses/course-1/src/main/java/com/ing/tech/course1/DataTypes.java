package com.ing.tech.course1;

public class DataTypes {

    public static void main(String[] args) {
        //primitive data types
//        byte, - 1
//        short, - 2
//        int,  - 4
//        long, - 8
//
//        float, - 4
//        double, - 8
//
//        boolean, - not defined precisely
//
//        char - 2

        // Autoboxing
        char c1 = 'a';
        Character c2 = c1;

        // Unboxing
        char c3 = c2;

        Long sum = 0L;

        long start = System.currentTimeMillis();

        for (int  i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }

        long stop = System.currentTimeMillis();

        System.out.println(stop - start);
    }

}
