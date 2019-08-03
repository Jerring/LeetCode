package com.github.jerring.leetcode;

public class LeetCode_01079 {

    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (char c : tiles.toCharArray()) {
            ++cnt[c - 'A'];
        }
        return dfs(cnt);
    }

    private int dfs(int[] cnt) {
        int res = 0;
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                --cnt[i];
                ++res;
                res += dfs(cnt);
                ++cnt[i];
            }
        }
        return res;
    }

//    public int numTilePossibilities(String tiles) {
//        return dfs(tiles.toCharArray(), 0);
//    }
//
//    private int dfs(char[] cs, int s) {
//        int res = 0;
//        for (int i = s; i < cs.length; ++i) {
//            if (isDuplicate(cs, s, i)) {
//                continue;
//            }
//            swap(cs, s, i);
//            ++res;
//            res += dfs(cs, s + 1);
//            swap(cs, s, i);
//        }
//        return res;
//    }
//
//    private boolean isDuplicate(char[] cs, int s, int e) {
//        for (int i = s; i < e; ++i) {
//            if (cs[i] == cs[e]) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void swap(char[] cs, int i, int j) {
//        char tmp = cs[i];
//        cs[i] = cs[j];
//        cs[j] = tmp;
//    }
}
