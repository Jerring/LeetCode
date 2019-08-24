package com.github.jerring.leetcode;

public class LeetCode_00918 {

//    public int maxSubarraySumCircular(int[] A) {
//        int n = A.length;
//        int[] sum = new int[2 * n + 1];
//        for (int i = 1; i <= 2 * n; ++i) {
//            if (i <= n) {
//                sum[i] = sum[i - 1] + A[i - 1];
//            } else {
//                sum[i] = sum[i - 1] + A[i - n - 1];
//            }
//        }
//        Deque<Integer> q = new ArrayDeque<>();
//        q.offerLast(0);
//        int res = A[0];
//        for (int i = 1; i <= 2 * n; ++i) {
//            if (!q.isEmpty() && i - q.peekFirst() > n) {
//                q.pollFirst();
//            }
//            res = Math.max(res, sum[i] - sum[q.peekFirst()]);
//            while (!q.isEmpty() && sum[i] <= sum[q.peekLast()]) {
//                q.pollLast();
//            }
//            q.offerLast(i);
//        }
//        return res;
//    }

    public int maxSubarraySumCircular(int[] A) {
        int tot = 0;
        int curMax = 0;
        int maxSum = Integer.MIN_VALUE;
        int curMin = 0;
        int minSum = Integer.MAX_VALUE;
        for (int x : A) {
            tot += x;
            curMax = Math.max(curMax + x, x);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + x, x);
            minSum = Math.min(minSum, curMin);
        }
        return maxSum > 0 ? Math.max(maxSum, tot - minSum) : maxSum;
    }
}
