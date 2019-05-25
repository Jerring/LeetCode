package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_00609 {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] split = path.split(" ");
            for (int i = 1; i < split.length; ++i) {
                int index = split[i].lastIndexOf('(');
                String key = split[i].substring(index + 1, split[i].length() - 1);
                String value = split[0] + "/" + split[i].substring(0, index);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(value);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                res.add(list);
            }
        }
        return res;
    }
}
