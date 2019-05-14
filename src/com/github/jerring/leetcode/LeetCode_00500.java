package com.github.jerring.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_00500 {

    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        int[] keyboard = new int[]{
                1, 2, 2, 1, 0, 1, 1,    // A,B,C,D,E,F,G
                1, 0, 1, 1, 1, 2, 2,    // H,I,J,K,L,M,N
                0, 0, 0, 0, 1, 0,       // O,P,Q,R,S,T
                0, 2, 0, 2, 0, 2        // U,V,W,X,Y,Z
        };
        for (String word : words) {
            if (inOneLine(word, keyboard)) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean inOneLine(String word, int[] keyboard) {
        int line = keyboard[Character.toUpperCase(word.charAt(0)) - 'A'];
        for (int i = 1; i < word.length(); ++i) {
            if (keyboard[Character.toUpperCase(word.charAt(i)) - 'A'] != line) {
                return false;
            }
        }
        return true;
    }
}
