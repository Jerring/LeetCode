package com.github.jerring.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_00380 {

    class RandomizedSet {
        private Map<Integer, Integer> keyMap;
        private Map<Integer, Integer> indexMap;
        private int size;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            keyMap = new HashMap<>();
            indexMap = new HashMap<>();
            size = 0;
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (!keyMap.containsKey(val)) {
                keyMap.put(val, size);
                indexMap.put(size++, val);
                return true;
            }
            return false;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (keyMap.containsKey(val)) {
                int deleteIndex = keyMap.get(val);
                int lastKey = indexMap.get(--size);
                keyMap.put(lastKey, deleteIndex);
                indexMap.put(deleteIndex, lastKey);
                keyMap.remove(val);
                indexMap.remove(size);
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            if (size == 0) {
                throw new RuntimeException();
            }
            int randomIndex = (int) (Math.random() * size);
            return indexMap.get(randomIndex);
        }
    }
}
