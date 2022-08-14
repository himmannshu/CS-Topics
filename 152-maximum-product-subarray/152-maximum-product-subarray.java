class Solution {
    public int maxProduct(int[] nums) {
        // Brute Force solution:
        /*
            consider all the subarrays and find the max product.
            Time Complexity: O(N^2)
            
        */
        int minProd = nums[0];
        int maxProd = nums[0];
        int ans = nums[0];
        for(int i = 1; i<nums.length; i++) {
            int temp = minProd;
            minProd = Math.min(nums[i], Math.min(maxProd * nums[i], minProd*nums[i]));
            maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], temp*nums[i]));
            ans = Math.max(ans, maxProd);
        }
        
        
        return ans;
    }
}