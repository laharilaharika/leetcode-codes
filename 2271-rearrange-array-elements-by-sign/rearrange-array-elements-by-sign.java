class Solution {
    public int[] rearrangeArray(int[] nums) {
      int n = nums.length;
        int[] ans = new int[n];
        int pos = 0;
        int neg = 1;

        for(int num : nums) {
            if(num > 0) {
                ans[pos] = num;
                pos = pos+2;
            } else {
                ans[neg] = num;
                neg = neg+2;
            }
        }
        return ans;  
    }
}