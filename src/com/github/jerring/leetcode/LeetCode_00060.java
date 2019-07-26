package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00060 {

//    public String getPermutation(int n, int k) {
//        char[] cs = new char[n];
//        for (int i = 0; i < n; ++i) {
//            cs[i] = (char) ('1' + i);
//        }
//        while (--k > 0) {
//            nextPermutation(cs, n);
//        }
//        return String.valueOf(cs);
//    }
//
//    private void nextPermutation(char[] cs, int n) {
//        int i = n - 2;
//        while (i >= 0 && cs[i] >= cs[i + 1]) {
//            --i;
//        }
//        if (i >= 0) {
//            int j = n - 1;
//            while (cs[i] >= cs[j]) {
//                --j;
//            }
//            swap(cs, i, j);
//            reverse(cs, i + 1, n - 1);
//        }
//    }
//
//    private void reverse(char[] cs, int i, int j) {
//        while (i < j) {
//            swap(cs, i++, j--);
//        }
//    }
//
//    private void swap(char[] cs, int i, int j) {
//        char tmp = cs[i];
//        cs[i] = cs[j];
//        cs[j] = tmp;
//    }

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            list.add(i);
        }
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] * i;
        }
        --k;
        StringBuilder sb = new StringBuilder(n);
        for (int i = n - 1; i >= 0; --i) {
            int j = k / f[i];
            k %= f[i];
            sb.append(list.remove(j));
        }
        return sb.toString();
    }
}
