package com.github.jerring.leetcode;

import java.util.Stack;

public class LeetCode_00150 {

    public int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (operators.contains(s)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    default:
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
