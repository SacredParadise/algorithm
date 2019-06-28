package com.xl.algorithm.leecode;

/**
 * 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 1, 3, 4, 1, 5, 5 };
        singleNum(arr);
    }

    private static void singleNum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }

        System.out.println(result);
    }
}
