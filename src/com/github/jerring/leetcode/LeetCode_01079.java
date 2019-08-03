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
//        Set<String> set = new HashSet<>();
//        dfs(tiles.toCharArray(), 0, set);
//        return set.size();
//    }
//
//    private void dfs(char[] cs, int s, Set<String> set) {
//        if (s >= 1) {
//            set.add(String.valueOf(cs, 0, s));
//        }
//        for (int i = s; i < cs.length; ++i) {
//            swap(cs, s, i);
//            dfs(cs, s + 1, set);
//            swap(cs, s, i);
//        }
//    }
//
//    private void swap(char[] cs, int i, int j) {
//        char tmp = cs[i];
//        cs[i] = cs[j];
//        cs[j] = tmp;
//    }
}
