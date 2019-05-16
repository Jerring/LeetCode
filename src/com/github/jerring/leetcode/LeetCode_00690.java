package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_00690 {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return helper(id, map);
    }

    private int helper(int id, Map<Integer, Employee> map) {
        Employee employee = map.get(id);
        int res = employee.importance;
        for (int subId : employee.subordinates) {
            res += helper(subId, map);
        }
        return res;
    }

//    public int getImportance(List<Employee> employees, int id) {
//        Map<Integer, Employee> map = new HashMap<>();
//        for (Employee employee : employees) {
//            map.put(employee.id, employee);
//        }
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.offer(id);
//        int res = 0;
//        while (!queue.isEmpty()) {
//            Employee employee = map.get(queue.poll());
//            res += employee.importance;
//            for (int subId : employee.subordinates) {
//                queue.offer(subId);
//            }
//        }
//        return res;
//    }
}
