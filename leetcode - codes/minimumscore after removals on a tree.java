import java.util.*;

class Solution {
    List<Integer>[] tree;
    int[] subtreeXOR;
    int[] inTime, outTime;
    int timer = 0;
    int totalXOR = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        tree = new ArrayList[n];
        subtreeXOR = new int[n];
        inTime = new int[n];
        outTime = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        dfs(0, -1, nums);

        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor1 = 0, xor2 = 0, xor3 = 0;

                if (isAncestor(i, j)) {
                    xor1 = subtreeXOR[j];
                    xor2 = subtreeXOR[i] ^ subtreeXOR[j];
                    xor3 = totalXOR ^ subtreeXOR[i];
                } else if (isAncestor(j, i)) {
                    xor1 = subtreeXOR[i];
                    xor2 = subtreeXOR[j] ^ subtreeXOR[i];
                    xor3 = totalXOR ^ subtreeXOR[j];
                } else {
                    xor1 = subtreeXOR[i];
                    xor2 = subtreeXOR[j];
                    xor3 = totalXOR ^ subtreeXOR[i] ^ subtreeXOR[j];
                }

                int max = Math.max(xor1, Math.max(xor2, xor3));
                int min = Math.min(xor1, Math.min(xor2, xor3));
                minScore = Math.min(minScore, max - min);
            }
        }

        return minScore;
    }

    private void dfs(int node, int parent, int[] nums) {
        inTime[node] = ++timer;
        subtreeXOR[node] = nums[node];
        for (int neighbor : tree[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node, nums);
                subtreeXOR[node] ^= subtreeXOR[neighbor];
            }
        }
        outTime[node] = timer;
        totalXOR = subtreeXOR[0];
    }

    private boolean isAncestor(int u, int v) {
        return inTime[u] <= inTime[v] && outTime[u] >= outTime[v];
    }
}