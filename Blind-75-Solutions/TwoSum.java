/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Input: nums = [3,2,4], target = 6
Output: [1,2]

Constraints: 

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

Assuming numbers in the input array are not repeated. 

*/

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
		int[] array = new int[]{2,7,11,15};
		int target = 9;
		int[] array1 = new int[]{3,2,4};
		int target1 = 6;

		System.out.println(Arrays.toString(twoSum(array, target)));
		System.out.println(Arrays.toString(twoSum(array1, target1)));

	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> mapping = new HashMap();
		
		for(int i = 0; i<nums.length; i++){
			int temp = target - nums[i];
			if(mapping.containsKey(temp)){
				return new int[]{i, mapping.get(temp)};
			}
			mapping.put(nums[i], i);
		}

		return new int[0];
	}

}