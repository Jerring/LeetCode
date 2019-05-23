package com.github.jerring.leetcode;

public class LeetCode_00299 {

//    public String getHint(String secret, String guess) {
//        Map<Character, Integer> secretMap = new HashMap<>();
//        Map<Character, Integer> guessMap = new HashMap<>();
//        int a = 0, b = 0;
//        int length = secret.length();
//        for (int i = 0; i < length; ++i) {
//            char s = secret.charAt(i);
//            char g = guess.charAt(i);
//            if (s == g) {
//                ++a;
//            } else {
//                secretMap.put(s, secretMap.getOrDefault(s, 0) + 1);
//                guessMap.put(g, guessMap.getOrDefault(g, 0) + 1);
//            }
//        }
//        for (Map.Entry<Character, Integer> entry : guessMap.entrySet()) {
//            Integer value = secretMap.get(entry.getKey());
//            if (value != null) {
//                b += Math.min(entry.getValue(), value);
//            }
//        }
//        return a + "A" + b + "B";
//    }

    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        int a = 0, b = 0;
        int length = secret.length();
        for (int i = 0; i < length; ++i) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                ++a;
            } else {
                if (++map[s - '0'] <= 0) ++b;   // 说明之前 guess 至少有一个 s
                if (--map[g - '0'] >= 0) ++b;   // 说明之前 secret 至少有一个 g
            }
        }
        return a + "A" + b + "B";
    }
}
