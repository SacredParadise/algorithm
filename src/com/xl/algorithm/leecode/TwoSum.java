package com.xl.algorithm.leecode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 两数之和
 *
 * 题目描述:
 *     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *     给定 nums = [2, 7, 11, 15], target = 9
 *     因为 nums[0] + nums[1] = 2 + 7 = 9
 *     所以返回 [0, 1]
 *
 * 题目解析:
 *     使用查找表来解决该问题。
 *
 *     设置一个 map 容器 record 用来记录元素的值与索引，然后遍历数组 nums。
 *
 *     每次遍历时使用临时变量 complement 用来保存目标值与当前值的差值
 *     在此次遍历中查找 record ，查看是否有与 complement 一致的值，如果查找成功则返回查找值的索引值与当前变量的值 i
 *     如果未找到，则在 record 保存该元素与索引值 i
 *
 *
 *
 */
public class TwoSum {

    public static void main(String args[]) {
        int[] arr = {2, 7, 11, 15};
        int sum = 9;

        int[] results = twoSum(arr, sum);
        System.out.println(results);
    }


    public static int[] twoSum(int[] nums, int target) {
        //获得数组值和下标映射map
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>(nums.length);
        Integer index;
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            index = dict.get(sub);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
            dict.put(nums[i], i);
        }


        throw new IllegalArgumentException("No solution");
    }


public static ArrayList<Integer> twoSum2(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>(0);
        }

        //存储结果
        ArrayList<Integer> results = new ArrayList<>();

        //arr数组(value, 下表) map
        HashMap<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arrMap.put(arr[i], i);
        }

        int diff = 0;
        for (int i = 0; i < arr.length; i++) {
            if (results.contains(i)) {
                continue;
            }
            diff = num - arr[i];
            if (arrMap.get(diff) != null) {
                results.add(i);
                results.add(arrMap.get(diff));

                System.out.println(
                        new StringBuilder("[").append(i).append(", ").append(arrMap.get(diff)).append("]").toString());
            }
        }


        return results;
    }




}
