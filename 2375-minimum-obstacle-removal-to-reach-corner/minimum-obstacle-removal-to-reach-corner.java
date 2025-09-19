import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dist[r][c] = minimum obstacles removed to reach (r,c)
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int cost = dist[r][c] + grid[nr][nc]; // add 1 if obstacle
                if (cost < dist[nr][nc]) {
                    dist[nr][nc] = cost;
                    if (grid[nr][nc] == 1) {
                        dq.offerLast(new int[]{nr, nc}); // cost 1 → back
                    } else {
                        dq.offerFirst(new int[]{nr, nc}); // cost 0 → front
                    }
                }
            }
        }

        return dist[m-1][n-1];
    }
}
