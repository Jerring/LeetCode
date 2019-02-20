package com.github.jerring.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_00139 {

//    // DP(完全背包)
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int n = s.length();
//        boolean[] dp = new boolean[n + 1];
//        dp[0] = true;
//        for (int i = 1; i <= n; ++i) {
//            for (String word : wordDict) {
//                int preIndex = i - word.length();
//                if (preIndex >= 0 && dp[preIndex] && word.equals(s.substring(preIndex, i))) {
//                    dp[i] = dp[preIndex];
//                }
//            }
//        }
//        return dp[n];
//    }

    // DP(完全背包)
    public boolean wordBreak(String s, List<String> wordDict) {
        // 转换为 HashSet 方便查找
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j >= 0; --j) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

//    // DFS + 剪枝（设置访问标志）
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (s == null || s.length() == 0) {
//            return false;
//        }
//        boolean[] vis = new boolean[s.length() + 1];
//        return dfs(s, 0, wordDict, vis);
//    }
//
//    private boolean dfs(String s, int offset, List<String> wordDict, boolean[] vis) {
//        if (offset == s.length()) {
//            return true;
//        }
//        vis[offset] = true;
//        for (String word : wordDict) {
//            // startWith 放前面先判断（offset + word.length() 可能会越界）
//            if (s.startsWith(word, offset) && !vis[offset + word.length()]) {
//                if (dfs(s, offset + word.length(), wordDict, vis)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
