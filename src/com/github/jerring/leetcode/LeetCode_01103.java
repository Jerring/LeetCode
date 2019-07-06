package com.github.jerring.leetcode;

public class LeetCode_01103 {

//    public int[] distributeCandies(int candies, int num_people) {
//        int[] res = new int[num_people];
//        for (int i = 0, cur = 1; candies > 0; ++i, ++cur) {
//            if (i == num_people) {
//                i = 0;
//            }
//            if (candies >= cur) {
//                res[i] += cur;
//                candies -= cur;
//            } else {
//                res[i] += candies;
//                candies = 0;
//            }
//        }
//        return res;
//    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int m = (int) Math.sqrt(candies * 2);
        if ((long) m * (m + 1) / 2 > candies) {
            --m;
        }
        int left = candies - m * (m + 1) / 2;
        for (int i = 0; i < num_people; ++i) {
            int t = m / num_people + (i < m % num_people ? 1 : 0);
            res[i] = t * (i + 1) + t * (t - 1) / 2 * num_people;
        }
        res[m % num_people] += left;
        return res;
    }
}

