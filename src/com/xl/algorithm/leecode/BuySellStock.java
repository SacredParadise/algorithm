package com.xl.algorithm.leecode;

import java.util.stream.StreamSupport;

/**
 * 买卖股票的最佳时机(动态规划)
 * 递归解法见如下链接，git上的比较坑，没讲清楚
 *  https://www.jianshu.com/p/9fa0faff99da
 *
 *
 * 股票买卖这一类的问题，都是给一个输入数组，里面的每个元素表示的是每天的股价，并且你只能持有一支股票
 * （也就是你必须在再次购买前出售掉之前的股票），一般来说有下面几种问法：
 *
 * 只能买卖一次
 * 可以买卖无数次
 * 可以买卖 k 次
 * 需要你设计一个算法去获取最大的利润。
 */
public class BuySellStock {

    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        int[] arr2 = { 7, 6, 4, 3, 1 };
        int[] arr3 = { 1, 2, 3, 4, 5 };
        int[] arr4 = { 3, 3, 5, 0, 0, 3, 1, 4 };

//        System.out.println(sell1(arr));
//        System.out.println(sell1(arr2));
//
//        System.out.println();
//
//        System.out.println(sellN(arr));
//        System.out.println(sellN(arr2));
//        System.out.println(sellN(arr3));
//        System.out.println(sellN(arr4));
//
//        System.out.println();
//
//        System.out.println(sellN2(arr));
//        System.out.println(sellN2(arr2));
//        System.out.println(sellN2(arr3));
//        System.out.println(sellN2(arr4));
//
//        System.out.println();

        System.out.println(sellK(arr));
        System.out.println(sellK(arr2));
        System.out.println(sellK(arr3));
        System.out.println(sellK(arr4));

    }

    /**
     * 买卖股票的最佳时机 I
     *
     * 题目描述
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意你不能在买入股票前卖出股票。
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * 题目解析
     * 我们按照动态规划的思想来思考这道问题。
     *
     * 状态
     * 有 买入（buy） 和 卖出（sell） 这两种状态。
     *
     * 转移方程
     * 对于买来说，买之后可以卖出（进入卖状态），也可以不再进行股票交易（保持买状态）。
     *
     * 对于卖来说，卖出股票后不在进行股票交易（还在卖状态）。
     *
     * 只有在手上的钱才算钱，手上的钱购买当天的股票后相当于亏损。也就是说当天买的话意味着损失-prices[i]，当天卖的话意味着增加prices[i]，当天卖出总的收益就是 buy+prices[i] 。
     *
     * 所以我们只要考虑当天买和之前买哪个收益更高，当天卖和之前卖哪个收益更高。
     *
     * buy = max(buy, -price[i]) （注意：根据定义 buy 是负数）
     * sell = max(sell, prices[i] + buy)
     * 边界
     * 第一天 buy = -prices[0], sell = 0，最后返回 sell 即可。
     */
    private static int sell1(int[] arr) {
        int buy = -arr[0];
        int sell = 0;

        for (int i = 1; i < arr.length; i++) {
            sell = max(sell, buy + arr[i]);
            buy = max(buy, -arr[i]);
        }

        return sell;
    }

    private static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * 买卖股票的最佳时机 II
     * 题目来源于 LeetCode 上第 122 号问题：买卖股票的最佳时机 II。题目难度为 Easy，目前通过率为 53.0% 。
     *
     * 题目描述
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * 题目解析
     * 状态
     * 有 买入（buy） 和 卖出（sell） 这两种状态。
     *
     * 转移方程
     * 对比上题，这里可以有无限次的买入和卖出，也就是说 买入 状态之前可拥有 卖出 状态，所以买入的转移方程需要变化。
     *
     * buy = max(buy, sell - price[i])
     * sell = max(sell, buy + prices[i] )
     * 边界
     * 第一天 buy = -prices[0], sell = 0，最后返回 sell 即可。
     *
     *
     * @return
     */
    private static int sellN(int[] arr) {
        int sell = 0;
        int buy = -arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > -buy) {
                sell += arr[i] + buy;
            }
            buy = -arr[i];
        }

        return sell;
    }

    private static int sellN2(int[] arr) {
        int sell = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                sell += arr[i] - arr[i - 1];
            }
        }

        return sell;
    }

    public static int sellN3(int[] prices) {
        if (prices.length <= 1) return 0;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, prices[i] + buy);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }


    /**
     * 买卖股票的最佳时机 III
     * 题目来源于 LeetCode 上第 123 号问题：买卖股票的最佳时机 III。题目难度为 Hard，目前通过率为 36.1% 。
     *
     * 题目描述
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     * 题目解析
     * 这里限制了最多两笔交易。
     *
     * 状态
     * 有 第一次买入（fstBuy） 、 第一次卖出（fstSell）、第二次买入（secBuy） 和 第二次卖出（secSell） 这四种状态。
     *
     * 转移方程
     * 这里最多两次买入和两次卖出，也就是说 买入 状态之前可拥有 卖出 状态，卖出 状态之前可拥有 买入 状态，所以买入和卖出的转移方程都需要变化。
     *
     * fstBuy = max(fstBuy ， -price[i])
     * fstSell = max(fstSell，fstBuy + prices[i] )
     * secBuy = max(secBuy ，fstSell -price[i]) (受第一次卖出状态的影响)
     * secSell = max(secSell ，secBuy + prices[i] )
     * 边界
     * 一开始 fstBuy = -prices[0]
     *
     * 买入后直接卖出，fstSell = 0
     *
     * 买入后再卖出再买入，secBuy - prices[0]
     *
     * 买入后再卖出再买入再卖出，secSell = 0
     *
     * 最后返回 secSell 。
     * @return
     */
    private static int sellK(int[] arr) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int i = 0; i < arr.length; i++) {
            firstBuy = max(firstBuy, -arr[i]);
            firstSell = max(firstSell, firstBuy + arr[i]);
            secondBuy = max(secondBuy, firstSell - arr[i]);
            secondSell = max(secondSell, secondBuy + arr[i]);
        }


        return secondSell;
    }

}
