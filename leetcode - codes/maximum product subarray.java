class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = nums[0];
        int maxProduct = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap min and max
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], nums[i] * maxProduct);
            minProduct = Math.min(nums[i], nums[i] * minProduct);

            res = Math.max(res, maxProduct);
        }

        return res;
    }
}
