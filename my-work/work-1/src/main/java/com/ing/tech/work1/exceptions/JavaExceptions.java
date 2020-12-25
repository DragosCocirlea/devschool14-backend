package com.ing.tech.work1.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaExceptions {

    public static void main(String[] args) {

// first
//        try {
//            test();
//            test2();
//            System.out.println("test");
//        } catch (CheckedException e) {
//
//        } catch (CheckedException2 e) {
//
//        } finally {
//            System.out.println("finally");
//        }

// second - not recommended
//        try {
//            test();
//            test2();
//            System.out.println("test");
//        } catch (Exception e) {
//
//        } finally {
//            System.out.println("finally");
//        }

// third
//        try {
//            test();
//            test2();
//            System.out.println("test");
//        } catch (CheckedException | CheckedException2 e) {
//
//        } finally {
//            System.out.println("finally");
//        }


//        RESOURCES
//        File file1 = new File("test1.txt");
//        File file2 = new File("test2.txt");

//        try catch classic
//        try {
//            FileInputStream inputStream = new FileInputStream(file1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


//        try with resources - trebuie sa implementeze Closeable
//        try (FileInputStream inputStream = new FileInputStream(file1);) {
//
//        } catch (IOException e) {
//
//        }

        test3();
        System.out.println("test");

    }

    static void test() throws CheckedException {
        throw new CheckedException();
    }

    static void test2() throws CheckedException2 {
        throw new CheckedException2();
    }

    static void test3() throws UncheckedException {
        throw new UncheckedException();
    }

}
