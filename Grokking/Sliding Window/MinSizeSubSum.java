/*
MINIMUM SIZE SUBARRAY SUM
----------------------------------
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray 
[numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Input: target = 4, nums = [1,4,4]
Output: 1

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

*/


public class MinSizeSubSum {
	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
		System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
		System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));

	}

	public static int minSubArrayLen(int target, int[] nums) {

		if(nums.length == 0)
			return 0;
		/*
		TIME COMPLEXITY: O(N^2)
        int len = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums.length; i++){
        	int sum = 0;
        	int counter = i;
        	while(counter < nums.length && sum < target){
        		sum += nums[counter];
        		counter++;
        	}
        	// When sum of the entire array does not equal to the target
        	if(counter == nums.length && i == 0 && sum < target){
        		return 0;
        	}
        	// Only consider minimum value when sum >= target
        	if(sum >= target)
				len = Math.min(len, counter - i);

        }

        return len;*/

        /*Time Complexity: O(N+N) ==> O(N)*/

        int start = 0, end = 0, sum = 0;
        
        int length = Integer.MAX_VALUE;
        for(end = 0; end<nums.length; end++){
        	sum+= nums[end];
        	while(sum >= target){
        		length = Math.min(length, end - start + 1);
        		sum -= nums[start++];
        	}
        	
        }
        return length == Integer.MAX_VALUE ? 0 : length;

    }
}