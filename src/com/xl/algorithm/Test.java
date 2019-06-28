package com.xl.algorithm;

public class Test {
    public static void main(String[] args) {
        forTest();


    }

    private static void forTest() {
        Integer arr1[] = { 1, 2, 3, 4, 5 };
        Integer arr2[] = { 6, 7, 8, 9, 10 };

        Integer[] node = arr1;
        for (Integer value : node) {
            System.out.print(value);
            if (value > 2) {
                node = arr2;
            }
        }
    }

}
