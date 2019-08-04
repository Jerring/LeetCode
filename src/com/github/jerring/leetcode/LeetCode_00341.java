package com.github.jerring.leetcode;

import java.util.*;

public class LeetCode_00341 {

//    public class NestedIterator implements Iterator<Integer> {
//        private List<Integer> list;
//        private int index;
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            list = new ArrayList<>();
//            index = 0;
//            dfs(nestedList);
//        }
//
//        private void dfs(List<NestedInteger> nestedList) {
//            for (NestedInteger x : nestedList) {
//                if (x.isInteger()) {
//                    list.add(x.getInteger());
//                } else {
//                    dfs(x.getList());
//                }
//            }
//        }
//
//        @Override
//        public Integer next() {
//            return list.get(index++);
//        }
//
//        @Override
//        public boolean hasNext() {
//            return index < list.size();
//        }
//    }

    public class NestedIterator implements Iterator<Integer> {
        private Deque<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new ArrayDeque<>();
            for (int i = nestedList.size() - 1; i >= 0; --i) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger peek = stack.peek();
                if (peek.isInteger()) {
                    return true;
                }
                List<NestedInteger> list = stack.pop().getList();
                for (int i = list.size() - 1; i >= 0; --i) {
                    stack.push(list.get(i));
                }
            }
            return false;
        }
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
