package com.xl.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Test {
    public static void main(String[] args) {

        System.out.println(Math.log(4) / Math.log(2));
        System.out.println(Math.log(4));

//        int[] nums = new int[] { 1, 2, 3 };
//        List list = Arrays.asList(nums);
//        System.out.println(list);
//
//        List<Integer> list2 = new ArrayList<>(3);
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);


//        forTest();
//        int[] nums = new int[5];
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }


//        long mills = 1562326032l;
//        Date date = new Date(mills);
//        System.out.println(date);
//
//        Input input = new Input();
//        input.corpus = new ArrayList<>();
//        input.corpus.add("Õ€ﬂ«ﬂ«");
//        input.corpus.add("wahaha");


        System.out.println(uniquePaths(4, 4));


    }

    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int k = 1; k < m; k++) {
            for (int i = 1; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i];
            }
        }

        return dp[m - 1];
    }





    static class Input {
        List<String> corpus;

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
