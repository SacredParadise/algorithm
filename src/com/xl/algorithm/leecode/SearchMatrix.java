package com.xl.algorithm.leecode;

/**
 * 搜索二维矩阵
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                { 1,  4,   7, 11, 15 },
                { 2,  5,   8, 12, 19 },
                { 3,  6,   9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };


        System.out.println(searchMatrix(arr, 15));
        System.out.println(searchMatrix(arr, 5));
        System.out.println(searchMatrix(arr, 20));
    }

    /**
     * 解题思路：
     *     从最后一行开始。从左往右找第一个大于value的列位置j
     *                   继续从次行，从j位置开始从左往右找第一个大于value的位置，以此类推
     *
     * @param value
     * @return
     */
    private static boolean searchMatrix(int[][] arr, int value) {


        int loc = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = loc; j < arr[0].length; j++) {  //注，如果这里用arr[j].length,当j为length - 1时，for循环j++=length，for的第二个判断条件会抛数组越界异常
                if (arr[i][j] > value) {
                    loc = j;
                    break;
                } else if (arr[i][j] == value) {
                    System.out.println(
                            new StringBuilder("value ").append(value).append(" (i, j) = (").append(i).append(", ")
                                    .append(j).append(")").toString());
                    return true;
                }
            }
        }

        return false;
    }

}

