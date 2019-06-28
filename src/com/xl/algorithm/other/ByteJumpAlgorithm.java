package com.xl.algorithm.other;

import java.util.Random;

public class ByteJumpAlgorithm {

    private static Random random = new Random(75);

    public static void main(String[] args) {
        boolean isReachable = isReachable();
        println("");
        if (isReachable) {
            println("台阶可达");
        } else {
            println("台阶不可达");
        }
    }


    /**
     * 算法描述：
     *     有n个台阶，每个台阶有个非负值，当走到某台阶i(值为Vi >=0)时，那么最多只能走Vi步，如果当前台阶值为零，则不可达下个台阶。
     *     判断从第一个台阶出发到最后一个台阶，是否可达。并找出跨步次数最少的走法。
     *
     *
     * 思路：
     *    在台阶i时，下一步，只用选择(i, i+ Vi]台阶中，相对Vi值最大的台阶即可。(注意这里的相对，相对值最大的台阶，下一步才能走的更远)
     *    假设当前在台阶i，如果Vi值为零，则不可达。如果大于零，其下个台阶只能走[1, Vi]步，那么他下个台阶应该选择满足如下条件的：
     *       假设下个台阶选择的是j，那么Vj必须满足，Vj = max { Vj + j-i}
     *
     */
    public static boolean isReachable() {
        /**
         * 值初始化
          */
        int[] values = new int[10];
        for (int i = 0; i < values.length; i++) {
            values[i] = Math.abs(random.nextInt(10)) % 5;
        }

        printArray(values);

        print("步数最少走法： ");
        for (int i = 0; i < values.length; ) {
            int max = values[i];
            int temp = 0;
            int loc = i + values[i] >= values.length ? values.length -1 : i + values[i];
            for (int j = i + 1; j <= i + values[i] && j < values.length; j++) {
                if (values[j] == 0) {
                    continue;
                }
                temp = values[j] + j - i;
                if (temp > max) {
                    max = temp;
                    loc = j;
                }
            }

            i = loc;
            print(loc+ " ");
            //到达终点
            if (i == values.length - 1) {
                return true;
            }
        }

        return true;
    }

    private static void println(Object obj) {
        System.out.println(obj);
    }

    private static void print(Object obj) {
        System.out.print(obj);
    }

    private static void printArray(int[] a) {
        print("[");
        for (int i = 0; i < a.length; i++) {
            print(a[i] + " ");
        }
        println("]");
    }

}




























