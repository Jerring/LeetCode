package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_00989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K != 0; --i) {
            K += i >= 0 ? A[i] : 0;
            res.add(K % 10);
            K /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
