package com.xl.algorithm.leecode;

import sun.dc.pr.PRError;

import java.util.HashSet;
import java.util.Stack;

/**
 *
 * LeetCode 第 150 号问题：逆波兰表达式求值
 * 题目来源于 LeetCode 上第 150 号问题：逆波兰表达式求值。题目难度为 Medium，目前通过率为 43.7% 。
 *
 * 题目描述
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况
 */
public class ReversePoland {
    private static final HashSet<String> OPERATOR_SET = new HashSet<>(4);
    static {
        OPERATOR_SET.add("+");
        OPERATOR_SET.add("-");
        OPERATOR_SET.add("*");
        OPERATOR_SET.add("/");
    }

    public static void main(String[] args) {
        // 3*（2-（5+1））
        String revPolandStr = "3 2 5 1 + - *";
        int result = calcReversePoland(revPolandStr);
        System.out.println(result);
    }

    private static int calcReversePoland(String revPolandStr) {
        String[] strArray = revPolandStr.split(" ");
        Stack<Integer> stack = new Stack<>();
        //将解析的文本入栈
        for (String str : strArray) {
            if (!isOperator(str)) {
                stack.push(Integer.valueOf(str));
                continue;
            }

            int b = stack.pop();
            int a = stack.pop();
            stack.push(cal(a, b, str));
        }

        return stack.pop();
    }

    private static boolean isOperator(String str) {
        return OPERATOR_SET.contains(str);
    }

    private static int cal(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}
