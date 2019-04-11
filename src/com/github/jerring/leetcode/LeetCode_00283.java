package com.github.jerring.leetcode;

public class LeetCode_00283 {

//    public void moveZeroes(int[] nums) {
//        int index = 0;
//        for (int num : nums) {
//            if (num != 0) {
//                nums[index++] = num;
//            }
//        }
//        for (int i = index; i < nums.length; ++i) {
//            nums[i] = 0;
//        }
//    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                swap(nums, index++, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
