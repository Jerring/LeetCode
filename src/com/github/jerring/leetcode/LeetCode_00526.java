package com.github.jerring.leetcode;

public class LeetCode_00526 {

//    public int countArrangement(int N) {
//        int maxn = 1 << N;
//        int[] f = new int[maxn];
//        f[0] = 1;
//        for (int i = 0; i < maxn; ++i) {
//            int s = 1;
//            for (int j = 0; j < N; ++j) {
//                s += (i >> j) & 1;
//            }
//            for (int j = 1; j <= N; ++j) {
//                if (((i >> (j - 1) & 1) == 0) && (s % j == 0 || j % s == 0)) {
//                    f[i | (1 << (j - 1))] += f[i];
//                }
//            }
//        }
//        return f[maxn - 1];
//    }

    public int countArrangement(int N) {
        int[] arr = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            arr[i] = i;
        }
        return dfs(arr, N);
    }

    private int dfs(int[] arr, int s) {
        if (s == 0) {
            return 1;
        }
        int res = 0;
        for (int i = s; i > 0; --i) {
            swap(arr, s, i);
            if (arr[s] % s == 0 || s % arr[s] == 0) {
                res += dfs(arr, s - 1);
            }
            swap(arr, s, i);
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

//    public int countArrangement(int N) {
//        boolean[] vis = new boolean[N + 1];
//        return dfs(N, 1, vis);
//    }
//
//    private int dfs(int N, int s, boolean[] vis) {
//        if (s > N) {
//            return 1;
//        }
//        int res = 0;
//        for (int i = 1; i <= N; ++i) {
//            if (!vis[i] && (s % i == 0 || i % s == 0)) {
//                vis[i] = true;
//                res += dfs(N, s + 1, vis);
//                vis[i] = false;
//            }
//        }
//        return res;
//    }
}
