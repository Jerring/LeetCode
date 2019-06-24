package com.github.jerring.leetcode;

public class LeetCode_00274 {

//    public int hIndex(int[] citations) {
//        Arrays.sort(citations);
//        int res = 0;
//        for (int i = 0; i < citations.length; ++i) {
//            if (citations[i] >= citations.length - i) {
//                return citations.length - i;
//            }
//        }
//        return 0;
//    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        // 记录对应的引用次数
        int[] cnt = new int[n + 1];
        for (int c : citations) {
            if (c <= n) {   // <= n 直接记录
                ++cnt[c];
            } else {        // > n 记为 n
                ++cnt[n];
            }
        }
        // 从大到小遍历，满足要求就直接返回
        int sum = 0;
        for (int i = n; i >= 0; --i) {
            sum += cnt[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
