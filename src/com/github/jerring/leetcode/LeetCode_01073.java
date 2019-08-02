package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_01073 {

//    public int[] addNegabinary(int[] arr1, int[] arr2) {
//        List<Integer> list = new ArrayList<>();
//        int carry = 0;
//        for (int i = arr1.length - 1, j = arr2.length - 1; i >= 0 || j >= 0 || carry != 0; --i, --j) {
//            carry += (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0);
//            int r = carry % -2;
//            carry /= -2;
//            if (r < 0) {
//                r += 2;
//                ++carry;
//            }
//            list.add(r);
//        }
//        // 去除前导 0
//        while (list.size() > 1 && list.get(list.size() - 1) == 0) {
//            list.remove(list.size() - 1);
//        }
//        int n = list.size();
//        int[] res = new int[n];
//        for (int i = 0; i < n; ++i) {
//            res[i] = list.get(n - 1 - i);
//        }
//        return res;
//    }

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        for (int i = arr1.length - 1, j = arr2.length - 1; i >= 0 || j >= 0 || carry != 0; --i, --j) {
            carry += (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0);
            list.add(carry & 1);
            carry = -(carry >> 1);
        }
        // 去除前导 0
        while (list.size() > 1 && list.get(list.size() - 1) == 0) {
            list.remove(list.size() - 1);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(x -> x).toArray();
    }
}
