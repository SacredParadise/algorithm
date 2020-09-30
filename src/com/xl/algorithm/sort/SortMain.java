package com.xl.algorithm.sort;

import java.util.Arrays;

public class SortMain {

    public static void main(String[] args) {
        int[] arr = { 5, 6, 4, 2, 9 };
        QuickSort quickSort = new QuickSort();
        try {
            int[] result = quickSort.sort(arr);
            System.out.println(Arrays.toString(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
