package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            for (int j = i - 1; j > 0; --j) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
            res.add(1);
        }
        return res;
    }
}
