package com.xl.algorithm.leecode;

/**
 * 题目描述：
 * trapping-rain-water:
 *  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example：
 *     Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 *     Output: 6
 *
 *  解法参考：
 *     https://blog.csdn.net/weixin_40564421/article/details/79049100  (解法比后者清晰)
 *     https://github.com/SacredParadise/leetcode/blob/master/problems/42.trapping-rain-water.md
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; //结果为6
        trappingRainWater(height);


        trappingRainWater2();

    }

    /**
     * 根据海拔从下到上累加每层能积的水量
     */
    private static void trappingRainWater(int[] height) {

        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
            }
        }

        int rains = 0;
        for (int i = 0; i < maxHeight; i++) {
            //从左开始，去掉height为零的，这些无法积累雨水
            int start = 0;
            for (; start < height.length; start++) {
                if (height[start] > 0) {
                    break;
                }
            }

            //从右开始，去掉height为零的，这些无法积累雨水
            int end = height.length - 1;
            for (; end > start; end--) {
                if (height[end] > 0) {
                    break;
                }
            }

            for (int j = start; j < end; j++) {
                if (height[j] == 0) {
                    rains++;
                }
            }

            for (int j = 0; j < height.length; j++) {
                if (height[j] != 0) {
                    height[j] = height[j] - 1;
                }
            }
        }
        System.out.println(rains);
    }

    /**
     * 该实现有点问题
     *  https://github.com/SacredParadise/leetcode/blob/master/problems/42.trapping-rain-water.md
     */
    private static void trappingRainWater2() {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; //结果为6

        int max = 0;
        int volumn = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
            leftMax[i] = max;
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            rightMax[i] = max;
        }

        for (int i = 0; i < height.length; i++) {
            volumn += Math.min(leftMax[i], rightMax[i] - height[i]);
        }

        System.out.println(volumn);
    }



}
