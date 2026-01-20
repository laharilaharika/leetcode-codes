class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] curr = new int[n];

        // Initialize first cell
        curr[0] = grid[0][0];

        // Fill first row
        for (int j = 1; j < n; j++) {
            curr[j] = curr[j - 1] + grid[0][j];
        }

        // Process remaining rows
        for (int i = 1; i < m; i++) {
            // First column (only from top)
            curr[0] = curr[0] + grid[i][0];

            for (int j = 1; j < n; j++) {
                curr[j] = Math.min(curr[j], curr[j - 1]) + grid[i][j];
            }
        }

        return curr[n - 1];
    }
}
