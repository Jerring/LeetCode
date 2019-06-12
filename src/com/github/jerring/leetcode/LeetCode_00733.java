package com.github.jerring.leetcode;

public class LeetCode_00733 {

    private int[] dirs = new int[]{-1, 0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; ++i) {
                int x = sr + dirs[i], y = sc + dirs[i + 1];
                if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == oldColor) {
                    floodFill(image, x, y, newColor);
                }
            }
        }
        return image;
    }
}
