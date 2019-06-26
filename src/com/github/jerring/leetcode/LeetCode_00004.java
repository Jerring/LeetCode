package com.github.jerring.leetcode;

public class LeetCode_00004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if ((total & 1) == 0) {
            int left = findKthNumber(nums1, 0, nums2, 0, total / 2);
            int right = findKthNumber(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        } else {
            return findKthNumber(nums1, 0, nums2, 0, total / 2 + 1);
        }
    }

    private int findKthNumber(int[] nums1, int i, int[] nums2, int j, int k) {
        if (nums1.length - i > nums2.length - j) {  // 保证 nums1 为长度较小者
            return findKthNumber(nums2, j, nums1, i, k);
        }
        if (nums1.length == i) {                    // nums1 区间为空
            return nums2[j + k - 1];
        }
        if (k == 1) {                               // 取两者第一个元素进行比较
            return Math.min(nums1[i], nums2[j]);
        }
        int si = Math.min(i + k / 2, nums1.length), sj = j + k / 2;
        if (nums1[si - 1] > nums2[sj - 1]) {
            return findKthNumber(nums1, i, nums2, sj, k - k / 2);
        } else {
            return findKthNumber(nums1, si, nums2, j, k - (si - i));
        }
    }
}
