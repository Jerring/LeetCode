package com.github.jerring.leetcode;

public class LeetCode_00547 {

//    // 并查集
//    public int findCircleNum(int[][] M) {
//        int n = M.length;
//        UnionFind uf = new UnionFind(n);
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < i; ++j) {
//                if (M[i][j] == 1) {
//                    uf.union(i, j);
//                }
//            }
//        }
//        return uf.count();
//    }
//
//    private class UnionFind {
//        private int[] f;
//        private int count;
//
//        public UnionFind(int n) {
//            f = new int[n];
//            for (int i = 0; i < n; ++i) {
//                f[i] = i;
//            }
//            count = n;
//        }
//
//        private int find(int x) {
//            if (x != f[x]) {
//                f[x] = find(f[x]);
//            }
//            return f[x];
//        }
//
//        public void union(int p, int q) {
//            int i = find(p);
//            int j = find(q);
//            if (i != j) {
//                f[i] = j;
//                --count;
//            }
//        }
//
//        public int count() {
//            return count;
//        }
//    }


    // DFS
    public int findCircleNum(int[][] M) {
        int res = 0;
        // 访问标志
        boolean[] vis = new boolean[M.length];
        for (int i = 0; i < M.length; ++i) {
            // 没有访问过
            if (!vis[i]) {
                ++res;
                dfs(M, vis, i);
            }
        }
        return res;
    }

    private void dfs(int[][] m, boolean[] vis, int i) {
        vis[i] = true;
        for (int j = 0; j < m[i].length; ++j) {
            // 没有访问过且 i、j 为朋友
            if (!vis[j] && m[i][j] == 1) {
                dfs(m, vis, j);
            }
        }
    }
}
