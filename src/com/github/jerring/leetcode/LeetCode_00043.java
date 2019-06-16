package com.github.jerring.leetcode;

public class LeetCode_00043 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] arr = new int[n1 + n2 - 1];
        for (int i = n1 - 1; i >= 0; --i) {
            for (int j = n2 - 1; j >= 0; --j) {
                arr[arr.length - 1 - i - j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < arr.length || carry != 0; ++i) {
            carry += i < arr.length ? arr[i] : 0;
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
