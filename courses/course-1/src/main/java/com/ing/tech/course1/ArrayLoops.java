package com.ing.tech.course1;

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

        for (int i = 0; i < anArray.length; i++) {
            System.out.println(anArray[i]);
        }

        for (int temp : anArray) {
            System.out.println(temp);
        }

        List<Integer> arrayList = Arrays.asList(1, 2, 3, 4, 5);

        Iterator<Integer> integerList = arrayList.iterator();
        while(integerList.hasNext()) {
            System.out.println(integerList.next());
        }

        // TODO homework
        ArrayWrapper arrayWrapper = new ArrayWrapper();
        while(arrayWrapper.hasNext()) {
            System.out.println(arrayWrapper.next());
        }
    }

    static class ArrayWrapper implements Iterator {
        private int[] array = {1, 2, 3, 4, 5};

        @Override
        public boolean hasNext() {
            return false;// TO BE IMPLEMENTED
        }

        @Override
        public Object next() {
            return null;// TO BE IMPLEMENTED
        }
    }

}
