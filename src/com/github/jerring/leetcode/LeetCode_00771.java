package com.github.jerring.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_00771 {

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int res = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                ++res;
            }
        }
        return res;
    }

//    public int numJewelsInStones(String J, String S) {
//        return S.replaceAll("[^" + J + "]", "").length();
//    }
}
