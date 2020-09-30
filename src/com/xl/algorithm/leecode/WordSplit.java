package com.xl.algorithm.leecode;

import java.util.List;

/**
 * 单词拆分
 *
 * 题目来源于 LeetCode 第 139 号问题：单词拆分。
 *
 * 题目描述
 *     给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 *      拆分时可以重复使用字典中的单词。
 *
 *      你可以假设字典中没有重复的单词。
 *
 * 题目解析
 *      与上面的第二题 分割回文串 有些类似，都是拆分，但是如果此题采取 深度优先搜索 的方法来解决的话，答案是超时的，不信的同学可以试一下~
 *
 *      为什么会超时呢？
 *
 *      因为使用 深度优先搜索 会重复的计算了有些位的可拆分情况，这种情况的优化肯定是需要 动态规划 来处理的。
 *
 *      如果不知道动态规划的，可以看一下小吴之前的万字长文，比较详细的介绍了动态规划的概念。
 *
 *      在这里，只需要去定义一个数组 boolean[] memo，其中第 i 位 memo[i] 表示待拆分字符串从第 0 位到第 i-1 位是否可以被成功地拆分。
 *
 *      然后分别计算每一位是否可以被成功地拆分。
 */
public class WordSplit {

    public static void main(String[] args) {

    }

    public static boolean wordSplit(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        int maxWordLen = 0;
        int minWordLen = Integer.MAX_VALUE;
        for (String word : wordDict) {
            maxWordLen = maxWordLen < word.length() ? word.length() : maxWordLen;
            minWordLen = minWordLen > word.length() ? word.length() : maxWordLen;
        }

        boolean[] memo = new boolean[s.length()];

        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= 0 && maxWordLen > i - j; j--) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[s.length()];
    }






}
