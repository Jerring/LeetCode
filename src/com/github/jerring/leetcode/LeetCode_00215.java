package com.github.jerring.leetcode;

public class LeetCode_00215 {

    public int findKthLargest(int[] nums, int k) {
        // 转换为数组从小到大排序后的下标
        k = nums.length - k;
        return quickSelect(nums, k);
    }

    /**
     * 选择第 k 小的元素（从 0 开始计数），使 a[k] 在数组排序后正确的位置上
     * @param nums  数组 nums
     * @param k     第 k 小
     * @return      nums[k]
     */
    private int quickSelect(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        // 逐步缩小 [lo, hi] 的范围
        while (lo < hi) {
            int i = partition(nums, lo, hi);
            if (i < k) {
                lo = i + 1;
            } else if (i > k) {
                hi = i - 1;
            } else {
                return nums[i];
            }
        }
        // 此时 lo = hi = k
        return nums[lo];
    }

    /**
     * 分割方法，获得切分下标
     * @param nums     待分割数组
     * @param lo    待分割数组的开始下标
     * @param hi    待分割数组的结束下标
     * @return      切分下标
     */
    private int partition(int[] nums, int lo, int hi) {
        // 将三者的中位数放在数组头部，再来分割，即把三者的中位数作为 pivot
        int m = median3(nums, lo, lo + (hi - lo) / 2, hi);
        swap(nums, lo, m);
        int i = lo;
        int j = hi + 1;
        int v = nums[lo];
        while (true) {
            // 从左往右找到第一个大于 pivot 的位置
            while (nums[++i] < v && i < hi) {}
            // 从右往左找到第一个小于 pivot 的位置
            while (nums[--j] > v) {}
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    /**
     * 得到 nums[i], nums[j], nums[k] 的中位数的下标
     * @param nums  数组
     * @param i     下标 i
     * @param j     下标 j
     * @param k     下标 k
     * @return      中位数的下标
     */
    private static int median3(int[] nums, int i, int j, int k) {
        return nums[i] < nums[j] ?
                (nums[j] < nums[k] ? j : nums[i] < nums[k] ? k : i) :
                (nums[k] < nums[j] ? j : nums[k] < nums[i] ? k : i);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
