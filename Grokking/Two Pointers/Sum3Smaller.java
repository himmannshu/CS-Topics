/*
3 SUM SMALLER
Description
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n 
that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Examples:

Input:  nums = [-2,0,1,3], target = 2
Output: 2
Explanation:
Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]
Example2

Input: nums = [-2,0,-1,3], target = 2
Output: 3
Explanation:
Because there are three triplets which sums are less than 2:
[-2, 0, -1]
[-2, 0, 3]
[-2, -1, 3]
Challenge
Could you solve it in O(n2) runtime?

*/

import java.util.*;

public class Sum3Smaller {
	public static void main(String[] args) {
		
	}

	public static int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        if(nums.length < 3)
        {
            return 0;
        }
        int numTriplets = 0;
        Arrays.sort(nums);
        int end = nums.length - 1;
        for(int i = 0; i<nums.length; i++){
            start = i + 1;
            
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum  < target){
                    numTriplets += end - start;
                    start++;
                }else{
                    end--;
                }
            }
        }

        return numTriplets;        
        return 0;
    }
}