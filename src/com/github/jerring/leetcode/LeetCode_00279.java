package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_00279 {

    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        // 访问标志，用于剪枝
        boolean[] vis = new boolean[n + 1];
        vis[n] = true;
        queue.offer(n);
        int level = 0;
        while (!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            while (size-- != 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    // 剪枝（之前出现过现在出现不可能达到最小）
                    if (vis[next]) {
                        continue;
                    }
                    vis[next] = true;
                    queue.offer(next);
                }
            }
        }
        return n;
    }

    /**
     * 生成 n 以内的完全平方数
     * @param n 输入
     * @return  平方数的集合
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
