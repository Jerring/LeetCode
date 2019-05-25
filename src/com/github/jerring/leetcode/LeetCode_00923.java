package com.github.jerring.leetcode;

public class LeetCode_00923 {

//    public int threeSumMulti(int[] A, int target) {
//        final int MOD = (int) (1e9 + 7);
//        Arrays.sort(A);
//        int n = A.length;
//        int res = 0;
//        for (int i = 0; i < n; ++i) {
//            int l = i + 1, r = n - 1;
//            while (l < r) {
//                int sum = A[i] + A[l] + A[r];
//                if (sum < target) {
//                    ++l;
//                } else if (sum > target) {
//                    --r;
//                } else {
//                    if (A[l] == A[r]) {
//                        int cnt = r - l + 1;
//                        res  = (res + cnt * (cnt - 1) / 2) % MOD;
//                        break;
//                    } else {
//                        int left = 1;
//                        while (l + 1 < r && A[l + 1] == A[l]) {
//                            ++left;
//                            ++l;
//                        }
//                        int right = 1;
//                        while (l < r - 1 && A[r - 1] == A[r]) {
//                            ++right;
//                            --r;
//                        }
//                        res = (res + left * right) % MOD;
//                        ++l;
//                        --r;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public int threeSumMulti(int[] A, int target) {
        final int MOD = (int) (1e9 + 7);
        int[] cnt = new int[101];
        for (int a : A) {
            ++cnt[a];
        }
        int res = 0;
        // i、j、k 满足 i <= j <= k <= 100
        for (int i = 0; i <= 100; ++i) {
            for (int j = i; j <= 100; ++j) {
                int k = target - i - j;
                if (k < j) {
                    break;
                }
                if (k > 100) {
                    continue;
                }
                if (i == j && j == k) {
                    res += 1L * cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6 % MOD;
                } else if (i == j && j < k) {
                    res += 1L * cnt[i] * (cnt[i] - 1) / 2 * cnt[k] % MOD;
                } else if (i < j && j == k) {
                    res += 1L * cnt[i] * cnt[j] * (cnt[j] - 1) / 2 % MOD;
                } else {
                    res += 1L * cnt[i] * cnt[j] * cnt[k] % MOD;
                }
                res %= MOD;
            }
        }
        return res;
    }
}
