package com.github.jerring.leetcode;

import java.util.*;

public class LeetCode_00127 {

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Queue<String> queue = new LinkedList<>();
//        Set<String> set = new HashSet<>();
//        queue.offer(beginWord);
//        set.add(beginWord);
//        int level = 1;
//        while (!queue.isEmpty()) {
//            ++level;
//            int size = queue.size();
//            while (size-- != 0) {
//                String word = queue.poll();
//                for (String w : wordList) {
//                    if (set.contains(w)) {
//                        continue;
//                    }
//                    if (match(word, w)) {
//                        if (w.equals(endWord)) {
//                            return level;
//                        }
//                        queue.offer(w);
//                        set.add(w);
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//
//    private boolean match(String word, String w) {
//        boolean changedOnce = false;
//        for (int i = 0; i < word.length(); ++i) {
//            if (word.charAt(i) != w.charAt(i)) {
//                if (changedOnce) {
//                    return false;
//                } else {
//                    changedOnce = true;
//                }
//            }
//        }
//        return true;
//    }

    // 双向 BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 构建一个包含所有单词的字典
        Set<String> dict = new HashSet<>(wordList);
        // 字典中不包含 endWord，不可能经过转换得到 endWord
        if (!dict.contains(endWord)) {
            return 0;
        }
        // 构建头尾队列
        Set<String> head = new HashSet<>();
        Set<String> tail = new HashSet<>();
        head.add(beginWord);
        tail.add(endWord);
        // 注意长度是结点数，而不是边数
        int level = 1;
        while (!head.isEmpty() && !tail.isEmpty()) {
            ++level;
            // 优先扩展队列大小较小的，保持头队列为包含元素较少的队列
            if (head.size() > tail.size()) {
                Set tmp = head;
                head = tail;
                tail = tmp;
            }
            // 构建下一次扩展的头队列
            Set<String> newHead = new HashSet<>();
            for (String word : head) {
                char[] cs = word.toCharArray();
                for (int i = 0; i < cs.length; ++i) {
                    char ch = cs[i];
                    for (char j = 'a'; j <= 'z'; ++j) {
                        // 变动一个字符得到新字符串
                        cs[i] = j;
                        String s = new String(cs);
                        // 到达目标点
                        if (tail.contains(s)) {
                            return level;
                        }
                        // 剪枝。在字典中存在才添加到新的头队列中，并更新字典
                        if (dict.contains(s)) {
                            dict.remove(s);
                            newHead.add(s);
                        }
                    }
                    // 还原
                    cs[i] = ch;
                }
            }
            // 得到新的头队列
            head = newHead;
        }
        return 0;
    }
}
