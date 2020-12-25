package com.ing.tech.course1.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JavaExceptions {

    public static void main(String[] args) {
        // ArrayIndexOutOfBounds, NPE
        // CHECKED & UNCHECKED
//        first scenario
//        try {
//            test();
//            test2();
//            System.out.println("Test");
//        } catch (CheckedException e) {
//
//        } catch (CheckedException2 e) {
//
//        } finally {
//            System.out.println("Finally");
//        }


//        second - not recom
//        try {
//            test();
//            test2();
//            System.out.println("Test");
//        } catch (Exception e) {
//
//        } finally {
//            System.out.println("Finally");
//        }
//      3rd
//        try {
//            test();
//            test2();
//            System.out.println("Test");
//        } catch (CheckedException | CheckedException2 e) {
//
//        } finally {
//            System.out.println("Finally");
//        }
//        Try with resources
//        File file1 = new File("tes.txt");
//
//        try (FileInputStream inputStream = new FileInputStream(file1)) {
//
//        } catch (IOException e) {
//
//        }
//
        test3();
        System.out.println("Test");
    }

    static void test() throws CheckedException {
        throw new CheckedException();
    }

    static void test2() throws CheckedException2 {
        throw new CheckedException2();
    }

    static void test3() {
        throw new UncheckedException();
    }

}
