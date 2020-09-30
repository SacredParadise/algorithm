package com.xl.algorithm.leecode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MediaInArray {
    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2, 3 }, new int[] { 3, 4 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2, 3, 4 }, new int[] { 3, 4 }));
        System.out.println(findMedianSortedArrays(new int[] {  }, new int[] { 1 }));
        System.out.println(findMedianSortedArrays(new int[] {  }, new int[] { 2, 3 }));
    }


    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }





    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) >> 1;
        int right = (len1 + len2 + 2) >> 1;

        return (getKth(nums1, 0, nums2, 0, left) + getKth(nums1, 0, nums2, 0, right)) * 0.5;
    }

    /**
     * 寻得K小的数字
     */
    private static int getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;

        if (len1 > len2) {
            return getKth(nums2, start2, nums1, start1, k);
        }

        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return nums1[start1] < nums2[start2] ? nums1[start1] : nums2[start2];
        }

        int k2 = k >> 1;
        int i = start1 + (len1 < k2 ? len1 : k2) - 1;
        int j = start2 + (len2 < k2 ? len2 : k2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, nums2, j + 1, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, nums2, start2, k - (i - start1 + 1));
        }
    }



    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int loc1 = 0;
        int loc2 = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i <= len >> 1; i++) {
            left = right;
            if (loc1 < len1 && (loc2 >= len2 || nums1[loc1] < nums2[loc2])) {
                right = nums1[loc1++];
            } else {
                right = nums2[loc2++];
            }
        }

        if ((len & 1) == 1) {
            return right;
        } else {
            return (left + right) / 2.0;
        }
    }

    public double findMedianSortedArrays4(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j - 1] > A[i]) { // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) { // i 需要减小
                iMax = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }

}
