package com.github.jerring.leetcode;

public class LeetCode_00239 {

//    // 单调队列
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k <= 0) {
//            return new int[0];
//        }
//        int[] res = new int[nums.length - k + 1];
//        int index = 0;
//        Deque<Integer> q = new ArrayDeque<>(k);
//        for (int i = 0; i < nums.length; ++i) {
//            // 保持队列的单调性（严格从大到小）
//            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
//                q.pollLast();
//            }
//            q.offerLast(i);
//            // 删除过期元素
//            if (i - q.peekFirst() >= k) {
//                q.pollFirst();
//            }
//            if (i >= k - 1) {
//                res[index++] = nums[q.peekFirst()];
//            }
//        }
//        return res;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        // left 从左向右传播
        int[] left = new int[n];
        // right 从右向左传播
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            left[i] = (i % k == 0) ? nums[i] : Math.max(left[i - 1], nums[i]);
            int j = n - 1 - i;
            right[j] = (j % k == 0) ? nums[j] : Math.max(right[j + 1], nums[j]);
        }
        int[] res = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i + k <= n; ++i) {
            res[index++] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }
}
