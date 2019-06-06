package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_00229 {

    public List<Integer> majorityElement(int[] nums) {
        // 摩尔投票算法
        int[] candidate = new int[2];
        int[] cnt = new int[2];
        for (int num : nums) {
            if (num == candidate[0]) {
                ++cnt[0];
            } else if (num == candidate[1]) {
                ++cnt[1];
            } else if (cnt[0] == 0) {
                candidate[0] = num;
                cnt[0] = 1;
            } else if (cnt[1] == 0) {
                candidate[1] = num;
                cnt[1] = 1;
            } else {
                --cnt[0];
                --cnt[1];
            }
        }
        // 重新统计判断是否满足要求
        Arrays.fill(cnt, 0);
        for (int num : nums) {
            if (num == candidate[0]) {
                ++cnt[0];
            } else if (num == candidate[1]) {
                ++cnt[1];
            }
        }
        // 满足要求才加入结果集
        List<Integer> res = new ArrayList<>();
        if (cnt[0] > nums.length / 3) {
            res.add(candidate[0]);
        }
        if (cnt[1] > nums.length / 3) {
            res.add(candidate[1]);
        }
        return res;
    }
}
