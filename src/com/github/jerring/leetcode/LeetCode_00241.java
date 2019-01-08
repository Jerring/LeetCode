package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_00241 {

//    public List<Integer> diffWaysToCompute(String input) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < input.length(); ++i) {
//            char c = input.charAt(i);
//            if (c == '+' || c == '-' || c == '*') {
//                // 递归调用，分为左右两部分
//                List<Integer> left = diffWaysToCompute(input.substring(0, i));
//                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
//                for (int l : left) {
//                    for (int r : right) {
//                        if (c == '+') {
//                            res.add(l + r);
//                        } else if (c == '-') {
//                            res.add(l - r);
//                        } else {
//                            res.add(l * r);
//                        }
//                    }
//                }
//            }
//        }
//        // 为空直接加上对应的数值
//        if (res.size() == 0) {
//            res.add(Integer.valueOf(input));
//        }
//        return res;
//    }

    // 运用备忘录方法进行优化
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> map = new HashMap<>();
        return compute(input, map);
    }

    private List<Integer> compute(String input, Map<String, List<Integer>> map) {
        // 备忘录中存在则直接返回
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // 递归调用，分为左右两部分
                List<Integer> left = compute(input.substring(0, i), map);
                List<Integer> right = compute(input.substring(i + 1), map);
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        // 为空直接加上对应的数值
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        // 添加入备忘录
        map.put(input, res);
        return res;
    }
}
