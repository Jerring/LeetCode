package com.github.jerring.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_00056 {

    public List<Interval> merge(List<Interval> intervals) {
        // 首先按照 Interval.start 从小到大排序
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        LinkedList<Interval> res = new LinkedList<>();
        // 如果 pre.end >= cur.start，就合并两个区间，即 pre.end = max(pre.end, cur.end)
        for (Interval interval : intervals) {
            if (res.isEmpty() || res.getLast().end < interval.start) {
                res.add(interval);
            } else {
                res.getLast().end = Integer.max(res.getLast().end, interval.end);
            }
        }
        return res;
    }
}
