package com.github.jerring.leetcode;

public class LeetCode_00392 {

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            // 每次从下一个位置开始找
            index = t.indexOf(c, index + 1);
            // 没找到
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

//    // 进阶挑战（有大量输入的 S，T 相同）
//    public boolean isSubsequence(String s, String t) {
//        // 数组的每个元素是一个列表，用来存储对应字符的下标集合
//        List<Integer>[] map = new ArrayList[26];
//        for (int i = 0; i < t.length(); ++i) {
//            int tmp = t.charAt(i) - 'a';
//            if (map[tmp] == null) {
//                map[tmp] = new ArrayList<>();
//            }
//            map[tmp].add(i);
//        }
//        int index = 0;
//        for (char c : s.toCharArray()) {
//            List<Integer> list = map[c - 'a'];
//            // 对应列表不存在
//            if (list == null) {
//                return false;
//            }
//            // 在对应列表中进行二分查找，得到在列表中的插入点
//            int indexOfList = Collections.binarySearch(list, index);
//            if (indexOfList < 0) {
//                indexOfList = -indexOfList - 1;
//            }
//            // 没找到
//            if (indexOfList == list.size()) {
//                return false;
//            }
//            // 更新 index
//            index = list.get(indexOfList) + 1;
//        }
//        return true;
//    }
}
