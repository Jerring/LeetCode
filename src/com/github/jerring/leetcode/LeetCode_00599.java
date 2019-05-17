package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_00599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; ++i) {
            if (map.containsKey(list2[i])) {
                int cur = i + map.get(list2[i]);
                if (cur < min) {
                    min = cur;
                    res.clear();
                    res.add(list2[i]);
                } else if (cur == min) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
