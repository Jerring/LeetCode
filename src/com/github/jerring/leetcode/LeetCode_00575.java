package com.github.jerring.leetcode;

public class LeetCode_00575 {

//    public int distributeCandies(int[] candies) {
//        int max = candies.length >> 1;
//        Set<Integer> set = new HashSet<>();
//        for (int candy : candies) {
//            set.add(candy);
//            if (set.size() >= max) {
//                return max;
//            }
//        }
//        return set.size();
//    }

    public int distributeCandies(int[] candies) {
        int max = candies.length >> 1;
        boolean[] vis = new boolean[200001];
        int res = 0;
        for (int candy : candies) {
            if (!vis[candy + 100000]) {
                vis[candy + 100000] = true;
                if (++res == max) {
                    return max;
                }
            }
        }
        return res;
    }
}
