package com.github.jerring.leetcode;

public class LeetCode_00881 {

//    public int numRescueBoats(int[] people, int limit) {
//        Arrays.sort(people);
//        int res = 0;
//        int i = 0, j = people.length - 1;
//        while (i <= j) {
//            ++res;
//            if (people[i] + people[j] <= limit) {
//                ++i;
//            }
//            --j;
//        }
//        return res;
//    }

    public int numRescueBoats(int[] people, int limit) {
        int[] bucket = new int[limit + 1];
        for (int p : people) {
            ++bucket[p];
        }
        int res = 0;
        int i = 0, j = limit;
        while (i <= j) {
            while (i <= j && bucket[i] <= 0) {
                ++i;
            }
            while (i <= j && bucket[j] <= 0) {
                --j;
            }
            if (bucket[i] == 0 && bucket[j] <= 0) {
                break;
            }
            if (i + j <= limit) {
                --bucket[i];
            }
            --bucket[j];
            ++res;
        }
        return res;
    }
}
