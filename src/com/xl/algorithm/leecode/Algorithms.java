package com.xl.algorithm.leecode;

import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;

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

//        ValidBrackets.test();

//        MergeTwoLists.test();


//        MergeKLists.test();

//        RemoveDuplicates.test();

//        SearchRotationSortedArray.test();

//        StrMultiply.test();

//        Permute.test();

//        MaxSubArray.test();

//        SpiralOrder.test();

//        GenerateMatrix.test();

//        RotateRight.test();

//        UniquePaths.test();

//        ClimbStairs.test();

//        Subsets.test();

//        Merge.test();

//        MaxDepth.test();

//        GrayCode.test();

//        MaxProfit.test();

//        MaxProfit2.test();

//        SingleNumber.test();

//        MaxPathSum.test();

//        HasCycle.test();

//        DetectCycle.test();

//        SortList.test();

//        MinStack.test();

//        GetIntersectionNode.test();

//        MajorityElement.test();

//        ReverseList.test();

//        FindKthLargest.test();

        RemoveNthFromEnd.test();

    }

    /**
     * 138. 复制带随机指针的链表
     *
     * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     * 要求返回这个链表的 深拷贝。 
     * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     *
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     *
     * 示例 1：
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     *
     * 示例 2：
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     *
     * 示例 3：
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     *
     * 示例 4：
     * 输入：head = []
     * 输出：[]
     * 解释：给定的链表为空（空指针），因此返回 null。
     *  
     *
     * 提示：
     * -10000 <= Node.val <= 10000
     * Node.random 为空（null）或指向链表中的节点。
     * 节点数目不超过 1000 。
     */
    /*
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    */
    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            Node first = head;
            Node nHead = head;

            return null;


        }

    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    /**
     * 19. 删除链表的倒数第N个节点
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *
     * 说明：
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     *
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class RemoveNthFromEnd {
        public static void test() {
//            printListNode(removeNthFromEnd(buildListNode(new int[]{1, 2, 3, 4, 5}), 2));
            printListNode(removeNthFromEnd(buildListNode(new int[]{1}), 1));
        }

        public static ListNode removeNthFromEnd2(ListNode head, int n) {
            ListNode first = head;
            int len = 0;
            while (first != null) {
                len++;
                first = first.next;
            }
            int loc = len - n;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            first = dummy;
            while (loc > 0) {
                loc--;
                first = first.next;
            }

            first.next = first.next.next;
            return dummy.next;
        }

        /**
         * 遍历一次逻辑
         */
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy;
            int len = 0;
            while (first != null && len <= n) {
                len++;
                first = first.next;
            }
            ListNode toDel = dummy;
            while (first != null) {
                first = first.next;
                toDel = toDel.next;
            }

            toDel.next = toDel.next.next;
            return dummy.next;
        }
    }



    /**
     * 215. 数组中的第K个最大元素
     *
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     *
     * 示例 2:
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *
     * 说明:
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */
    static class FindKthLargest {
        public static void test() {
            println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));   //5
            println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));   //4
        }

        /**
         *
         * 求第K大的数字，即要找到一个数，前面k-1个都比它大，后面比它小
         * 那么可采用采用快速排序思想，每次选一个基准，将比这个基准大的数放到其前面，小的数放到后面
         * 以此迭代，直到找到第k位基准
         */
//        public static int findKthLargest(int[] nums, int k) {
//            int pivot = nums[(nums.length  + 1) / 2];
//            int loc = 0;
//            int start = 1;
//            int end = nums.length - 1;
//            while (start != end) {
//                if (nums[end] < pivot) {
//                    end--;
//                }
//                if (nums[start] > pivot) {
//                    start++;
//                }
//            }
//
//            while (loc != k) {
//                for (int i = 1; i < end; i++) {
//                    if (nums[i] > pivot) {
//                        swap(nums, loc, i);
//                        loc = i;
//                    }
//                }
//            }
//
//            return nums[k];
//        }
//
//        private static void swap(int[] nums, int i, int j) {
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//        }


        /**
         * 维护一个k size的有序数组，存放最大的k个数(或者用k个元素的最小堆)
         */
        public static int findKthLargest(int[] nums, int k) {
            int[] large = new int[k];
            for (int i = 0; i < nums.length; i++) {
                insert(large, nums[i]);
            }

            return large[0];
        }

        private static void insert(int[] large, int num) {
            if (num < large[0]) {
                return;
            }

            large[0] = num;
            for (int i = 1; i < large.length; i++) {
                if (large[i] < num) {
                    large[i - 1] = large[i];
                    large[i] = num;
                }
            }
        }

        /**
         * 最简单的方法是先排序，再直接找处于第k位的数字，排序解法略
         */
        public static int findKthLargest3(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }





    /**
     * 206. 反转链表
     *
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class ReverseList {
        private static void test() {
            printListNode(reverseList(buildListNode(new int[] {1, 2, 3, 4, 5})));
        }

        /**
         * 最快解法：
         *    遍历链表的过程中，每次将节点插到新链表的头部
         */
        public static ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode l = head;
            ListNode res = null;
            ListNode cur = null;
            while (l != null) {
                cur = l;
                l = l.next;
                cur.next = res;
                res = cur;
            }

            return res;
        }

        /**
         * 递归/迭代求解
         * 可以用递归(回溯法) 两两交换的方式，类似归并排序
         * 1 2 3 4 5
         * 1 和 2交换 2 1
         * 3 和 4 交换 4 3
         * 5一个元素不变
         * 2 1 和 4 3 交换  4 3  2 1
         * 4 3 2 1 和 5 交换 5 4 3 2 1
         */
        public static ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            //通过步长2和步长1的快慢指针对链表进行中间分割(快指针走到尾部时，慢指针走到中间)
            ListNode fast = head;
            ListNode slow = head;
            ListNode slowPre = head;
            while (fast != null && fast.next != null) {
                slowPre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            slowPre.next = null;
            return splice(reverseList(head), reverseList(slow));
        }

        /**
         * 返回b→a
         */
        private static ListNode splice(ListNode a, ListNode b) {
            ListNode head = b;
            while (head.next != null) {
                head = head.next;
            }
            head.next = a;
            return b;
        }

        /**
         * 通过栈求解
         */
        public static ListNode reverseList3(ListNode head) {
            LinkedList<ListNode> list = new LinkedList<>();
            ListNode l = head;
            while (l != null) {
                list.addFirst(l);
                l = l.next;
            }

            ListNode revHead = new ListNode(-1);
            l = revHead;
            for (ListNode node : list) {
                l.next = node;
                l = l.next;
                l.next = null;
            }
            return revHead.next;
        }


    }

    /**
     * 169. 多数元素
     *
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */
   static class MajorityElement {
        public static void test() {
            println(majorityElement(new int[] {3,2,3}));
            println(majorityElement(new int[] {2,2,1,1,1,2,2}));

        }

        /**
         * 思路如下：
         *     既然多数元素大于n/2,那么我们可以两两丢掉不相等的数字，剩下的数字即为多数元素
         */
        public static int majorityElement(int[] nums) {
            int times = 1;
            int n = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == n) {
                    times++;
                } else {
                    if (times == 1) {
                        n = nums[++i];
                    } else {
                        times--;
                    }
                }
            }
            return n;
        }
    }


    /**
     * 160. 相交链表
     *
     * 编写一个程序，找到两个单链表相交的起始节点。
     * 如下面的两个链表：(图示见LeetCode题目)
     * 在节点 c1 开始相交。
     *
     * 示例 1：(图示见LeetCode题目)
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *  
     *
     * 示例 2：(图示见LeetCode题目)
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     *  
     *
     * 示例 3：(图示见LeetCode题目)
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null。
     *  
     *
     * 注意：
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    static class GetIntersectionNode {
        public static void test() {
            //intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
            Pair<ListNode, ListNode> pair1 = buildCrossList(new int[]{4,1,8,4,5}, new int[]{5,0,1,8,4,5}, 2, 3);
            ListNode listA1 = pair1.getKey();
            ListNode listB1 = pair1.getValue();

            //intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
            pair1 = buildCrossList(new int[]{0,9,1,2,4}, new int[]{3,2,4}, 3, 1);
            ListNode listA2 = pair1.getKey();
            ListNode listB2 = pair1.getValue();

            //intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
            pair1 = buildCrossList(new int[]{2,6,4}, new int[]{1,5}, -1, -1);
            ListNode listA3 = pair1.getKey();
            ListNode listB3 = pair1.getValue();

            printListNodeVal(getIntersectionNode(listA1, listB1));
            printListNodeVal(getIntersectionNode(listA2, listB2));
            printListNodeVal(getIntersectionNode(listA3, listB3));
        }

        /**
         * 假设corss为相交部分链表长，len(A)-cross=a  len(B)-cross=b
         * A : a + cross = len(A) = m
         * B : b + cross = len(B) = n
         * 先求得A和B的长度m，n。（遍历完后，A和B最后节点是否相同，如果相同则有相交否则未相交）
         * 假设m>n，那么从A先遍历m-n个节点，然后与B一起开始往后遍历，第一个相同的节点即相交节点
         */
        public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            ListNode a = headA;
            ListNode b = headB;
            int m = 1;
            int n = 1;
            while (a.next != null) {
                m++;
                a = a.next;
            }
            while (b.next != null) {
                n++;
                b = b.next;
            }
            if (a != b) {  //最后一个节点不同，则表示无相交
                return null;
            }

            a = headA;
            b = headB;
            if (m > n) {
                for (int i = 0; i < m - n; i++) {
                    a = a.next;
                }
            } else {
                for (int i = 0; i < n - m; i++) {
                    b = b.next;
                }
            }

            while (a != b) {
                a = a.next;
                b = b.next;
            }

            return a;
        }

        /**
         * 双指针解法：
         *    A : a + cross
         *    B : b + cross
         *  那么一个指针从A开始，遍历完后遍历B
         *  另一个指针同时从B开始，遍历完后遍历A。两个指针相遇的点即相交点
         *  原理同解法1，利用A和B的链表长度差
         *
         */
        public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            ListNode a = headA;
            ListNode b = headB;
            boolean firstA = false;
            boolean firstB = false;
            while (a != null && b != null) {
                if (a == b) {
                    return a;
                }
                a = a.next;
                if (a == null && !firstA) {
                    firstA = true;
                    a = headB;
                }
                b = b.next;
                if (b == null && !firstB) {
                    firstB = true;
                    b = headA;
                }
            }

            return null;
        }

        /**
         * 双指针更精简的写法
         * @param headA
         * @param headB
         * @return
         */
        public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null ||headB==null){
                return null;
            }
            ListNode pa=headA;
            ListNode pb=headB;
            while(pa!=pb){
                pa=pa==null ? headB :pa.next;
                pb=pb==null ? headA:pb.next;
            }
            return pa;
        }


    }


    /**
     * 155. 最小栈
     *
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     *
     * 示例:
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    /**
     * LinkedList实现栈，同时维护一个存放最小值的变量。
     * 该方法的缺点在于，当pop的值为min时，需遍历整个栈，得到新的最小值
     */
    static class MinStack {
        private LinkedList<Integer> list;

        private int min = 2147483647;

        /** initialize your data structure here. */
        public MinStack() {
            list = new LinkedList<>();
        }

        public void push(int x) {
            list.push(x);
            min = min > x ? x : min;
        }

        public void pop() {
            int pop = list.pop();
            if (pop != min) {
                return;
            }
            min = 2147483647;
            for (Integer v : list) {
                min = min > v ? v : min;
            }
        }

        public int top() {
            return list.getFirst();
        }

        public int getMin() {
            return min;
        }

        public static void test() {
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            println(minStack.getMin());  //返回 -3.
            minStack.pop();
            println(minStack.top());     // 返回 0.
            println(minStack.getMin());   // 返回 -2.

        }
    }
    /**
     * 更加巧妙的实现
     * LinkedList存放栈，仍然用一个变量维护min，不过关键在于对Min的处理，使其在push和pop时得到更新
     * 拿 1 2 -1 4 举例
     * 1进栈 栈空 push 0=1-min  min=1
     * 2进栈  push 1=2-min   min=1
     * -1进栈 push -2=-1-oldMin 之后更新min=-1
     * 4进栈  push 5=4-min  min=-1
     * 4出栈 pop=5 pop>0→min不变=-1 x=pop+min=4
     * -1出栈 pop=-2 pop<0因此x=min=-1，min更新为min-pop=1
     * 2出栈 pop=1 pop>0→min不变=1，x=pop+min=2
     * 1出栈 pop=0 pop>=0→min不变，x=pop+min=1
     */
    static class MinStack2 {
        private LinkedList<Integer> list;

        private int min = 2147483647;

        /** initialize your data structure here. */
        public MinStack2() {
            list = new LinkedList<>();
        }

        /**
         * 该解法有个问题，x-min可能超出int阈值
         */
        public void push(int x) {
            if (list.isEmpty()) {
                min = x;
                list.push(0);
            } else {
                list.push(x - min);
                min = min > x ? x : min;
            }
        }

        public void pop() {
            int pop = list.pop();
            if (pop < 0) {
                min = min - pop;
            }
        }

        public int top() {
            int top = list.getFirst();
            return top < 0 ? min : top + min;
        }

        public int getMin() {
            return min;
        }

        public static void test() {
            MinStack2 minStack = new MinStack2();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            println(minStack.getMin());  //返回 -3.
            minStack.pop();
            println(minStack.top());     // 返回 0.
            println(minStack.getMin());   // 返回 -2.
        }
    }





    /**
     * 148. 排序链表
     *
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     *
     * 示例 1:
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     *
     * 示例 2:
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class SortList {
        public static void test() {
            ListNode list1 = buildListNode(new int[] { 4, 2, 1, 3 });
            ListNode list2 = buildListNode(new int[] { -1, 5, 3, 4, 0 });

            printListNode(sortList(list1));
            printListNode(sortList(list2));
        }

        /**
         * 基于归并排序实现
         * 难点是对链表进行划分，找链表中心点的方法为：通过快慢指针，快指针步长2，慢指针1，快指针到链表尾，则慢指针指向链表中心
         */
        public static ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode fast = head;
            ListNode slow = head;
            ListNode slowPre = slow;
            while (fast != null && fast.next != null) {
                slowPre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            slowPre.next = null;
            return merge(sortList(head), sortList(slow));
        }

        private static ListNode merge(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode r = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    r.next = l1;
                    l1 = l1.next;
                } else {
                    r.next = l2;
                    l2 = l2.next;
                }
                r = r.next;
            }

            if (l1 != null) {
                r.next = l1;
            }
            if (l2 != null) {
                r.next = l2;
            }

            return head.next;
        }

        /**
         * 耗时更少解法，但是没说明~
         */
        public static ListNode sortList2(ListNode head) {
            if(head==null||head.next==null) return head;
            ListNode x1=new ListNode(0);
            ListNode x11=x1;
            x1.next=null;
            ListNode x2=new ListNode(0);
            ListNode x22=x2;
            x2.next=null;
            ListNode x3=new ListNode(0);
            ListNode x33=x3;
            x3.next=null;
            ListNode p=head;
            int t=head.val;
            while(p!=null){
                if(p.val==t){
                    x2.next=p;
                    p=p.next;
                    x2=x2.next;
                    x2.next=null;
                }else if(p.val<t){
                    x1.next=p;
                    p=p.next;
                    x1=x1.next;
                    x1.next=null;
                }else{
                    x3.next=p;
                    p=p.next;
                    x3=x3.next;
                    x3.next=null;
                }
            }
            x11=sortList2(x11.next);
            x33=sortList2(x33.next);
            p=x11;
            if(p==null){
                x11=x22.next;
                p=x11;
            }else{
                while(p.next!=null){
                    p=p.next;
                }
                p.next=x22.next;
            }
            while(p.next!=null){
                p=p.next;
            }
            p.next=x33;
            return x11;
        }
    }


    /**
     * 146. LRU缓存机制
     *
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     *
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
     *
     * 进阶:
     * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
     *
     * 示例:
     * LRUCache cache = new LRUCache( 2 /缓存容量 / );
     *
     * cache.put(1,1);
     * cache.put(2,2);
     * cache.get(1);       // 返回  1
     * cache.put(3,3);    // 该操作会使得密钥 2 作废
     * cache.get(2);       // 返回 -1 (未找到)
     * cache.put(4,4);    // 该操作会使得密钥 1 作废
     * cache.get(1);       // 返回 -1 (未找到)
     * cache.get(3);       // 返回  3
     * cache.get(4);       // 返回  4
     */
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer val = super.get(key);
            if (val == null) {
                return -1;
            } else {
                return val;
            }
//            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return capacity > this.size();
        }

        public static void test() {
            LRUCache cache = new LRUCache(2);
            cache.put(1, 1);
            cache.put(2, 2);
            println(cache.get(1));       // 返回  1
            cache.put(3, 3);    // 该操作会使得密钥 2 作废
            println(cache.get(2));       // 返回 -1 (未找到)
            cache.put(4, 4);    // 该操作会使得密钥 1 作废
            println(cache.get(1));       // 返回 -1 (未找到)
            println(cache.get(3));       // 返回  3
            println(cache.get(4));       // 返回  4
        }
    }

    static class LRUCache2 {
        public static void test() {
            LRUCache2 cache = new LRUCache2(2);
            cache.put(1, 1);
            cache.put(2, 2);
            println(cache.get(1));       // 返回  1
            cache.put(3, 3);    // 该操作会使得密钥 2 作废
            println(cache.get(2));       // 返回 -1 (未找到)
            cache.put(4, 4);    // 该操作会使得密钥 1 作废
            println(cache.get(1));       // 返回 -1 (未找到)
            println(cache.get(3));       // 返回  3
            println(cache.get(4));       // 返回  4
        }

        LinkedHashMap<Integer, Integer> map;
        int capacity;
        public LRUCache2(int capacity) {
            map = new LinkedHashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer val = map.remove(key);
            if (val == null) {
                return -1;
            }

            map.put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Integer val = map.remove(key);
            if (val != null) {
                map.put(key, value);
                return;
            }

            if (map.size() == capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }
    }


    /**
     * 142. 环形链表 II
     * (解法参考： https://www.cnblogs.com/cone/p/11257063.html  )
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * 说明：不允许修改给定的链表。 (即链表尾部连接的节点)
     *  （可参见原题的环图示）
     *
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 示例 2：
     * 输入：head = [1,2], pos = 0
     * 输出：tail connects to node index 0
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     * 示例 3：
     * 输入：head = [1], pos = -1
     * 输出：no cycle
     * 解释：链表中没有环。
     *
     * 进阶：
     * 你是否可以不用额外空间解决此题？
     */
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public static class DetectCycle {
        public static void test() {
            ListNode list1 = new ListNode(3);
            ListNode circleNode = new ListNode(2);
            list1.next = circleNode;
            list1.next.next = new ListNode(0);
            list1.next.next.next = new ListNode(-4);
            list1.next.next.next.next = circleNode;

            ListNode list2 = new ListNode(1);
            list2.next = new ListNode(2);
            list2.next.next = list2;

            ListNode list3 = new ListNode(1);

            printListNodeVal(detectCycle(list1));
            printListNodeVal(detectCycle(list2));
            printListNodeVal(detectCycle(list3));
        }

        /**
         * 先通过141 环形链表题的快慢指针法判断是否有环，并找到两个指针相遇点
         * 假设 从head到环开始节点距离为a，相遇点到环开始节点距离为b
         * 则 慢指着拿走了a+b  快指针走了2(a+b)=a + b + n * cir,其中cir指环的周长。
         * 即a + b = n * cir, a = n * cir - b = (n - 1) * cir + cir - b
         * 此时慢指针再次从head出发，步长1向后遍历，快指针一样步长1继续往后遍历。
         * 那么两者相遇点即环开始点。即慢指针走了a步时，快指针走了a=(n - 1) * cir + cir - b，刚好也在环开始节点
         * @param head
         * @return
         */
        public static ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }

            ListNode slow = head;
            ListNode fast = head;
            while (slow != null && fast != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast == null) {
                    return null;
                }
                fast = fast.next;
                if (slow == fast) {
                    break;
                }
            }
            if (slow != fast) {
                return null;
            }

            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }

    /**
     * 141. 环形链表
     *
     * 给定一个链表，判断链表中是否有环。(即判断链表尾部是否连接前面的节点)
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * （可参见原题的环图示）
     *
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 示例 2：
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     *
     * 示例 3：
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     *
     * 进阶：
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     */
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public static class HasCycle {
        public static void test() {
            ListNode list1 = new ListNode(3);
            ListNode circleNode = new ListNode(2);
            list1.next = circleNode;
            list1.next.next = new ListNode(0);
            list1.next.next.next = new ListNode(-4);
            list1.next.next.next.next = circleNode;

            ListNode list2 = new ListNode(1);
            list2.next = new ListNode(2);
            list2.next.next = list2;

            ListNode list3 = new ListNode(1);

            println(hasCycle(list1));
            println(hasCycle(list2));
            println(hasCycle(list3));
        }

        /**
         * 快慢指针遍历法，慢指针步长1，快指针步长2，如果慢指针和快指针能相遇，则说明有环
         */
        public static boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;
            while (slow != null && fast != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast == null) {
                    return false;
                }
                fast = fast.next;

                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * 136. 只出现一次的数字
     *
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     *
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */
    static class SingleNumber {

        public static void test() {
            println(singleNumber(new int[] {}));
            println(singleNumber(new int[] { 1 }));
            println(singleNumber(new int[] { 2, 2, 1 }));
            println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));

        }

        /**
         * 相同的数异或为0~  0和num异或结果为num
         */
        public static int singleNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            for (int i = 1; i < nums.length; i++) {
                nums[0] = nums[0] ^ nums[i];
            }

            return nums[0];
        }
    }


    /**
     * 124. 二叉树中的最大路径和
     *                         (困难)
     * 给定一个非空二叉树，返回其最大路径和。
     *
     * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     *
     * 示例 1:
     * 输入: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * 输出: 6
     *
     * 示例 2:
     * 输入: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 输出: 42
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class MaxPathSum {

        static int maxSum = 0;
        public static void test() {
            TreeNode node1 = buildTreeNode(new Integer[] {1,2,3});
            TreeNode node2 = buildTreeNode(new Integer[] {-10,9,20,null,null,15,7});
            TreeNode node3 = buildTreeNode(new Integer[] {1});
            println(maxPathSum(node1));

            println(maxPathSum(node2));
            println(maxPathSum(node3));
        }

        public static int maxPathSum(TreeNode root) {
            maxSum = root.val;
            maxPath(root);
            return maxSum;
        }
        public static int maxPath(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.right == null && root.left == null) {
                maxSum = maxSum > root.val ? maxSum : root.val;
                return root.val;
            }

            int left = maxPathSum(root.left);
            int right = maxPathSum(root.right);
            int max3 = max3(root.val, left + root.val, right + root.val);
            maxSum = max3(maxSum, max3, left + right + root.val);
            return max3;
        }
    }

    /**
     * 122. 买卖股票的最佳时机 II
     *
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    static class MaxProfit2 {
        public static void test() {
            println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
            println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
            println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
        }

        public static int maxProfit(int[] prices) {
            if (prices == null || prices.length < 1) {
                return 0;
            }
            int sum = 0;
            int buy = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (buy == prices[i]) {
                    continue;
                } else if (buy > prices[i]) {
                    buy = prices[i];
                } else {
                    sum += prices[i] - buy;
                    buy = prices[i];
                }
            }

            return sum;
        }
    }


    /**
     * 121. 买卖股票的最佳时机
     *
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意你不能在买入股票前卖出股票。
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     *
     * 示例 2:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * 示例 3:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     */
    static class MaxProfit {
        public static void test() {
            println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
            println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
            println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        }


        public static int maxProfit(int[] prices) {
            if (prices == null || prices.length < 1) {
                return 0;
            }
            int buy = prices[0];
            int maxc = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < buy) {
                    buy = prices[i];
                } else {
                    maxc = max(maxc, prices[i] - buy);
                }
            }

            return maxc;
        }
    }


    /**
     * 104. 二叉树的最大深度
     *
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class MaxDepth {
        public static void test() {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            println(maxDepth(root));
        }

        public static int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return depth(root);
        }

        private static int depth(TreeNode root) {
            if (root.left != null && root.right != null) {
                return 1 + max(depth(root.left), depth(root.right));
            } else if (root.left != null) {
                return 1 + depth(root.left);
            } else if (root.right != null) {
                return 1 + depth(root.right);
            } else {
                return 1;
            }

        }


        static int maxD;
        public static int maxDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }

            getDepth(root, 1);
            return maxD;
        }

        private static void getDepth(TreeNode root, int depth) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                maxD = max(maxD, depth);
            }

            getDepth(root.left, depth + 1);
            getDepth(root.right, depth + 1);
        }

    }


    /**
     * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
     *
     * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
     *
     * 示例 1:
     * 输入: 2
     * 输出: [0,1,3,2]
     * 解释:
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     *
     * 对于给定的 n，其格雷编码序列并不唯一。
     * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
     * 00 - 0
     * 10 - 2
     * 11 - 3
     * 01 - 1
     *
     * 示例 2:
     * 输入: 0
     * 输出: [0]
     * 解释: 我们定义格雷编码序列必须以 0 开头。
     *      给定编码总位数为 n 的格雷编码序列，其长度为 2^n。当 n = 0 时，长度为 2^0 = 1。
     *      因此，当 n = 0 时，其格雷编码序列为 [0]。
     */
    static class GrayCode {
        public static void test() {
            println(grayCode(0));
            println(grayCode(1));
            println(grayCode(2));
            println(grayCode(3));
            println(grayCode(4));

            println(grayCode2(0));
            println(grayCode2(1));
            println(grayCode2(2));
            println(grayCode2(3));
            println(grayCode2(4));
        }

        /**
         * 解法参考   https://www.cnblogs.com/grandyang/p/4315649.html
         * 知道格雷编码特性求解简单
         * @param n
         * @return
         */
        public static List<Integer> grayCode(int n) {
            int len = 1 << n;
            List<Integer> result = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                result.add(i >> 1 ^ i);
            }

            return result;
        }

        /**
         * 解法2，镜像映射
         * n=1时
         *    0
         *    1
         * n=2
         *   00
         *   01
         *   11
         *   10
         * 可以看到没新加一位，即先在i-1的编码前加0，然后再将i-1的编码顺序倒转，在前面加1
         * 而加零原数字不变，因此仅需添加后面加1部分
         */
        public static List<Integer> grayCode2(int n) {
            List<Integer> result = new ArrayList<>(1 << n);
            if (n == 0) {
                return new ArrayList<>(0);
            }
            result.add(0);
            result.add(1);
            for (int i = 2; i <= n; i++) {
                ArrayList<Integer> list = new ArrayList<>(result.size());
                for (int j = result.size() - 1; j >= 0; j--) {
                    list.add(result.get(j) + (1 << (i - 1)));
                }
                result.addAll(list);
            }

            return result;
        }


    }

    /**
     * 88. 合并两个有序数组
     *
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     * 示例:
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     */
    static class Merge {
        public static void test() {
            merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
            merge(new int[] {2, 0}, 1, new int[] {1}, 1);
            merge(new int[] {4,5,6,0,0,0}, 3, new int[] {1,2,3}, 3);
        }




        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = 0;
            int j = 0;
            int temp = 0;
            while (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    i++;
                } else {
                    temp = nums1[i];
                    nums1[i] = nums2[j];
                    insertHead(nums2, temp);
                }
            }

            for (j = 0; j < n; j++) {
                nums1[m + j] = nums2[j];
            }

            println(nums1);
        }

        /**
         * 将对头的数字插入到排序数组里
         * @param nums
         * @param n
         */
        private static void insertHead(int[] nums, int n) {
            if (nums.length == 1) {
                nums[0] = n;
                return;
            }
            int i = 1;
            while (i < nums.length && nums[i] < n) {
                nums[i - 1] = nums[i];
                i++;
            }
            nums[i - 1] = n;
        }
    }

    /**
     * 78. 子集
     *
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    static class Subsets {
        public static void test() {
            println(subsets(new int[] {  }));
            println(subsets(new int[] { 1 }));
            println(subsets(new int[] { 1, 2 }));
            println(subsets(new int[] { 1, 2, 3 }));
            println(subsets(new int[] { 1, 2, 3, 4 }));
        }

        /**
         * [1]
         * [1]
         *
         * [1, 2]
         * [1][1, 2][2]
         *
         * [1, 2, 3] :  [1, 2] + 3
         * [1][2][1, 2][1, 3][2, 3][1, 2, 3][3]
         * 根据如上推断算法解法如下：
         *    每新加一个元素，即需新加一个1维的新元素数组，然后将之前的每个一维数组与其组成新的二维数组，
         *    二维数组与其组成三维数组，以此类推，直到最后1个数组添加新的元素。
         *
         *    也就是说，每新加一个元素，只需新加一个新元素的一维数组，以及将之前所有的数组添加新元素为新数组。
         */
        public static List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>(0);
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int size = result.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> t = new ArrayList<>(result.get(j).size() + 1);
                    t.addAll(result.get(j));
                    t.add(nums[i]);
                    result.add(t);
                }
                List<Integer> t = new ArrayList<>(0);
                t.add(nums[i]);
                result.add(t);
            }
            return result;
        }

        public List<List<Integer>> subsets2(int[] nums) {
            List<List<Integer>> res = new ArrayList();
            backtrack(res, new ArrayList(), 0, nums);
            return res;
        }

        public void backtrack(List<List<Integer>> res, List<Integer> list, int start, int[] nums){
            res.add(new ArrayList(list));
            for(int i = start; i < nums.length; i++){
                list.add(nums[i]);
                backtrack(res, list, i + 1, nums);
                list.remove(list.size() - 1);
            }
        }


    }



    /**
     * 70. 爬楼梯
     *
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     *
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    static class ClimbStairs {
        public static void test() {
            println(climbStairs(2));
            println(climbStairs(3));
            println(climbStairs(5));

            long start = System.currentTimeMillis();
            println(climbStairs(30));
            println((System.currentTimeMillis() - start) + "ms");
        }

//        public int climbStairs(int n) {
//
//            return 0;
//        }

        /**
         * 动态规划求解
         * dp[i] = dp[i - 1] + dp[i - 2]
         * @param n
         * @return
         */
        public static int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }

            int[] dp = new int[3];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[2] = dp[1] + dp[0];
                dp[0] = dp[1];
                dp[1] = dp[2];
            }

            return dp[1];
        }

        /**
         * 动态规划求解
         * dp[i] = dp[i - 1] + dp[i - 2]
         * @param n
         * @return
         */
        public static int climbStairs2(int n) {
            if (n <= 2) {
                return n;
            }

            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            println(dp);

            return dp[n - 1];
        }

        /**
         * 递归求法
         * @param n
         * @return
         */
        public static int climbStairs3(int n) {
            if (n <= 2) {
                return n;
            }

            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * 62. 不同路径
     *
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 问总共有多少条不同的路径？
     *
     *
     * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
     *
     * 说明：m 和 n 的值均不超过 100。
     *
     * 示例 1:
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     *
     * 示例 2:
     * 输入: m = 7, n = 3
     * 输出: 28
     */
    static class UniquePaths {
        public static void test() {
            println(uniquePaths(3, 2));
            println(uniquePaths(7, 3));
            long start = System.currentTimeMillis();
            println(uniquePaths(51, 9));
            println((System.currentTimeMillis() - start) + "ms");

        }

        /**
         * 观察动态规划算法的数组，会发现
         * p[j][m - 1] = sum p[j - 1][0 : m - 1]
         * 也就是说p[n - 1][m - 1] = sum p[n - 2][0 : m - 1]
         * 那么只需维护一个p[m]的数组，设列j的数组为p(j)[m], 则 p(j+1)[m] = sum(p(j)[0:m])
         */
        public static int uniquePaths(int m, int n) {
            if (m == 0 || n == 0) {
                return 0;
            }

            if (m == 1 || n == 1) {
                return 1;
            }

            int[] p = new int[m];
            for (int i = 0; i < m; i++) {
                p[i] = 1;
            }

            for (int j = 1; j < n; j++) {
                for (int i = 1; i < m; i++) {
                    p[i] += p[i - 1];
                }
            }

            return p[m - 1];
        }


        /**
         * 动态规划求解
         */
        public static int uniquePaths3(int m, int n) {
            if (m == 0 || n == 0) {
                return 0;
            }

            if (m == 1 || n == 1) {
                return 1;
            }
            /**
             * p[1][j] = 1
             * p[i][1] = 1
             * p[i][j] = p [j][i] （注意是否溢出）
             * p[i][j] = p[i][j - 1] + p[j][i - 1]
             */
            int[][] p = new int[n][m];

            for (int i = 0; i < m; i++) {
                p[0][i] = 1;
            }
            for (int j = 0; j < n; j++) {
                p[j][0] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (p[j][i] != 0) {
                        continue;
                    }
                    p[j][i] = p[j][i - 1] + p[j - 1][i];
                    if (j < m && i < n) {
                        p[i][j] = p[j][i];
                    }
                }
            }

            println(p);

            return p[n - 1][m - 1];
        }

        /**
         * 递归求法，性能较差~
         * p(m, n) = p(m, n - 1) + p(m - 1, n)
         */
        public static int uniquePaths2(int m, int n) {
            if (m == 0 || n == 0) {
                return 0;
            }

            if (m == 1 || n == 1) {
                return 1;
            }

            return uniquePaths(m, n -1) + uniquePaths(m - 1, n);
        }
    }

    /**
     * 61. 旋转链表
     *
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     *
     * 示例 2:
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     *
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class RotateRight {
        public static void test() {
            printListNode(rotateRight(buildListNode(new int[] {1, 2, 3, 4, 5}), 2));
            printListNode(rotateRight(buildListNode(new int[] {0, 1, 2}), 4));
        }

        /**
         * 若K为listNode长度的倍数，则链表不变，因此实际移动位数为 K % list.length
         * 且链表起始位置为链表的第 k % list.length 元素
         * 相当于将前面len - k个节点，移动到链表结尾
         */
        public static ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int len = 0;
            ListNode l = head;
            ListNode end = head;  //链表末尾
            while (l != null) {
                len++;
                end = l;
                l = l.next;
            }

            //实际需移动k位
            k = k % len;
            if (k == 0) {
                return head;
            }

            //相当于将前面len - k个节点，移动到链表结尾
            k = len - k;
            l = head;
            for (int i = 1; i < k; i++) {
                l = l.next;
            }

            end.next = head;
            head = l.next;
            l.next = null;

            return head;
        }
    }


    /**
     * 59. 螺旋矩阵 II
     *
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     *
     * 示例:
     * 输入: 3
     * 输出:
     * [
     *  [ 1, 2, 3 ],
     *  [ 8, 9, 4 ],
     *  [ 7, 6, 5 ]
     * ]
     *
     * 输入:4
     * 输出：
     *    [
     *       [1, 2, 3, 4],
     *       [5, 6, 7, 8],
     *       [9,10,11,12]
     *       [13,14,15,16]
     *     ]
     * 输出: [1,2,3,4,8,12,16,15,14,13, 9, 5, 6, 7, 11, 10]
     */
    static class GenerateMatrix {
        public static void test() {
            println(generateMatrix(1));
            println(generateMatrix(3));
            println(generateMatrix(4));
            println(generateMatrix(5));
            println(generateMatrix(9));
        }

        public static int[][] generateMatrix(int n) {
            if (n == 0) {
                return new int[0][0];
            }

            int[][] nums = new int[n][n];
            int startM = 0;
            int endM = n - 1;
            int startN = 0;
            int endN = n - 1;
            int k = 1;
            while (startM <= endM && startN <= endN) {
                for (int i = startN; i <= endN; i++) {
                    nums[startM][i] = k++;
                }

                if (startM == endM) {
                    break;
                }

                for (int j = startM + 1; j < endM; j++) {
                    nums[j][endN] = k++;
                }

                for (int i = endN; i >= startN; i--) {
                    nums[endM][i] = k++;
                }

                if (startN == endN) {
                    break;
                }

                for (int j = endM - 1; j > startM; j--) {
                    nums[j][startN] = k++;
                }

                startM++;
                endM--;
                startN++;
                endN--;
            }

            return nums;
        }

        /**
         *      * 输入: 3
         *      * 输出:
         *      * [
         *      *  [ 1, 2, 3 ],
         *      *  [ 8, 9, 4 ],
         *      *  [ 7, 6, 5 ]
         *      * ]
         */
        public int[][] generateMatrix2(int n) {
            int[][] res = new int[n][n];
            int index = 1;
            int rs = 0, re = n - 1;
            int cs = 0, ce = n - 1;
            while (index <= n * n) {
                for (int i = cs; i <= ce; i++) {
                    res[rs][i] = index++;
                }
                rs += 1;
                for (int i = rs; i <= re; i++) {
                    res[i][ce] = index++;
                }
                ce -= 1;
                for (int i = ce; i >= cs; i--) {
                    res[re][i] = index++;
                }
                re -= 1;
                for (int i = re; i >= rs; i--) {
                    res[i][cs] = index++;
                }
                cs += 1;
            }
            return res;
        }

    }


    /**
     * 54. 螺旋矩阵
     *  给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * 示例 1:
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     *
     * 示例 2:
     * 输入:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * 示例3：
     *     输入：
     *      *   [1, 2, 3, 4],
     *      *   [5, 6, 7, 8],
     *      *   [9,10,11,12]
     *          [13,14,15,16]
     *      * ]
     *      * 输出: [1,2,3,4,8,12,16,15,14,13, 9, 5, 6, 7, 11, 10]
     *
     */
    static class SpiralOrder {
        public static void test() {
            println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
            println(spiralOrder(new int[][] { {1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9,10,11,12 } }));
            println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }));
            println(spiralOrder(new int[][] { {  }, {  }, {  } }));
            println(spiralOrder(new int[][] { { 1 }, { 2 }, { 3 } }));
            println(spiralOrder(new int[][] { { 1, 2, 3 } }));
        }

        /**
         * 该问题可分解为如下子问题：
         *    每次从左上角第一个元素遍历最外一圈元素
         *    遍历完一圈后，继续遍历内圈，直至遍历完
         */
        public static List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new ArrayList<>(0);
            }
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> result = new ArrayList<>(m * n);
            int startM = 0;
            int endM = m - 1;
            int startN = 0;
            int endN = n - 1;
            while (endM >= startM && endN >= startN) {
                for (int i = startN; i <= endN; i++) {
                    result.add(matrix[startM][i]);
                }

                if (startM == endM) {
                    break;
                }

                for (int j = startM + 1; j < endM; j++) {
                    result.add(matrix[j][endN]);
                }

                if (startN == endN) {
                    break;
                }

                for (int i = endN; i >= startN; i--) {
                    result.add(matrix[endM][i]);
                }

                for (int j = endM - 1; j > startM; j--) {
                    result.add(matrix[j][startN]);
                }
                startM++;
                endM--;
                startN++;
                endN--;
            }
            return result;
        }
    }

    /**
     * 53. 最大子序和
     *
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 进阶:
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    static class MaxSubArray {
        public static void test() {
            println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
            println(maxSubArray(new int[] { 4, -1, 2, 1 }));
            println(maxSubArray(new int[] { -5 }));

            println(maxSubArray(new int[] { -5, -3, -6, -1 }));
            println(maxSubArray(new int[] { 1, 2, -1, -2, 2, 1, -2, 1 }));

        }

        public static int maxSubArray2(int[] nums) {
            int sum = 0;
            int maxSum = Integer.MIN_VALUE;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if (maxSum < sum) {
                    maxSum = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return maxSum;
        }

        /**
         * 分治法
         * 参考： https://blog.csdn.net/abnerwang2014/article/details/36027747
         */
        public static int maxSubArray(int[] nums) {
            return maxSubSum(nums, 0, nums.length - 1);
        }

        private static int maxSubSum(int[] nums, int left, int right) {
            if (left == right) {
                return nums[left];
            }

            int center = (left + right) / 2;
            int maxLeftSum = maxSubSum(nums, left, center);
            int maxRightSum = maxSubSum(nums, center + 1, right);

            int leftBoderSum = nums[center];
            int maxLeftBoderSum = nums[center];
            for (int i = center - 1; i >= left; i--) {
                leftBoderSum += nums[i];
                maxLeftBoderSum = maxLeftBoderSum < leftBoderSum ? leftBoderSum : maxLeftBoderSum;
            }

            int rightBoderSum = nums[center + 1];
            int maxRightBoderSum = nums[center + 1];
            for (int i = center + 2; i <= right; i++) {
                rightBoderSum += nums[i];
                maxRightBoderSum = maxRightBoderSum < rightBoderSum ? rightBoderSum : maxRightBoderSum;
            }

            int maxCrossSum = maxLeftBoderSum + maxRightBoderSum;
            return max3(maxLeftSum, maxRightSum, maxCrossSum);
        }
    }



    /**
     * 46. 全排列
     *
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */
    static class Permute {
        public static void test() {
            System.out.println(permute(new int[] {}));
            System.out.println(permute(new int[] {1}));
            System.out.println(permute(new int[] {1, 2, 3}));

            System.out.println(permute(new int[] {1, 3, 6, 2, 9, 11, 5}));

//            System.out.println(disPermute(new int[] {1, 2, 3}, 0, 3));
        }

        public static List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>(0);
            }
            int n = nums.length;
            List<List<Integer>> result = new ArrayList<>(getPermuteNum(n));
            if (n == 1) {
                ArrayList<Integer> list = new ArrayList<>(1);
                list.add(nums[0]);
                result.add(list);
                return result;
            }

            disPermute(nums, 0, n, result);

            return result;
        }

        /**
         * 递归求全排列
         */
        private static void disPermute(int[] nums, int start, int n, List<List<Integer>> result) {
            if (start == n - 1) {
//                result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                result.add(intArrToList(nums));
            } else {
                for (int i = start; i < n; i++) {
                    swap(nums, start, i);
                    disPermute(nums, start + 1, n, result);
                    swap(nums, start, i);
                }
            }
        }

        private static List<Integer> intArrToList(int[] nums) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            return list;
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        private static int getPermuteNum(int n) {
            int f = 1;
            for (int i = 2; i <= n; i++) {
                f *= i;
            }

            return f;
        }
    }


    /**
     * 43. 字符串相乘
     *
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     *
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */
    static class StrMultiply {
        public static void test() {
            println(multiply("2", "3"));
            println(multiply("9", "9"));
            println(multiply("123", "456"));   // 56088
            println(multiply("456", "23"));    // 10488
            println(multiply("999", "99"));    // 98901
            println(multiply("100", "100"));
            println(multiply("9133", "0"));
        }


        /**
         * 思路：采用乘法运算竖式来计算
         * 从后往前乘，即先乘低位
         * https://blog.csdn.net/dongyanwen6036/article/details/86100980
         */
        public static String multiply(String num1, String num2) {
            if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
                return "";
            }

            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();
            int n1 = chars1.length;
            int n2 = chars2.length;

            int[] cache = new int[n1 + n2 + 1];
            for (int j = n2 - 1; j >= 0; j--) {
                for (int i = n1 - 1; i >= 0; i--) {
                    int dot = (chars1[i] - '0') * (chars2[j] - '0') + cache[i + j + 2];
                    cache[i + j + 2] = dot % 10;
                    cache[i + j + 1] += dot / 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < cache.length && cache[i] == 0) {
                i++;
            }
            for (; i < cache.length; i++) {
                sb.append(cache[i]);
            }

            return sb.toString();
        }

        /**
         * 从前往后乘，即先乘高位，
         * @param num1
         * @param num2
         * @return
         */
        public String multiply2(String num1, String num2) {
            if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
                return "";
            }

            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();
            int n1 = chars1.length;
            int n2 = chars2.length;
            int[] cache = new int[n1 + n2 - 1];
            for (int j = 0; j < n2; j++) {
                for (int i = 0; i < n1; i++) {
                    cache[i + j] += (chars1[i] - '0') * (chars2[j] - '0');
                }
            }
            int add = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = cache.length - 1; i >= 0; i--) {
                int sum = cache[i] + add;
                sb.append(sum % 10);
                add = sum / 10;
            }

            if (add > 0) {
                sb.append(add);
            }
            sb.reverse();

            return sb.toString();
        }



    }


    /**
     * 33. 搜索旋转排序数组
     *
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     */
    static class SearchRotationSortedArray {

        public static void test() {
//            println(search(new int[] {  }, 9));   //-1
            println(search(new int[] { 9 }, 9)); //0
            println(search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7)); // 6
            println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)); // 4
            println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));  // -1
            println(search(new int[] { 4, 5, 6, 7, 8, 0, 1 }, 0));  //5
            println(search(new int[] { 8, 9, 1, 2, 3, 4, 5, 6, 7 }, 9)); //1
            println(search(new int[] { 8, 9, 1, 2, 3, 4, 5, 6, 7 }, 6)); // 7
            println(search(new int[] { 2,3,4,5,6,7,8,9,1 }, 9));  // 7
        }

        /**
         * 二分法求解，核心思想是每次找到有序的一半
         */
        public static int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    return mid;
                }

                if (nums[mid] < nums[right]) {   //右半部分有序
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {    //左半部分有序
                    if (target < nums[mid] && target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            return -1;
        }

        public static int search2(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int n = nums.length;
            int mid = n / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                int start = mid;
                while (--start >= 0) {
                    if (nums[start] == target) {
                        return start;
                    } else if (nums[start] > nums[start + 1]) {
                        break;
                    }
                }

                int end = n - 1;
                while (end > mid) {
                    if (nums[end] == target) {
                        return end;
                    }
                    end--;
                    if (nums[end] > nums[end + 1]) {
                        break;
                    }
                }
            } else {
                int start = 0;
                while (start < mid) {
                    if (nums[start] == target) {
                        return start;
                    }
                    start++;
                    if (nums[start] < nums[start - 1]) {
                        break;
                    }
                }

                int end = mid;
                while (++end < n) {
                    if (nums[end] == target) {
                        return end;
                    }
                    if (nums[end] < nums[end - 1]) {
                        break;
                    }
                }
            }

            return -1;
        }
    }


    /**
     *  26. 删除排序数组中的重复项
     *
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     *
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     *
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     *
     * 为什么返回数值是整数，但输出的答案是数组呢?
     *
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     */
    static class RemoveDuplicates {
        public static void test() {
            printRemoveDuplicatesArray(new int[] {0});
            printRemoveDuplicatesArray(new int[] {1});
            printRemoveDuplicatesArray(new int[] {1,1,2});
            printRemoveDuplicatesArray(new int[] {1,2,3});
            printRemoveDuplicatesArray(new int[] {0,0,1,1,1,2,2,3,3,4});
        }


        public static int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int j = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[j] = nums[i];
                    j++;
                }
            }

            return j;
        }

        private static void printRemoveDuplicatesArray(int nums[]) {
            int len = removeDuplicates(nums);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(nums[i] + " ");
            }
            println(sb.toString());
        }
    }



    /**
     * 将各个node的元素扔到一个数组，然后对数组排序，然后组成listNode
     * 时间复杂度：kn + kn*log(kn) + kn
     * 空间复杂度：k*n
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int len = 0;
        for (ListNode node : lists) {
            while (node != null) {
                len++;
                node = node.next;
            }
        }
        int[] nums = new int[len];
        int i = 0;
        for (ListNode node : lists) {
            while (node != null) {
                nums[i++] = node.val;
                node = node.next;
            }
        }

        Arrays.sort(nums);
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (Integer num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return head.next;
    }


    /**
     * 23. 合并 k 个排序链表
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     *
     */
    static class MergeKLists {
        public static void test() {
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(4);
            l1.next.next = new ListNode(5);

            ListNode l2 = new ListNode(1);
            l2.next = new ListNode(3);
            l2.next.next = new ListNode(4);

            ListNode l3 = new ListNode(2);
            l3.next = new ListNode(6);

            ListNode[] lists = new ListNode[3];
            lists[0] = l1;
            lists[1] = l2;
            lists[2] = l3;

            printListNode(mergeKLists2(lists));

            ListNode[] listNodes = new ListNode[2];
            printListNode(mergeKLists2(listNodes));
        }

        /**
         * 将各个node的元素扔到一个数组，然后对数组排序，然后组成listNode
         * 时间复杂度：kn + kn*log(kn) + kn
         * 空间复杂度：k*n
         * @param lists
         * @return
         */
        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            int len = 0;
            for (ListNode node : lists) {
                while (node != null) {
                    len++;
                    node = node.next;
                }
            }
            int[] nums = new int[len];
            int i = 0;
            for (ListNode node : lists) {
                while (node != null) {
                    nums[i++] = node.val;
                    node = node.next;
                }
            }

            Arrays.sort(nums);
            ListNode head = new ListNode(0);
            ListNode temp = head;
            for (Integer num : nums) {
                temp.next = new ListNode(num);
                temp = temp.next;
            }

            return head.next;
        }

//        /**
//         * 将各个node的元素扔到一个数组，然后对数组排序，然后组成listNode
//         * 时间复杂度：kn + kn*log(kn) + kn
//         * 空间复杂度：k*n
//         * @param lists
//         * @return
//         */
//        public static ListNode mergeKLists(ListNode[] lists) {
//            if (lists == null || lists.length == 0) {
//                return null;
//            }
//
//            List<Integer> nums = new ArrayList<>();
//            for (ListNode node : lists) {
//                while (node != null) {
//                    nums.add(node.val);
//                    node = node.next;
//                }
//            }
//
//            Collections.sort(nums);
//            ListNode head = new ListNode(0);
//            ListNode temp = head;
//            for (Integer num : nums) {
//                temp.next = new ListNode(num);
//                temp = temp.next;
//            }
//
//            return head.next;
//        }

        /**
         * 二分法合并
         * 每次仅合并相邻的node，依次类推
         * 时间复杂度为 2n * k/2 + 4n * k/4 + ... +
         * 时间复杂度   O(kn * log2k)
         * @param lists
         * @return
         */
        public static ListNode mergeKLists2(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            int mid = lists.length / 2;
            int len = lists.length;

            while(len>1) {
                for (int i=0; i<len/2; i++) {
                    lists[i] = mergeTwoNode(lists[i], lists[len-1-i]);
                }
                len = (len+1)/2;
            }


//            while (mid > 0) {
//                for (int i = 0; i < mid; i++) {
//                    lists[i] = mergeTwoNode(lists[i], lists[mid + i]);  //按这种计算方式，如果len为奇数，则会漏掉最后一个
//                }
//                if (len % 2 != 0) {
//                    lists[mid - 1] = mergeTwoNode(lists[mid - 1], lists[2 * mid]);
//                }
//                len = mid;
//                mid = mid / 2;
//            }

            return lists[0];
        }

        /**
          * 暴力解法，从第一个node开始，依次与后面每个node合并
         * 假设k个node，每个node长度都为n， 则时间复杂度为 2n + 3n + 4n + .... + kn
         *  O ((k(k+1) / 2 - 1) * n)
         */
        public static ListNode mergeKLists3(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            int i = 0;
            ListNode result = lists[0];
            for (i = 1; i < lists.length; i++) {
                result = mergeTwoNode(result, lists[i]);
            }

            return result;
        }

        private static ListNode mergeTwoNode(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }

            if (l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = mergeTwoNode(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoNode(l1, l2.next);
                return l2;
            }
        }

    }

    /**
     * 21.  合并两个有序链表
     *
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    static class MergeTwoLists {
        public static void test() {
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(2);
            l1.next.next = new ListNode(4);

            ListNode l2 = new ListNode(1);
            l2.next = new ListNode(3);
            l2.next.next = new ListNode(4);

            printListNode(mergeTwoLists(l1, l2));

        }

        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }

        public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            ListNode head = new ListNode(0);
            ListNode l = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    l.next = l1;
                    l = l.next;
                    l1 = l1.next;
                } else {
                    l.next = l2;
                    l = l.next;
                    l2 = l2.next;
                }
            }

            if (l1 != null) {
                l.next = l1;
            }

            if (l2 != null) {
                l.next = l2;
            }

            return head.next;
        }

//        public static class ListNode {
//            int val;
//
//            ListNode next;
//
//            ListNode(int x) {
//                val = x;
//            }
//        }

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

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void printListNode(ListNode l) {
        if (l == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append(l.val);
        l = l.next;
        while (l != null) {
            sb.append("->").append(l.val);
            l = l.next;
        }

        println(sb.toString());
    }

    /**
     * 将数组转换为ListNode
     * @param nums
     * @return
     */
    public static ListNode buildListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode l = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            l.next = next;
            l = next;
        }

        return head;
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

    private static void printListNodeVal(ListNode node) {
        if (node == null) {
            System.out.println("null");
        } else {
            System.out.println(node.val);
        }
    }

    private static void println(int[][] nums) {
        if (nums == null) {
            println("null");
        }
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < nums.length; i++) {
            sb.append("  [");
            for (int j = 0; j < nums[0].length; j++) {
                sb.append(nums[i][j]).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("],\n");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("]");
        println(sb.toString());
    }

    private static void println(int[] nums) {
        if (nums == null) {
            println("null");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j = 0; j < nums.length; j++) {
            sb.append(nums[j]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        println(sb.toString());
    }

    private static int max(int a, int b) {
        return a >= b ? a : b;
    }

    private static int max3(int a, int b, int c) {
        a = a > b ? a : b;
        a = a > c ? a : c;
        return a;
    }

    private static int max4(int a, int b, int c, int d) {
        a = a > b ? a : b;
        a = a > c ? a : c;
        a = a > d ? a : d;
        return a;
    }

    /**
     * 将数组转换为ListNode
     * [3,9,20,null,null,15,7]，
     *           3
     *          / \
     *         9  20
     *           /  \
     *          15   7
     */
    public static TreeNode buildTreeNode(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        TreeNode t = root;
        int depth = (int)(Math.log(nums.length + 1) / Math.log(2));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int k = 1;
        for (int i = 0; i < depth; i++) {
            if (k >= nums.length) {
                break;
            }

            int n = (int)Math.pow(2, i);
            for (int j = 1; j <= n; j++) {
                if (list.isEmpty()) {
                    break;
                }
                TreeNode node = list.pop();
                if (node == null) {
                    k += 2;
                    continue;
                }
                Integer left = k < nums.length ? nums[k++] : null;
                Integer right = k < nums.length ? nums[k++] : null;
                if (left != null) {
                    node.left = new TreeNode(left);
                    list.add(node.left);
                } else {
                    list.add(null);
                }
                if (right != null) {
                    node.right = new TreeNode(right);
                    list.add(node.right);
                } else {
                    list.add(null);
                }
            }
        }
        return root;
    }

    /**
     * 构建相交链表~
     * @param a 链表a数组
     * @param b 链表b数组
     * @param skipA a相交位置
     * @param skipB b相交位置
     * @return
     */
    private static Pair<ListNode, ListNode> buildCrossList(int[] a, int b[], int skipA, int skipB) {
        if (skipA < 0 || skipB < 0) {
            return new Pair<>(buildListNode(a), buildListNode(b));
        }
        ListNode listA = new ListNode(-1);
        ListNode listB = new ListNode(-1);
        ListNode ahead = listA;
        ListNode bhead = listB;
        for (int i = 0; i < skipA; i++) {
            ahead.next = new ListNode(a[i]);
            ahead = ahead.next;
        }

        for (int i = 0; i < skipB; i++) {
            bhead.next = new ListNode(b[i]);
            bhead = bhead.next;
        }

        ListNode cross = new ListNode(a[skipA]);
        ahead.next = cross;
        bhead.next = cross;
        for (int i = skipA + 1; i < a.length; i++) {
            cross.next = new ListNode(a[i]);
            cross = cross.next;
        }

        return new Pair<>(listA.next, listB.next);
    }

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     *
     *
     *  
     *
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */



}
