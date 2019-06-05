package com.github.jerring.leetcode;

public class LeetCode_00393 {

//    public boolean validUtf8(int[] data) {
//        int n = data.length;
//        for (int i = 0; i < n; ++i) {
//            if ((data[i] >> 5) == 0b110) {
//                if (++i == n || (data[i] >> 6) != 0b10) {
//                    return false;
//                }
//            } else if ((data[i] >> 4) == 0b1110) {
//                if (++i == n || (data[i] >> 6) != 0b10 || ++i == n || (data[i] >> 6) != 0b10) {
//                    return false;
//                }
//            } else if ((data[i] >> 3) == 0b11110) {
//                if (++i == n || (data[i] >> 6) != 0b10 || ++i == n || (data[i] >> 6) != 0b10 || ++i == n || (data[i] >> 6) != 0b10) {
//                    return false;
//                }
//            } else if ((data[i] >> 7) != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean validUtf8(int[] data) {
        int cnt = 0;
        for (int d : data) {
            if (cnt == 0) {
                if ((d >> 5) == 0b110) cnt = 1;
                else if ((d >> 4) == 0b1110) cnt = 2;
                else if ((d >> 3) == 0b11110) cnt = 3;
                else if ((d >> 7) != 0) return false;
            } else {
                if ((d >> 6) != 0b10) return false;
                --cnt;
            }
        }
        return cnt == 0;
    }
}
