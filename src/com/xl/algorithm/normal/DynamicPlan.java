package com.xl.algorithm.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态规划算法
 */
public class DynamicPlan {


    /**
     * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。
     * 每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
     */
    static class GoldMining {
        //存储每座金矿的数值
        final int[] goldValues;
        //存储每座金矿所需工人数
        final int[] goldWorkNums;
        //工人总数
        final int workerNum;

        //计算次数
        int calTimes = 0;

        GoldMining(int[] goldValues, int[] goldWorkNums, int workerNum) {
            this.goldValues = goldValues;
            this.goldWorkNums = goldWorkNums;
            this.workerNum = workerNum;
        }

        /**
         * 递归实现
         * @param n 金矿数
         * @param w 工人数
         * @return
         */
        int recursive(int n, int w) {
            calTimes++;

            if (n == 1) {
                if (goldWorkNums[n - 1] > w) {
                    return 0;
                } else {
                    return goldValues[n - 1];
                }
            }

            if (goldWorkNums[n - 1] > w) {
                return recursive(n - 1, w);
            }

            return max(recursive(n - 1, w), recursive(n - 1, w - goldWorkNums[n - 1]) + goldValues[n - 1]);
        }

        int memo(int n, int w, Map<String, Integer> memoMap) {
            calTimes++;
            if (n == 1) {
                if (goldWorkNums[n - 1] > w) {
                    memoMap.put(getKey(n, w), 0);
                    return 0;
                } else {
                    memoMap.put(getKey(n, w), goldValues[n - 1]);
                    return goldValues[n - 1];
                }
            }

            if (goldWorkNums[n - 1] > w) {
                String key = getKey(n - 1, w);
                Integer temp = memoMap.get(memoMap.get(key));
                if (temp != null) {
                    return temp;
                } else {
                    int value = recursive(n - 1, w);
                    memoMap.put(key, value);
                    return value;
                }
            }

            String key1 = getKey(n - 1, w);
            String key2 = getKey(n - 1, w - goldWorkNums[n - 1]);
            Integer val1 = memoMap.get(key1);
            Integer val2 = memoMap.get(key2);
            if (val1 == null) {
                val1 = recursive(n - 1, w);
                memoMap.put(key1, val1);
            }

            if (val2 == null) {
                val2 = recursive(n - 1, w - goldWorkNums[n - 1]);
                memoMap.put(key2, val2);
            }
            val2 += goldValues[n - 1];

            int maxValue = max(val1, val2);
            memoMap.put(getKey(n, w), maxValue);

            return maxValue;
        }

        /**
         * 该实现参考网上的 结果不对~~
         * @param n
         * @param w
         * @return
         */
        int optimal(int n, int w) {
            int[] preResult = new int[w];
            int[] result = new int[w];

            for (int i = 0; i < w; i++) {
                if (i < goldWorkNums[0]) {
                    preResult[i] = 0;
                } else {
                    preResult[i] = goldValues[0];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < w; j++) {
                    if (j < goldWorkNums[i]) {
                        result[j] = preResult[j];
                    } else {
                        result[j] = max(preResult[j], preResult[j - goldWorkNums[i]] + goldValues[i]);
                    }
                }

                preResult = result;
            }

            return result[n];
        }

        private final String getKey(int n, int w) {
            return new StringBuilder(n).append(",").append(w).toString();
        }
    }

    private static final int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }


    public static void main(String[] args) {
        goldTest();
    }

    public static void goldTest() {
        int[] goldValues = {500, 200, 300, 350, 400};
        int[] goldWorkNums = {5, 3, 4, 3, 5};
        int workNum = 10;
        Map<String, Integer> memoMap = new HashMap<>();
        GoldMining goldMining = new GoldMining(goldValues, goldWorkNums, workNum);
        println("recursiveResult= " + goldMining.recursive(5, 10));
        println("recursive calTimes= " + goldMining.calTimes);
        goldMining.calTimes = 0;

        println("memoResult= " + goldMining.memo(5, 10, memoMap));
        println("memo calTimes= " + goldMining.calTimes);


        println("optimalResult= " + goldMining.optimal(5, 10));
    }


    public static void println(Object o) {
        System.out.println(o);
    }


}







































