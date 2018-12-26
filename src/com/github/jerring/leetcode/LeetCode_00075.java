package com.github.jerring.leetcode;

public class LeetCode_00075 {

    /**
     * 维护一个指针 l 使得 nums[0, l) 中的元素都小于 1
     * 维护一个指针 r 使得 nums[r, nums.length) 中的元素都大于 1
     * 运用一个指针 i 进行遍历，nums[i, r) 是待调整的区间，其他区间已调整
     * @param nums
     */
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length;
        int i = 0;
        while (i < r) {
            if (nums[i] < 1)        swap(nums, i++, l++);
            else if (nums[i] > 1)   swap(nums, i, --r);
            else                    ++i;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
