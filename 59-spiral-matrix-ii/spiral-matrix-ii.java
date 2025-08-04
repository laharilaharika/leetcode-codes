class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int c = 1;

        while (c <= n * n) {
            for (int i = left; i <= right; i++) {
                res[top][i] = c++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = c++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res[bottom][i] = c++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res[i][left] = c++;
                }
                left++;
            }
        }

        return res;
    }
}
