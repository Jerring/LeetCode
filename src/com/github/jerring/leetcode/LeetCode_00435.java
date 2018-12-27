package com.github.jerring.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_00435 {

    public int eraseOverlapIntervals(Interval[] intervals) {
        // 为空或只有一个区间则不存在区间重叠的可能
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        // 按区间的 end 从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
        int res = 0;
        int pre = intervals[0].end;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i].start < pre) { // 区间重叠
                ++res;
            } else {                        // 区间未重叠
                pre = intervals[i].end;
            }
        }
        return res;
    }
}
