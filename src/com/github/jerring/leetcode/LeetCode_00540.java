package com.github.jerring.leetcode;

public class LeetCode_00540 {

    public int singleNonDuplicate(int[] nums) {
        // 可能的上下限
        int lo = 0;
        int hi = nums.length - 1;
        // 缩小范围直至只有一个元素
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // 将奇数下标变为偶数下标
            if ((mid & 1) == 1) {
                --mid;
            }
            if (nums[mid] == nums[mid + 1]) {   // 说明 mid 之前都是元素成对存在的，单个元素在后面
                lo = mid + 2;
            } else {                            // 说明单个元素下标不超过 mid
                hi = mid;
            }
        }
        return nums[lo];
    }

//    public int singleNonDuplicate(int[] nums) {
//        int res = 0;
//        for (int num : nums) {
//            res ^= num;
//        }
//        return res;
//    }
}
