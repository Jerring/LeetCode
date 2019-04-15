package com.github.jerring.leetcode;

public class LeetCode_00202 {

//    public boolean isHappy(int n) {
//        Set<Integer> set = new HashSet<>();
//        while (n != 1) {
//            if (!set.add(n)) {
//                return false;
//            }
//            int sum = 0;
//            while (n != 0) {
//                int tail = n % 10;
//                n /= 10;
//                sum += tail * tail;
//            }
//            n = sum;
//        }
//        return true;
//    }

//    public boolean isHappy(int n) {
//        int fast = n;
//        int slow = n;
//        do {
//            fast = getSqurareSum(getSqurareSum(fast));
//            if (fast == 1) {
//                return true;
//            }
//            slow = getSqurareSum(slow);
//        } while (fast != slow);
//        return false;
//    }
//
//    private int getSqurareSum(int n) {
//        int sum = 0;
//        while (n != 0) {
//            int tail = n % 10;
//            n /= 10;
//            sum += tail * tail;
//        }
//        return sum;
//    }

//    public boolean isHappy(int n) {
//        while (n != 1 && n != 4) {
//            int sum = 0;
//            while (n != 0) {
//                int tail = n % 10;
//                n /= 10;
//                sum += tail * tail;
//            }
//            n = sum;
//        }
//        return n == 1;
//    }

    public boolean isHappy(int n) {
        int cnt = 0;
        while (true) {
            int sum = 0;
            while (n != 0) {
                int tail = n % 10;
                n /= 10;
                sum += tail * tail;
            }
            n = sum;
            if (n == 1) {
                return true;
            }
            if (++cnt == 7) {
                return false;
            }
        }
    }
}
