package com.xl.algorithm.zijie;

public class ques {
    public static void main(String[] args) {
//        LongestPSub.test();

        LongestPSub.test2();
    }

    /**
     * 题目是这样的：给定一个序列，找到其中最长的回文子序列，并返回该序列的长度。对于一个回文子序列来说，正着读跟倒着读都一样。
     * 我们对子序列的定义是，它可以由其它序列删除一些元素或者不删得到，不影响剩余的元素的顺序。
     *
     * 示例 1:
     * 输入:
     * "abdbca"
     * 输出:
     * 5
     * 一个可能的最长回文子序列为 "abdba"。
     *
     * 示例 2:
     * 输入:
     * "cddpd"
     * 输出:
     * 3
     * 一个可能的最长回文子序列为 "ddd"。
     */
    static class LongestPSub {

        public static void test() {
            findLPS2("abdbca");
            findLPS2("cddpd");
        }

        public static int findLPS(String input) {
            if (input == null || input.isEmpty()) {
                return 0;
            }

            char[] chars = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            int maxLen = findLPSRecursive(sb, chars, 0, chars.length - 1);
            String lps = null;
            if (maxLen % 2 == 0) {
                lps = sb.toString();
                lps += sb.reverse().toString();
            } else {
                char center = sb.charAt(sb.length() - 1);
                sb = sb.deleteCharAt(sb.length() - 1);
                lps = sb.toString();
                lps += center;
                lps += sb.reverse().toString();
            }

            System.out.println(String.format("%s 's lps is %s, maxLen = %d", input, lps, maxLen));


            return maxLen;
        }

        public static int findLPSRecursive(StringBuilder sb, char[] chars, int start, int end) {
            int len = 0;
            while (start <= end) {
                if (start == end) {
                    sb.append(chars[start]);
                    len += 1;
                    return len;
                }

                if (chars[start] == chars[end]) {
                    sb.append(chars[start]);
                    len += 2;
                    start++;
                    end--;
                    continue;
                }

                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                int len1 = findLPSRecursive(sb1, chars, start, end - 1);
                int len2 = findLPSRecursive(sb2, chars, start + 1, end);
                if (len1 >= len2) {
                    len += len1;
                    sb.append(sb1);
                } else {
                    len += len2;
                    sb.append(sb2);
                }

                return len;
            }

            return len;
        }

        public static int findLPS2(String input) {
            if (input == null || input.isEmpty()) {
                return 0;
            }

            Integer[][] dp = new Integer[input.length()][input.length()];
            char[] chars = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            int maxLen = findLPSRecursive2(dp, sb, chars, 0, chars.length - 1);
            String lps = null;
            if (maxLen % 2 == 0) {
                lps = sb.toString();
                lps += sb.reverse().toString();
            } else {
                char center = sb.charAt(sb.length() - 1);
                sb = sb.deleteCharAt(sb.length() - 1);
                lps = sb.toString();
                lps += center;
                lps += sb.reverse().toString();
            }

            System.out.println(String.format("%s 's lps is %s, maxLen = %d", input, lps, maxLen));
            return maxLen;
        }


        public static int findLPSRecursive2(Integer[][] dp, StringBuilder sb, char[] chars, int start, int end) {
            int len = 0;
            while (start <= end) {
                if (start == end) {
                    sb.append(chars[start]);
                    len += 1;
                    dp[start][end] = len;
                    return len;
                }

                if (chars[start] == chars[end]) {
                    sb.append(chars[start]);
                    len += 2;
                    dp[start][end] = len;
                    start++;
                    end--;
                    continue;
                }

                if (dp[start][end] != null) {
                    return dp[start][end];
                }


                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                int len1 = findLPSRecursive(sb1, chars, start, end - 1);
                int len2 = findLPSRecursive(sb2, chars, start + 1, end);
                if (len1 >= len2) {
                    len += len1;
                    sb.append(sb1);
                    dp[start][end - 1] = len1;
                    dp[start][end] = len;
                } else {
                    len += len2;
                    sb.append(sb2);
                    dp[start + 1][end] = len1;
                    dp[start][end] = len;
                }

                return dp[start][end];
            }

            return dp[start][end];
        }

        public static void test2() {
            System.out.println(findLPSLength3("abdbca"));
            System.out.println(findLPSLength3("cddpd"));
        }

        public static int findLPSLength(String input) {
            int[][] dp = new int[input.length()][input.length()];
            for (int i = 0; i < input.length(); i++) {
                dp[i][i] = 1;
            }

            char[] chars = input.toCharArray();
            for (int i = 0; i < input.length(); i++) {
                for (int j = input.length() - 1; j >= i; j--) {
                    if (i == j) {
                        continue;
                    }
                    if (chars[i] == chars[j]) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }

            return dp[0][input.length() - 1];
        }


        public static int findLPSLength3(String st) {
            // dp[i][j]存储着从i到j的最长子序列
            int[][] dp = new int[st.length()][st.length()];

            //每个单独的元素都是长度为1的回文子序列
            for (int i = 0; i < st.length(); i++)
                dp[i][i] = 1;

            for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
                for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                    //情况1，首尾相同
                    if (st.charAt(startIndex) == st.charAt(endIndex)) {
                        dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                    } else { //情况2，跳过首尾中的一个
                        dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                    }
                }
            }
            return dp[0][st.length() - 1];
        }
    }



}
