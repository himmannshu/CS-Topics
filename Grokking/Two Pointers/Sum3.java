/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:
x + y + z = 0, 
Input: nums = [-1,0,1,2,-1,-4]
==> [-4, -1, -1, 0, 1, 2]

Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

*/

import java.util.*;

public class Sum3 {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
		System.out.println(threeSum(new int[]{1}));
		System.out.println(threeSum(new int[]{}));
		System.out.println(threeSum(new int[]{8,0,1,2,3,4,10}));
		System.out.println(threeSum(new int[]{-1,0,-1,-2,-1,-4}));

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		if(nums.length < 3)
			return new ArrayList();
		
		HashSet<List<Integer>> answer = new HashSet<>();
		Arrays.sort(nums);
		for(int i = 0; i<nums.length; i++){
			
			int start = i + 1, end = nums.length - 1;
			int target = -nums[i];
			while(start < end){
				if(nums[start] + nums[end] < target){
					start++;
				}else if(nums[start] + nums[end] >  target){
					end--;
				}else{
					answer.add(Arrays.asList(nums[i], nums[start], nums[end]));
					start++;
					end--;
				}
			}
		}
		return new ArrayList(answer);
	}
}