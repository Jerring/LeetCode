package com.github.jerring.leetcode;

public class LeetCode_00153 {

    public int findMin(int[] nums) {
        // 可能的上下限
        int l = 0, r = nums.length - 1;
        // 缩小区间直至只有一个元素
        while (l < r) {
            int mid = l + r >>> 1;
            if (nums[mid] <= nums[r]) r = mid;  // 说明 mid 之后的元素都不可能是最小值
            else l = mid + 1;                   // 说明 mid 及之前的元素都不可能是最小值
        }
        return nums[r];
    }

//    public int findMin(int[] nums) {
//        if (nums.length == 1) {     // 只有一个元素直接返回
//            return nums[0];
//        }
//        int lo = 0;
//        int hi = nums.length - 1;
//        if (nums[0] < nums[hi]) {   // 没有旋转，整个序列是升序的
//            return nums[0];
//        }
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (nums[mid] > nums[mid + 1]) {    // nums[mid] 是最大值
//                return nums[mid + 1];
//            }
//            if (nums[mid - 1] > nums[mid]) {    // nums[mid-1] 是最大值
//                return nums[mid];
//            }
//            if (nums[mid] > nums[lo]) {         // lo 和 mid 在同一边
//                lo = mid + 1;
//            } else {                            // lo 和 mid 不在同一边
//                hi = mid - 1;
//            }
//        }
//        return -1;
//    }
}
