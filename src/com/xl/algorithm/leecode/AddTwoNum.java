package com.xl.algorithm.leecode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 两数相加
 *
 * 题目描述:
 *     给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 *     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *     输出：7 -> 0 -> 8
 *     原因：342 + 465 = 807
 *
 *
 * 题目解析
 * 设立一个表示进位的变量carried，建立一个新链表，把输入的两个链表从头往后同时处理，每两个相加，将结果加上carried后的值作为一个新节点到新链表后面。
 *
 */
public class AddTwoNum {
    public static void main(String[] args) {
        test();

        LinkedList<Integer> num1 = new LinkedList<>();
        num1.add(2);
        num1.add(4);
        num1.add(3);
        LinkedList<Integer> num2 = new LinkedList<>();
        num2.add(5);
        num2.add(6);
        num2.add(4);
        num2.add(3);

        LinkedList<Integer> result = addTwoNum(num1, num2);
        System.out.println(result);
    }


    public static LinkedList<Integer> addTwoNum(LinkedList<Integer> num1, LinkedList<Integer> num2) {
        if (num1 == null && num2 == null) {
            return new LinkedList<>();
        }
        if (num1 == null || num1.size() == 0) {
            return num2;
        }
        if (num2 == null || num2.size() == 0) {
            return num1;
        }

        LinkedList<Integer> result = new LinkedList<>();
        int sum = 0;
        boolean isNum1Shoter = num1.size() <= num2.size();
        int minSize = isNum1Shoter ? num1.size() : num2.size();
        Iterator<Integer> num1Iter = num1.iterator();
        Iterator<Integer> num2Iter = num2.iterator();

        int i = 0;
        boolean hasToAdd = false;   //标记和是否大于等于10，如果是，则下一数位需要加1

//        while (num1Iter.hasNext() && i < minSize) {
//            if (hasToAdd) {
//                sum = 1;
//            }
//            sum += num1Iter.next() + num2Iter.next();
//            hasToAdd = sum >= 10;
//            result.add(sum % 10);
//            sum = 0;
//            i++;
//        }
//
//        Iterator<Integer> numIter = isNum1Shoter ? num2Iter : num1Iter;
//        while (numIter.hasNext()) {
//            if (hasToAdd) {
//                sum = 1;
//            }
//            sum += numIter.next();
//            hasToAdd = sum >= 10;
//            result.add(sum % 10);
//            sum = 0;
//        }

        //如下是一次遍历实现，代码更简洁
        Iterator<Integer> numIter = isNum1Shoter ? num2Iter : num1Iter;
        while (numIter.hasNext()) {
            if (hasToAdd) {
                sum = 1;
            }
            if (num1Iter.hasNext()) {
                sum += num1Iter.next();
            }
            if (num2Iter.hasNext()) {
                sum += num2Iter.next();
            }

            hasToAdd = sum >= 10;
            result.add(sum % 10);
            sum = 0;
        }



        return result;
    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int tempSum = 0;
        int carry = 0;
        while (l1 != null && l2 != null) {
            tempSum = l1.val + l2.val + carry;
            p.next = new ListNode(tempSum % 10);

            carry = tempSum >= 10 ? 1 : 0;

            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }

        while (l1 != null) {
            tempSum = l1.val + carry;
            p.next = new ListNode(tempSum % 10);
            carry = tempSum >= 10 ? 1 : 0;
            l1 = l1.next;
            p = p.next;
        }

        while (l2 != null) {
            tempSum = l2.val + carry;
            p.next = new ListNode(tempSum % 10);
            carry = tempSum >= 10 ? 1 : 0;
            l2 = l2.next;
            p = p.next;
        }

        if (carry > 0) {
            p.next = new ListNode(carry);
        }

        return head.next;
    }

    /**
     *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *  *     输出：7 -> 0 -> 8
     *  *     原因：342 + 465 = 807
     */
    private static void test() {
        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode p2 = l2;
        p2.next = new ListNode(6);
        p2 = p2.next;
        p2.next = new ListNode(4);

        ListNode result =  addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
