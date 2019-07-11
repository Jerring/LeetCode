package com.github.jerring.leetcode;

public class LeetCode_01108 {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
//        return address.replaceAll("\\.", "[.]");
    }
}

