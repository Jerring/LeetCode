package com.github.jerring.leetcode;

public class LeetCode_00067 {

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            carry += (i >= 0 ? a.charAt(i--) - '0' : 0) + (j >= 0 ? b.charAt(j--) - '0' : 0);
            res.append(carry & 1);
            carry >>= 1;
        }
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
