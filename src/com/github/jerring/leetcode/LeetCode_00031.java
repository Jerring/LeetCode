package com.github.jerring.leetcode;

public class LeetCode_00031 {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 1.从后往前找到第一组位置，满足 nums[i] < nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }
        if (i >= 0) {
            int j = n - 1;
            // 2.从后往前找到第一个位置，满足 nums[i] < nums[j]
            while (nums[i] >= nums[j]) {
                --j;
            }
            // 3.交换 i、j 两处的值
            swap(nums, i, j);
        }
        // 4.反转从位置 i + 1 开始到末尾的序列
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void reverse(int[] a, int i, int j) {
        while (i < j) {
            swap(a, i++, j--);
        }
    }
}
