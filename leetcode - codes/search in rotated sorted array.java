class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid; // Found target

            // Determine if the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) 
                    right = mid - 1; // Search in left half
                else 
                    left = mid + 1;  // Search in right half
            } 
            // Otherwise, the right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) 
                    left = mid + 1; // Search in right half
                else 
                    right = mid - 1; // Search in left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index of target: " + sol.search(nums, target)); // Output: 4
    }
}
