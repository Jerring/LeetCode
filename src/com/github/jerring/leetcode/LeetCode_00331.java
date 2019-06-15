package com.github.jerring.leetcode;

public class LeetCode_00331 {

//    public boolean isValidSerialization(String preorder) {
//        String[] strs = preorder.split(",");
//        int[] index = new int[1];
//        boolean[] flag = new boolean[]{true};
//        dfs(strs, index, flag);
//        return flag[0] && index[0] == strs.length;
//    }
//
//    private void dfs(String[] strs, int[] index, boolean[] flag) {
//        if (!flag[0]) {
//            return;
//        }
//        if (index[0] == strs.length) {
//            flag[0] = false;
//            return;
//        }
//        if (strs[index[0]++].equals("#")) {
//            return;
//        }
//        dfs(strs, index, flag);
//        dfs(strs, index, flag);
//    }

    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int diff = 1;
        for (String s : strs) {
            if (--diff < 0) {
                return false;
            }
            if (!s.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}
