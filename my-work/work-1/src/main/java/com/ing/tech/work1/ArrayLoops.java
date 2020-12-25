package com.ing.tech.work1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayLoops {

    public static void main(String[] args) {
        int[] anArray = new int[5];
        anArray[0] = 1;
        anArray[1] = 2;
        anArray[2] = 3;
        anArray[3] = 4;
        anArray[4] = 5;

//        for (int i = 0; i < anArray.length; i++) {
//            System.out.println(i);
//        }
//
//        for (int x : anArray) {
//            System.out.println(x);
//        }

//        List<Integer> arrayList = Arrays.asList(1, 2, 3, 4 , 5);
//
//        Iterator<Integer> integerList = arrayList.iterator();
//        while (integerList.hasNext()) {
//            System.out.println(integerList.next());
//        }

//        TODO: Homework
        ArrayWrapper arrayWrapper = new ArrayWrapper(anArray);
        while (arrayWrapper.hasNext()) {
            System.out.println(arrayWrapper.next());
        }

    }

    static class ArrayWrapper implements Iterator {
        private int[] array;
        private int cursor = 0;

        public ArrayWrapper(int[] array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return cursor < array.length;
        }

        @Override
        public Object next() {
            return array[cursor++];
        }
    }

}
