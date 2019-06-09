package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_00898 {

//    public int subarrayBitwiseORs(int[] A) {
//        Set<Integer> res = new HashSet<>();
//        Set<Integer> cur = new HashSet<>();
//        for (int a : A) {
//            Set<Integer> next = new HashSet<>();
//            for (Integer num : cur) {
//                next.add(a | num);
//            }
//            next.add(a);
//            res.addAll(next);
//            cur = next;
//        }
//        return res.size();
//    }

    public int subarrayBitwiseORs(int[] A) {
        int maxVal = Arrays.stream(A).max().getAsInt();         // 得到最大值
        int mask = (Integer.highestOneBit(maxVal) << 1) - 1;    // 得到掩码
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < A.length; ++i) {
            int val = A[i];
            res.add(val);
            for (int j = i - 1; j >= 0 && val != mask; --j) {   // 等于掩码不用继续
                val |= A[j];
                res.add(val);
            }
        }
        return res.size();
    }
}
