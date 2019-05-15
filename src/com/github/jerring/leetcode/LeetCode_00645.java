package com.github.jerring.leetcode;

public class LeetCode_00645 {

//    public int[] findErrorNums(int[] nums) {
//        boolean[] vis = new boolean[nums.length + 1];
//        int[] res = new int[2];
//        for (int num : nums) {
//            if (vis[num]) {
//                res[0] = num;
//            } else {
//                vis[num] = true;
//            }
//        }
//        for (int i = 1; i < vis.length; ++i) {
//            if (!vis[i]) {
//                res[1] = i;
//                break;
//            }
//        }
//        return res;
//    }

//    public int[] findErrorNums(int[] nums) {
//        int[] res = new int[2];
//        for (int num : nums) {
//            if (nums[Math.abs(num) - 1] < 0) {
//                res[0] = Math.abs(num);
//            } else {
//                nums[Math.abs(num) - 1] *= -1;
//            }
//        }
//        for (int i = 0; i < nums.length; ++i) {
//            if (nums[i] > 0) {
//                res[1] = i + 1;
//                break;
//            }
//        }
//        return res;
//    }

    public int[] findErrorNums(int[] nums) {
        int t = 0;
        for (int i = 1; i <= nums.length; ++i) {
            t ^= i;
        }
        for (int num : nums) {
            t ^= num;
        }
        int lastOne = t & -t;   // 得到最后一个 1
        int t1 = 0, t2 = 0;
        for (int i = 1; i <= nums.length; ++i) {
            if ((i & lastOne) == 0) {
                t1 ^= i;
            } else {
                t2 ^= i;
            }
        }
        for (int num : nums) {
            if ((num & lastOne) == 0) {
                t1 ^= num;
            } else {
                t2 ^= num;
            }
        }
        for (int num : nums) {
            if (num == t1) {
                return new int[]{t1, t2};
            }
        }
        return new int[]{t2, t1};
    }
}
