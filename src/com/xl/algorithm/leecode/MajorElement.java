package com.xl.algorithm.leecode;

/**
 *
 * 求众数
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 *
 * 实现思路：
 *    1. 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
 *    2. 排序，取中位数
 */
public class MajorElement {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        majorElemet(arr);
    }

    private static void majorElemet(int[] arr) {
        int count = 0;
        int temp = arr[0];
        for (int i = 1; i < arr.length; i ++) {
            if (arr[i] == temp) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                temp = arr[i];
            }
        }

        System.out.println(temp);
    }


}
