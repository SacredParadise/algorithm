package com.xl.algorithm.leecode;

import java.util.*;

/**
 *
 * leecoode code
 *
 */
public class Algorithms {
    public static void main(String[] args) {
//        LongestPalindrome.test();

//        NumReverse.test();

//        Atoi.test();

//        PalindromeNum.test();

//        MaxArea.test();


//        LongestCommonPrefix.test();

//        ThreeSum.test();

//        ThreeSumClosest.test();

        ValidBrackets.test();

    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        //用类似堆栈思想实现，遍历找到第一个右括号，然后往前遍历，第一个左括号匹配则为真，否则假
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i]) {
                stack[index++] = ')';
            } else if ('[' == chars[i]) {
                stack[index++] = ']';
            } else if ('{' == chars[i]) {
                stack[index++] = '}';
            } else {
                if (stack[--index] != chars[i]) {
                    return false;
                }
            }
        }
        if (index > 0) {
            return false;
        }

        return true;
    }



    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     * 输入: "()"
     * 输出: true
     *
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     *
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     *
     * 示例 4:
     * 输入: "([)]"
     * 输出: false
     *
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true
     */
    static class ValidBrackets {
        public static void test() {
            System.out.println(isValid("()"));
            System.out.println(isValid("()[]{}"));
            System.out.println(isValid("(]"));
            System.out.println(isValid("([)]"));
            System.out.println(isValid("{[]}"));
        }

        public static boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            //用类似堆栈思想实现，遍历找到第一个右括号，然后往前遍历，第一个左括号匹配则为真，否则假
            char[] chars = s.toCharArray();
            char[] stack = new char[chars.length];
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                if ('(' == chars[i]) {
                    stack[index++] = ')';
                } else if ('[' == chars[i]) {
                    stack[index++] = ']';
                } else if ('{' == chars[i]) {
                    stack[index++] = '}';
                } else {
                    if (stack[--index] != chars[i]) {
                        return false;
                    }
                }
            }
            if (index > 0) {
                return false;
            }

            return true;
        }

//        /**
//         * 判断a和b是否匹配的括号
//         * a左括号，b 右括号
//         */
//        private static boolean isBracketMatch(char a, char b) {
//            if (a == '(' && b == ')') {
//                return true;
//            } else if (a == '{' && b == '}') {
//                return true;
//            } else if (a == '[' && b == ']') {
//                return true;
//            } else {
//                return false;
//            }
//        }

    }


    /**
     * 16. 最接近的三数之和
     *
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1, 2, 1, -4], 和 target = 1.
     *
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    static class ThreeSumClosest{

        public static void test() {
//            System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
//            System.out.println(threeSumClosest(new int[] {-4, -1, 1, 2}, 1));
//            System.out.println(threeSumClosest(new int[] {-4, -2, -1, 0, 1, 2}, 0));
//            System.out.println(threeSumClosest(new int[] {-8, -6, -4, 0, 3, 4}, 3));
//            System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 1));   // 2
//            System.out.println(threeSumClosest(new int[] {-4, -1, 1, 2}, 1));   // 2
//            System.out.println(threeSumClosest(new int[] {-3,-2,-5,3,-4}, -1));   // -2
//            System.out.println(threeSumClosest(new int[] {-1,0,1,1,55}, 3));   // 2
            System.out.println(threeSumClosest(new int[] {13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6}, -59));   // -58

        }

        public int threeSumClosest2(int[] nums, int target) {
            //优化
            Arrays.sort( nums );
            int res = Integer.MAX_VALUE , min_diff = Integer.MAX_VALUE ;
            int left , right , sum , tmp;
            for( int i = 0 ; i < nums.length - 2 ; i++ ){
                left = i + 1 ; //左指针 nums[ left ]
                right = nums.length - 1;//右指针 nums[ right ]
                int min = nums[ i ] + nums[ left ] + nums[ left + 1 ];
                int max = nums[ i ] + nums[ right ] + nums[ right - 1 ];
                if( min > target ){//如果当前能扫描到的最小值都大于target就没必要扫描了
                    tmp = min - target;
                    if( tmp < min_diff ){
                        min_diff = tmp;
                        res = min;
                    }
                }else if( max < target ){//如果当前能扫描到的最大值都小于target就没必要扫描了
                    tmp = target - max;
                    if( tmp < min_diff ){//注意正负符号
                        min_diff = tmp;
                        res = max;
                    }
                }else{
                    while( left < right ){
                        sum = nums[ i ] + nums[ left ] + nums[ right ];
                        if( sum < target ){//target 比 sum 大
                            left++;//左指针右移动
                        }else if( sum > target ){
                            right--;//右指针左移
                        }else{
                            return sum;
                        }
                        tmp = sum < target ? target - sum : sum - target;
                        if( tmp < min_diff ){
                            min_diff = tmp;
                            res = sum;
                        }
                    }
                }

            }
            return res;
        }

        public static int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }

            Arrays.sort(nums);
            int n = nums.length;
            int j = 0;
            int k = 0;
            int sum = 0;
            int dis = 0;
            int min = 0;
            int max = 0;
            int minDiff = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 0; i < n - 2; i++) {
                j = i + 1;
                k = n - 1;
                //增加判断，如果序列最大值都大于target 或者最小值小于target，则无需继续遍历，
                max = nums[i] + nums[k] + nums[k - 1];
                if (max < target) {
                    dis = target - max;
                    if (dis < minDiff) {
                        minDiff = dis;
                        result = max;
                    }
                    continue;
                }

                min = nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    dis = min - target;
                    if (dis < minDiff) {
                        minDiff = dis;
                        result = min;
                    }
                    continue;
                }

                while (j < k) {
                    sum = nums[i] + nums[j] + nums[k];
                    dis = target - sum;
                    if (dis == 0) {
                        return target;
                    }

                    if (dis > 0) {
                        j++;
                    } else {
                        dis = -dis;
                        k--;
                    }

                    if (dis < minDiff) {
                        minDiff = dis;
                        result = sum;
                    }
                }
            }

            return result;
        }

        public int threeSumClosest3(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }

            Arrays.sort(nums);
            int n = nums.length;
            int result = nums[0] + nums[1] + nums[2];
            int j = 0;
            int k = 0;
            int temp = 0;
            int dis = 0;
            for (int i = 0; i < n; i++) {
                j = i + 1;
                k = n - 1;
                temp = target - nums[i];
                while (j < k) {
                    dis = temp - nums[j] - nums[k];
                    if (dis == 0) {
                        return target;
                    }

                    if (dis > 0) {
                        j++;
                    } else {
                        k--;
                    }

                    if (Math.abs(dis) < Math.abs(target - result)) {
                        result = target - dis;
                    }
                }
            }

            return result;

        }

    }



    /**
     * 15. 三数之和
     *
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     */
    static class ThreeSum {
        public static void test() {
            System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
            System.out.println(threeSum(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));   // [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]

            System.out.println(threeSum(new int[] {-4, -1, -1, 0, 1, 2}));
        }

        public static List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return new ArrayList<>(0);
            }

            List<List<Integer>> result = new ArrayList<>(nums.length);
            Arrays.sort(nums);

            int j = 0;
            int k = 0;
            int target = 0;
            int sum = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {   // skip the same element
                    continue;
                }

                target = -nums[i];
                j = i + 1;
                k = nums.length - 1;
                while (j < k) {   //to find the two element,their sum is equal minus nums[i]
                    sum = nums[j] + nums[k];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (nums[j] == nums[j - 1] && j < k) {
                            j++;
                            continue;
                        }
                        while (j < k && nums[k] == nums[k + 1] ) {
                            k--;
                            continue;
                        }
                    } else if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }

            return result;
        }


        public static List<List<Integer>> threeSum2(int[] nums) {
            if (nums.length < 3) {
                return Collections.emptyList();
            }
            List<List<Integer>> res = new ArrayList<>();
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;
            int negSize = 0;
            int posSize = 0;
            int zeroSize = 0;
            for (int v : nums) {
                if (v < minValue) {
                    minValue = v;
                }
                if (v > maxValue) {
                    maxValue = v;
                }
                if (v > 0) {
                    posSize++;
                } else if (v < 0) {
                    negSize++;
                } else {
                    zeroSize++;
                }
            }
            if (zeroSize >= 3) {
                res.add(Arrays.asList(0, 0, 0));
            }
            if (negSize == 0 || posSize == 0) {
                return res;
            }
            if (minValue * 2 + maxValue > 0) {
                maxValue = -minValue * 2;
            } else if (maxValue * 2 + minValue < 0) {
                minValue = -maxValue * 2;
            }

            int[] map = new int[maxValue - minValue + 1];
            int[] negs = new int[negSize];
            int[] poses = new int[posSize];
            negSize = 0;
            posSize = 0;
            for (int v : nums) {
                if (v >= minValue && v <= maxValue) {
                    if (map[v - minValue]++ == 0) {
                        if (v > 0) {
                            poses[posSize++] = v;
                        } else if (v < 0) {
                            negs[negSize++] = v;
                        }
                    }
                }
            }
            Arrays.sort(poses, 0, posSize);
            Arrays.sort(negs, 0, negSize);
            int basej = 0;
            for (int i = negSize - 1; i >= 0; i--) {
                int nv = negs[i];
                int minp = (-nv) >>> 1;
                while (basej < posSize && poses[basej] < minp) {
                    basej++;
                }
                for (int j = basej; j < posSize; j++) {
                    int pv = poses[j];
                    int cv = 0 - nv - pv;
                    if (cv >= nv && cv <= pv) {
                        if (cv == nv) {
                            if (map[nv - minValue] > 1) {
                                res.add(Arrays.asList(nv, nv, pv));
                            }
                        } else if (cv == pv) {
                            if (map[pv - minValue] > 1) {
                                res.add(Arrays.asList(nv, pv, pv));
                            }
                        } else {
                            if (map[cv - minValue] > 0) {
                                res.add(Arrays.asList(nv, cv, pv));
                            }
                        }
                    } else if (cv < nv) {
                        break;
                    }
                }
            }
            return res;
        }
    }


    /**
     * 14. 最长公共子串
     *  编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     */
    static class LongestCommonPrefix {
        public static void test() {
            System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
            System.out.println(longestCommonPrefix(new String[] {"floer","floe","floeht","floeht","floeht","floeht","floeht","floeht","floeht","floeht","floehtdddddd", "floehtddddddwwwwwwwwwwwwwww"}));
            System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
            System.out.println(longestCommonPrefix(new String[] {"aa","a"}));

            long startT = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                longestCommonPrefix(
                        new String[] { "floer", "floe", "floeht", "floeht", "floeht", "floeht", "floeht", "floeht",
                                "floeht", "floeht", "floehtdddddd", "floehtddddddwwwwwwwwwwwwwww" });
            }
            System.out.println("Time cost " + (System.currentTimeMillis() - startT));
            startT = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                longestCommonPrefix3(
                        new String[] { "floer", "floe", "floeht", "floeht", "floeht", "floeht", "floeht", "floeht",
                                "floeht", "floeht", "floehtdddddd", "floehtddddddwwwwwwwwwwwwwww" });
            }
            System.out.println("Time cost " + (System.currentTimeMillis() - startT));
        }

        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String common = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(common) != 0) {
                    common = common.substring(0, common.length() - 1);
                }
            }
            return common;
        }


        public static String longestCommonPrefix3(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            StringBuilder common = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                        return common.toString();
                    }
                }
                common.append(strs[0].charAt(i));
            }
            return common.toString();
        }

        public static String longestCommonPrefix2(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            //找出strs最小长度
            int minLen = Integer.MAX_VALUE;
            for (String str : strs) {
                minLen = minLen > str.length() ? str.length() : minLen;
            }

            //将字符串进行拼接，大于minLen的去掉
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str, 0, minLen);
            }

            char[] chars = sb.toString().toCharArray();
            StringBuilder common = new StringBuilder();
            int j = 0;
            int index = 0;
            boolean equal = true;
            for (int i = 0; i < minLen; i++) {
                j = 1;
                equal = true;
                while (j < strs.length) {
                    index = j * minLen + i;
                    if (chars[i] != chars[index]) {
                        equal = false;
                        break;
                    }
                    j++;
                }
                if (equal) {
                    common.append(chars[i]);
                } else {
                    break;
                }
            }

            return common.toString();
        }


    }






    /**
     * 11. 盛最多水的容器
     *
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     *
     */
    static class MaxArea {
        public static void test() {
            println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
            println(maxArea(new int[] { 1, 1 }));
            println(maxArea(new int[] { 8,10,14,0,13,10,9,9,11,11 }));
        }

        /**
         * 分别从首尾开始遍历(两边游标相遇时停止)
         * 首尾那边height低，则下标向前或者向后移一位。
         * 分别求得面积值，取最大值为结果
         */
        public static int maxArea(int[] height) {
            int max = 0;
            int area = 0;
            for (int i =0, j = height.length - 1; i < j;) {
                if (height[i] <= height[j]) {
                    area = height[i] * (j - i);
                    i++;
                } else {
                    area = height[j] * (j - i);
                    j--;
                }
                max = max < area ? area : max;
            }

            return max;
        }



//        public static int maxArea(int[] height) {
//            int max=0;
//            for(int i=0,j=height.length-1;i<j;){
//                int product;
//                if(height[i]<=height[j]){
//                    product=height[i]*(j-i);
//                    i++;
//                }else{
//                    product=height[j]*(j-i);
//                    j--;
//                }
//                if(product>max){
//                    max=product;
//                }
//            }
//            return max;
//        }

        /**
         * 从Y轴往下切，找最大距离的两个x轴，则为该Y轴值最大容量
         */
        public static int maxArea3(int[] height) {
            int n = height.length;
            int maxY = 0;
            int i = 0;
            for (i = 0; i < n; i++) {
                maxY = maxY < height[i] ? height[i] : maxY;
            }
            int[] maxYX = new int[maxY + 1];  //保存以Y轴值为单位的最小X轴值
            int[] minYX = new int[maxY + 1];  //保存以Y轴值为单位的最大X轴值
            for (i = 1; i <= maxY; i++) {
                minYX[i] = Integer.MAX_VALUE;
            }

            int y = 0;
            for (i = 0; i < n; ) {
                y = height[i];
                i++;
                if (i > maxYX[y]) {
                    maxYX[y] = i;
                }

                if (i < minYX[y]) {
                    minYX[y] = i;
                }
            }

            int minX = Integer.MAX_VALUE;
            int maxX = 0;
            int max = 0;
            int v = 0;
            for (i = maxY; i > 0; i--) {
                if (minYX[i] == 0 && maxYX[i] == 0) {
                    continue;
                }
                maxX = Math.max(maxX, maxYX[i]);
                if (minYX[i] != 0) {
                    minX = Math.min(minX, minYX[i]);
                }

                v = (maxX - minX) * i;
                max = max < v ? v : max;
            }

            return max;
        }

        /**
         * 暴力法
         */
        public static int maxArea2(int[] height) {
            int n = height.length;
            int[][] volume = new int[n][n];
            int max = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    volume[i][j] = Math.abs(Math.min(height[i], height[j]) * (j - i));
                    if (max < volume[i][j]) {
                        max = volume[i][j];
                    }
                }
            }

            return max;
        }


    }

    public static int maxArea2(int[] height) {
        int n = height.length;
        int[][] volume = new int[n][n];
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) {
                    continue;
                }
                volume[i][j] = Math.abs(Math.min(height[i], height[j]) * (j - i));
                if (max < volume[i][j]) {
                    max = volume[i][j];
                }
            }
        }

        return max;
    }

    /**
     * 9. 回文数
     *
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     *
     * 你能不将整数转为字符串来解决这个问题吗？
     */
    static class PalindromeNum {

        public static void test() {
            System.out.println(String.valueOf(isPalindrome(121)));
            System.out.println(String.valueOf(isPalindrome(-121)));
            System.out.println(String.valueOf(isPalindrome(10)));

        }

        public static boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int[] digits = new int[10];
            int i = -1;
            while (x != 0) {
                i++;
                digits[i] = x % 10;
                x = x / 10;
            }

            int j = 0;
            while (j < i) {
                if (digits[j] != digits[i]) {
                    return false;
                }
                j++;
                i--;
            }

            return true;
        }

        public static boolean isPalindrome2(int x) {
            if (x < 0) {
                return false;
            }

            //找到x的最大位数
            int div = 1;
            while (x / div > 10) {
                div *= 10;
            }

            int left = 0;
            int right = 0;
            while (x > 0) {
                left = x % 10;
                right = x / div;
                if (left != right) {
                    return false;
                }
                x = (x % 10) / 10;
                div /= 100;

            }

            return true;
        }



    }


    /**
     * 8. 字符串转换整数 (atoi)
     *
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     *
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     *
     * 说明：
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
     *
     * 示例 1:
     *
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     *
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     *
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     *
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     * 示例 5:
     *
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−2^31) 。
     */
    static class Atoi {
        public static void test() {
            System.out.println(String.valueOf(myAtoi("+1")));
            System.out.println(String.valueOf(myAtoi("+")));
            System.out.println(String.valueOf(myAtoi("1")));
            System.out.println(String.valueOf(myAtoi("-")));
            System.out.println(String.valueOf(myAtoi("42")));
            System.out.println(String.valueOf(myAtoi("-42")));
            System.out.println(String.valueOf(myAtoi("4193 with words")));
            System.out.println(String.valueOf(myAtoi("    4193 with words")));
            System.out.println(String.valueOf(myAtoi("    -4193 with words")));
            System.out.println(String.valueOf(myAtoi("words and 987")));
            System.out.println(String.valueOf(myAtoi("-91283472332")));
            System.out.println(String.valueOf(myAtoi("  0000000000012345678")));
            System.out.println(String.valueOf(myAtoi(" ")));
        }


        public static int myAtoi(String str) {
            char[] chars = str.toCharArray();
            int result = 0;
            int i = 0;
            int sign = 1;
            //去掉全面的空格
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }

            if (i == chars.length) {
                return 0;
            }

            int digit = chars[i] - '0';
            //判断起始是否为数字或者负号或者正号
            if (digit < 0 || digit > 9) {
                if (chars[i] == '-') {
                    sign = -1;
                    i++;
                } else if (chars[i] == '+') {
                    i++;
                } else {
                    return 0;
                }
            }

//            //过滤掉前面的零
//            while (index < chars.length && chars[index] == '0') {
//                index++;
//                continue;
//            }

            int maxResult = Integer.MAX_VALUE / 10;
            int maxDigit = Integer.MAX_VALUE % 10;
            while (i < chars.length) {
                digit = chars[i] - '0';
                if (digit < 0 || digit > 9) {
                    break;
                }
                if (result > maxResult || (result == maxResult && digit > maxDigit)) {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                result = result * 10 + digit;
                i++;
            }

            return result * sign;
        }

        public int myAtoi2(String str) {
            if(str.isEmpty()) return 0;
            char[] mychar=str.toCharArray();
            long ans=0;
            int i=0,sign=1,n=str.length();
            while(i<n&&mychar[i]==' ') {
                i++;
            }
            if(i < n &&mychar[i]=='+') {
                i++;
            }
            else if(i < n &&mychar[i]=='-') {
                i++;
                sign =-1;
            }
            //重点：只管是数字的时候，其余取0
            while(i<n&&(mychar[i]>='0'&&mychar[i]<='9')) {
                if(ans!=(int)ans) {
                    return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                ans=ans*10+mychar[i++]-'0';
            }

            if(ans!=(int)ans) {
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            return (int)(ans*sign);
        }



    }




    /**
     * 7. 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */
    static class NumReverse {
        public static void test() {
            println(reverse(123));
            println(reverse(-123));
            println(reverse(120));
            println(reverse(1534236469));

            println("");
            println("");

            println(reverse2(123));
            println(reverse2(-123));
            println(reverse2(120));
            println(reverse2(1534236469));

        }

        public static int reverse(int x) {
            int intMax = 0x7fffffff;
            int intMin = 0x80000000;
            long result = 0L;

            while (x != 0) {
                result = result * 10 +  x % 10;
                x = x / 10;
            }

            if (result > intMax || result < intMin) {
                result = 0;
            }

            return (int)result;
        }

        public static int reverse2(int x) {
            int rev = 0;
            while(x != 0) {
                int pop = x % 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                    return 0;
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                    return 0;
                rev = rev * 10 + pop;
                x /= 10;
            }
            return rev;
        }


        public static int reverse3(int x) {
            String s = String.valueOf(x);
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean isFirst = true;
            for (int i = chars.length - 1; i >= 1; i--) {
                if (isFirst && chars[i] == '0') {
                    continue;
                } else {
                    sb.append(chars[i]);
                }
            }
            if (chars[0] == '-') {
                sb.insert(0, '-');
            } else {
                sb.append(chars[0]);
            }

            return Integer.valueOf(sb.toString());
        }
    }

    /**
     * 5. 最大回文长度
     *
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     * 输入: "babad"  "bababd"  "bababba"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */
    static class LongestPalindrome {
        static void test() {
            String testStr = "dsfsdhadhfkdsdsfsdhadhdsfsdhadhfkddsfsdhadhfkdsahfksadhdsfsdhadhfkdsahfksadhfksddsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskdfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskfdsfsdhadhfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhsksahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskfkdsahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhskahfksadhfksdhfusdihfksjadfhksadjkdsahfdsjkhfksdhffhiawoeuruihweiyrtiuoncsdbfzmbfkhfioaewncfhsk";
            println(longestPalindrome("babad"));
            println(longestPalindrome("bababd"));
            println(longestPalindrome("cbbd"));
            println(longestPalindrome("ab"));
            println(longestPalindrome("cbbd"));
            println(longestPalindrome(""));
            println(longestPalindrome(testStr));

            println("");
            println("");

            println(longestPalindrome_dynamic("babad"));
            println(longestPalindrome_dynamic("bababd"));
            println(longestPalindrome_dynamic("cbbd"));
            println(longestPalindrome_dynamic("ab"));
            println(longestPalindrome_dynamic("cbbd"));
            println(longestPalindrome_dynamic(""));
            println(longestPalindrome_dynamic(testStr));
            println("");
            println("");

            println(longestPalindrome_center("babad"));
            println(longestPalindrome_center("bababd"));
            println(longestPalindrome_center("cbbd"));
            println(longestPalindrome_center("ab"));
            println(longestPalindrome_center("cbbd"));
            println(longestPalindrome_center(""));
            println(longestPalindrome_center(testStr));
            println("");
            println("");

            println(longestPalindrome_manacher("babad"));
            println(longestPalindrome_manacher("bababd"));
            println(longestPalindrome_manacher("cbbd"));
            println(longestPalindrome_manacher("ab"));
            println(longestPalindrome_manacher("cbbd"));
            println(longestPalindrome_manacher(""));
            println(longestPalindrome_manacher(testStr));

        }


        /**
         * 暴力解法
         */
        public static String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            char[] chars = s.toCharArray();
            int mLeft = 0;
            int mRight = 0;
            for (int i = 1; i < chars.length; i++) {
                for (int k = 0; k < chars.length - i; k++) {
                    if (isPalindrome(chars, k, k + i - 1)) {
                        mLeft = k;
                        mRight = k + i - 1;
                    }
                }
            }

            return s.substring(mLeft, mRight + 1);
        }

        private static boolean isPalindrome(char[] chars, int left, int right) {
            while (left < right) {
                if (chars[left] == chars[right]) {
                    right--;
                    left++;
                } else {
                    return false;
                }
            }

            return true;
        }

        /**
         * 动态规划
         */
        public static String longestPalindrome_dynamic(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            char[] chars = s.toCharArray();
            int mLeft = 0;
            int mRight = 0;
            int maxLen = 0;
            // f(i， j)表示从i到j的字符串是否为回文
            boolean[][] f = new boolean[chars.length][chars.length];

            for (int i = 0; i < chars.length; i++) {
                f[i][i] = true;
                int j = 0;
                for (; j < i; j++) {
                    f[j][i] = (chars[i] == chars[j]) && (i - j < 2 || f[j + 1][i - 1]);

                    if (f[j][i] && maxLen < i - j + 1) {
                        maxLen = i - j + 1;
                        mLeft = j;
                        mRight = i;
                    }
                }
            }

            return s.substring(mLeft, mRight + 1);
        }

        /**
         * 中心扩展算法
         * @param s
         * @return
         */
        public static String longestPalindrome_center(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            char[] chars = s.toCharArray();
            int mLeft = 0;
            int mRight = 0;
            int maxLen = 0;

            for (int i = 0; i < chars.length - 1; i++) {
                int len1 = isPalindrome_center(chars, i, i);
                int len2 = isPalindrome_center(chars, i, i + 1);
                maxLen = len1 > len2 ? len1 : len2;
                if (maxLen >= mRight - mLeft + 1) {
                    mLeft = i - (maxLen - 1) / 2;
                    mRight = i + maxLen / 2;
                }
            }

            return s.substring(mLeft, mRight + 1);
        }

        /**
         * 以left、right为中心，分别往左和往右遍历，判断是否回文串
         * @return 返回最大回文长度
         */
        private static int isPalindrome_center(char[] chars, int left, int right) {
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left--;
                right++;
            }

            return right - left - 1;

        }

        public static String longestPalindrome_manacher(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            String newStr = preProcStr(s);
            char[] chars = newStr.toCharArray();
            int len = chars.length;
            int[] p = new int[len];
            int c = 0;
            int r = 0;
            for (int i = 1; i < len - 1; i++) {
                int iMirror = (c << 1) - i;
                if (r > i) {
                    p[i] = r - i < p[iMirror] ? r - i : p[iMirror];
                } else {
                    p[i] = 0;
                }

                while (chars[i + 1 + p[i]] == chars[i - 1 - p[i]]) {
                    p[i]++;
                }

                if (i + p[i] > r) {
                    c = i;
                    r = i + p[i];
                }
            }

            int maxLen = 0;
            int index = 0;
            for (int i = 1; i < len - 1; i++) {
                if (p[i] > maxLen) {
                    maxLen = p[i];
                    index = i;
                }
            }

            int start = (index - maxLen) / 2;
            return s.substring(start, start + maxLen);
        }

        /**
         * 给字符之间插入#，并插入首位标志 ^  $
         */
        private static String preProcStr(String str) {
            StringBuilder sb = new StringBuilder("^#");
            for (char c : str.toCharArray()) {
                sb.append(c).append('#');
            }
            sb.append('$');
            return sb.toString();
        }


        public String preProcess2(String s) {
            int n = s.length();
            if (n == 0) {
                return "^$";
            }
            String ret = "^";
            for (int i = 0; i < n; i++)
                ret += "#" + s.charAt(i);
            ret += "#$";
            return ret;
        }

        // 马拉车算法
        public String longestPalindrome_manacher2(String s) {
            String T = preProcess2(s);
            int n = T.length();
            int[] P = new int[n];
            int C = 0, R = 0;
            for (int i = 1; i < n - 1; i++) {
                int i_mirror = 2 * C - i;
                if (R > i) {
                    P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
                } else {
                    P[i] = 0;// 等于 R 的情况
                }

                // 碰到之前讲的三种情况时候，需要利用中心扩展法
                while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                    P[i]++;
                }

                // 判断是否需要更新 R
                if (i + P[i] > R) {
                    C = i;
                    R = i + P[i];
                }

            }

            // 找出 P 的最大值
            int maxLen = 0;
            int centerIndex = 0;
            for (int i = 1; i < n - 1; i++) {
                if (P[i] > maxLen) {
                    maxLen = P[i];
                    centerIndex = i;
                }
            }
            int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
            return s.substring(start, start + maxLen);
        }


    }


    private static void println(String s) {
        System.out.println(s);
    }

    private static void println(int t) {
        System.out.println(t);
    }

    private static void println(Object obj) {
        System.out.println(obj);
    }




}
