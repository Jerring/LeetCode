package com.github.jerring.leetcode;

public class LeetCode_00034 {

//    public int[] searchRange(int[] nums, int target) {
//        // 找到数组中第一个大于或等于 target 的元素的下标
//        int left = lowerBound(nums, target);
//        // 如果数组中存在等于 target 的元素，则寻找数组中第一个大于 target 的元素的下标
//        if (left < nums.length && nums[left] == target) {
//            int right = upperBound(nums, target);
//            return new int[] { left, right - 1 };
//        }
//        // 数组中不存在目标值，返回 [-1, -1]
//        return new int[] { -1, -1 };
//    }
//
//    /**
//     * 返回数组中第一个大于或等于 target 的元素的下标。
//     * 若数组中元素均小于 target，则返回数组最后一个元素的下一个位置的下标。
//     * @param nums 已排序数组
//     * @param target 目标值
//     * @return 第一个大于或等于 target 的元素的下标
//     */
//    private int lowerBound(int[] nums, int target) {
//        int lo = 0;
//        int hi = nums.length;
//        while (lo < hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (nums[mid] < target) {
//                lo = mid + 1;
//            } else {
//                hi = mid;
//            }
//        }
//        return lo;
//    }
//
//    /**
//     * 返回数组中第一个大于 target 的元素的下标。
//     * 若数组中元素均小于或等于 target，则返回数组最后一个元素的下一个位置的下标。
//     * @param nums 已排序数组
//     * @param target 目标值
//     * @return 第一个大于 target 的元素的下标
//     */
//    private int upperBound(int[] nums, int target) {
//        int lo = 0;
//        int hi = nums.length;
//        while (lo < hi) {
//            int mid = lo + (hi - lo) / 2;
//            if (nums[mid] <= target) {
//                lo = mid + 1;
//            } else {
//                hi = mid;
//            }
//        }
//        return lo;
//    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = first(nums, target);
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = last(nums, target);
        return new int[]{left, right};
    }

    private int first(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    private int last(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >>> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return r;
    }
}
