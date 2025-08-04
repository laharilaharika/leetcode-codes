class Solution {
    public boolean canMakeSquare(char[][] A) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int w = 0, b = 0;

                if (A[i][j] == 'W') w++; else b++;
                if (A[i][j+1] == 'W') w++; else b++;
                if (A[i+1][j] == 'W') w++; else b++;
                if (A[i+1][j+1] == 'W') w++; else b++;

                if (w >= 3 || b >= 3) return true;
            }
        }
        return false;
    }
}
