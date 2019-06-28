package com.xl.algorithm.leecode;

import java.util.LinkedList;

/**
 * 无重复字符的最长子串
 *
 * 题目描述:
 *     给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 *     输入: "abcabcbb"
 *     输出: 3
 *     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 题目解析:
 *     建立一个256位大小的整型数组 freg ，用来建立字符和其出现位置之间的映射。
 *
 *     维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动。
 *
 *     （1）如果当前遍历到的字符从未出现过，那么直接扩大右边界；
 *     （2）如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符；
 *     （3）重复（1）（2），直到左边索引无法再移动；
 *     （4）维护一个结果res，每次用出现过的窗口大小来更新结果 res，最后返回 res 获取结果。
 *
 */
public class MaxSubStr {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(maxSubStr(str));
    }



    private static int maxSubStr(String str) {
        char[] chars = str.toCharArray();
        LinkedList<Character> subStrList = new LinkedList<>();
        int maxSubStrLen = 0;
        for (char c : chars) {
            //如果当前子字符串包含当前字符，则从后往前回退list
            if (subStrList.contains(c)) {
                if (maxSubStrLen < subStrList.size()) {
                    maxSubStrLen = subStrList.size();
                }
                while (!subStrList.isEmpty()) {
                    Character character = subStrList.pop();
                    if (character == c) {
                        break;
                    }
                }
            }

            subStrList.add(c);
        }

        if (maxSubStrLen < subStrList.size()) {
            maxSubStrLen = subStrList.size();
        }

        return maxSubStrLen;
    }



}
