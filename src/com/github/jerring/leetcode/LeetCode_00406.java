package com.github.jerring.leetcode;

import java.util.Arrays;

public class LeetCode_00406 {

    public int[][] reconstructQueue(int[][] people) {
        // 按 h 降序、k 升序进行排序
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]));
        for (int i = 0; i < people.length; ++i) {
            int[] p = people[i];
            // 后移一位，让出插入点
            for (int j = i; j > p[1]; --j) {
                people[j] = people[j - 1];
            }
            // 插入到合适位置
            people[p[1]] = p;
        }
        return people;
    }
}
