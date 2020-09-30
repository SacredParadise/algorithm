package com.xl.algorithm.leecode;

import java.util.LinkedList;
import java.util.List;

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
//        String str = "abcabcbb";
//        System.out.println(maxSubStr(str));

        test();
    }


    /**
     * 基于窗口实现
     * 该实现效率击败了100%，内存占用击败了98%
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = s.length() > 0 ? 1 : 0;
        char[] chars = s.toCharArray();
        int start = 0;
        char temp;
        int rIndex = -1;
        for (int i = 1; i < chars.length; i++) {
            temp = chars[i];
            rIndex = -1;
            //判断i ~ j 区间是否包含新字符、
            for (int k = start; k <= i - 1; k++) {
                if (temp == chars[k]) {
                    rIndex = k;
                    break;
                }
            }
            if (rIndex >= 0) {
                //若存在重复字符，则start置为重复字符
                start = rIndex + 1;

            }

            maxLen = maxLen < i - start + 1 ? i - start + 1 : maxLen;
        }

        System.out.println(maxLen);

        return maxLen;
    }


//    public static int lengthOfLongestSubstring(String s) {
//        int maxLen = s.length() > 0 ? 1 : 0;
//        char[] chars = s.toCharArray();
//        int start = 0;
//        int end = 0;
//        char temp;
//        int rIndex = -1;
//        for (int i = 1; i < chars.length; i++) {
//            temp = chars[i];
//            rIndex = -1;
//            //判断i ~ j 区间是否包含新字符、
//            for (int k = start; k <= end; k++) {
//                if (temp == chars[k]) {
//                    rIndex = k;
//                    break;
//                }
//            }
//            if (rIndex < 0) {
//                end = i;
//            } else {
//                //若存在重复字符，则start置为重复字符
//                start = rIndex + 1;
//                end = i;
//            }
//            maxLen = maxLen < end - start + 1 ? end - start + 1 : maxLen;
//        }
//
//        System.out.println(maxLen);
//
//        return maxLen;
//    }



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


    public static int lengthOfLongestSubstring2(String s) {
        LinkedList<Character> subStrs = new LinkedList();
        int maxLen = 0;
        char[] chars = s.toCharArray();
        char temp;
        for (int i = 0; i < chars.length; i++) {
            temp = chars[i];
            if (subStrs.contains(temp)) {
//                int lastIndex = subStrs.lastIndexOf(temp);
//                subStrs = subStrs.subList(lastIndex + 1, subStrs.size());
                while (!subStrs.isEmpty()) {
                    if (subStrs.pop() == temp) {
                        break;
                    }
                }


//                i = i - lastIndex + 1;
            }
//            else {
//                subStrs.add(temp);
//            }

            subStrs.add(temp);

            if (maxLen < subStrs.size()) {
                maxLen = subStrs.size();
            }
        }
        return maxLen;
    }


    private static  void test() {
        String str = "aab";
//        String str = "abcdefghijk";
//        String str = "abcabcbb";
//        String str = "eeeabdfcbcbb";
//        String str = "ohvhjdml";
//        int maxLen = lengthOfLongestSubstring(str);
//        int maxLen = lengthOfLongestSubstring2(str);
        ////        System.out.println(maxLen);

        lengthOfLongestSubstring("aab");
        lengthOfLongestSubstring("abcdefghijk");
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("eeeabdfcbcbb");
        lengthOfLongestSubstring("ohvhjdml");
        lengthOfLongestSubstring("aaaaaaaa");
        lengthOfLongestSubstring(" ");
        lengthOfLongestSubstring("");



    }
}
