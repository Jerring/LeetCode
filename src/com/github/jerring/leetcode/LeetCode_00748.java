package com.github.jerring.leetcode;

public class LeetCode_00748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] map = new int[26];
        int count = 0;
        for (char c : licensePlate.toCharArray()) {
            if (Character.isUpperCase(c) || Character.isLowerCase(c)) {
                ++map[Character.toLowerCase(c) - 'a'];
                ++count;
            }
        }
        String res = null;
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() < min) {
                int[] cnt = new int[26];
                int size = count;
                for (char c : word.toCharArray()) {
                    if (++cnt[c - 'a'] <= map[c - 'a']) {
                        if (--size == 0) {
                            res = word;
                            min = word.length();
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
