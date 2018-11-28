package com.github.jerring.leetcode;

public class LeetCode_00443 {

    public int compress(char[] chars) {
        // n 为压缩后数组的新长度
        int n = 0;
        // i 用来遍历原数组
        int i = 0;
        while (i < chars.length){
            // 每次保存一个字符
            chars[n++] = chars[i++];
            // 统计该字符的个数
            int cnt = 1;
            while (i < chars.length && chars[i] == chars[i - 1]) {
                ++i;
                ++cnt;
            }
            // 如果该字符的个数大于 1，则加上字符个数（需要进行转换）；如果等于 1，则不用加
            if (cnt > 1) {
                for (char c : Integer.toString(cnt).toCharArray()) {
                    chars[n++] = c;
                }
            }
        }
        return n;
    }
}
