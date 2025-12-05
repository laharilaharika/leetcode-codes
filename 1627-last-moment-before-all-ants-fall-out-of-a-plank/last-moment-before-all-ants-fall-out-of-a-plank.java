class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int last = 0;
        
        // Ants moving left: time to fall = position itself
        for (int pos : left) {
            last = Math.max(last, pos);
        }
        
        // Ants moving right: time to fall = n - position
        for (int pos : right) {
            last = Math.max(last, n - pos);
        }
        
        return last;
    }
}
