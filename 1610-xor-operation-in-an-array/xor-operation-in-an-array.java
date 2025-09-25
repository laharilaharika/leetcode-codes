class Solution {
    public int xorOperation(int n, int start) {
        int res = 0;                   // 1. declare res
        for (int i = 0; i < n; i++) {  // 2. use < n
            res ^= (start + 2 * i);    // 3. use ^=
        }
        return res;
    }
}
