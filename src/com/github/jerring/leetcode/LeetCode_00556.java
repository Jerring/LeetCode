package com.github.jerring.leetcode;

public class LeetCode_00556 {

    public int nextGreaterElement(int n) {
        if (n < 12) {
            return -1;
        }
        char[] cs = String.valueOf(n).toCharArray();
        // 1.从后往前找到第一组位置，满足 nums[i] < nums[i + 1]
        int i = cs.length - 2;
        while (i >= 0 && cs[i] >= cs[i + 1]) {
            --i;
        }
        // 不存在下一个更大元素，数组中每一位从左往右递减
        if (i < 0) {
            return -1;
        }
        // 2.从后往前找到第一个位置，满足 nums[i] < nums[j]
        int j = cs.length - 1;
        while (cs[i] >= cs[j]) {
            --j;
        }
        // 3.交换 i、j 两处的值
        swap(cs, i, j);
        // 4.反转从位置 i + 1 开始到末尾的序列
        reverse(cs, i + 1, cs.length - 1);
//        int res = 0;
//        for (char c : cs) {
//            // 防溢出
//            int t = c - '0';
//            if (res > (Integer.MAX_VALUE - t) / 10) {
//                return -1;
//            }
//            res = res * 10 + t;
//        }
//        return res;
        long res = 0;
        for (char c : cs) {
            res = res * 10 + c - '0';
        }
        return res <= Integer.MAX_VALUE ? (int) res : -1;
    }

    private void reverse(char[] cs, int i, int j) {
        while (i < j) {
            swap(cs, i++, j--);
        }
    }

    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
