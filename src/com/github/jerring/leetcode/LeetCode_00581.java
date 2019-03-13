package com.github.jerring.leetcode;

public class LeetCode_00581 {

//    public int findUnsortedSubarray(int[] nums) {
//        int[] sortedNums = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(sortedNums);
//        int i = 0;
//        int j = nums.length - 1;
//        while (i <= j && nums[i] == sortedNums[i]) {
//            ++i;
//        }
//        while (i <= j && nums[j] == sortedNums[j]) {
//            --j;
//        }
//        return j - i + 1;
//    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];      // 从左往右的最大值
        int min = nums[n - 1];  // 从右往左的最小值
        int l = -1;             // 需要调整的左边界
        int r = -2;             // 需要调整的右边界
        for (int i = 1; i < n; ++i) {
            max = Math.max(max, nums[i]);
            if (nums[i] != max) {
                r = i;          // 从 r 向左单独调整，数组可以变为有序
            }
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[n - 1 - i] != min) {
                l = n - 1 - i;  // 从 l 向右单独调整，数组可以变为有序
            }
        }
        // 数组已经有序时，l、r 不会变化（初始化为 -1、-2 避免单独判断）
        return r - l + 1;       // 调整 [l, r]，数组可以变为有序
    }
}
