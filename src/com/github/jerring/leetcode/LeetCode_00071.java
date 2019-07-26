package com.github.jerring.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_00071 {

    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String s : strs) {
            if (s.isEmpty() || s.equals(".")) continue;
            if (s.equals("..")) deque.pollLast();
            else deque.offerLast(s);
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append('/').append(deque.pollFirst());
        }
        return sb.toString();
    }
}
