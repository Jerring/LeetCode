package com.github.jerring.leetcode;

public class LeetCode_00167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int s = numbers[i] + numbers[j];
            if (s < target) {
                ++i;
            } else if (s > target) {
                --j;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }
        return null;
    }
}
