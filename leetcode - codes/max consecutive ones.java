class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi = 0, ones = 0;
        for (int num : nums) {
            if (num == 1) {
                ones++;
                maxi = Math.max(maxi, ones);
            } else {
                ones = 0;
            }
        }
        return maxi;
    }
}