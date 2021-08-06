/*

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
==> [-4, -1, 1, 2, 3]
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

*/
import java.util.*;

public class Sum3Closest {
	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
		System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 2));
	}

	public static int threeSumClosest(int[] nums, int target) {

		int sum = 0;
		int diff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for(int i = 0; i<nums.length; i++){
			int start = i + 1;
			int end = nums.length - 1;
			while(start < end){
				int temp = nums[i] + nums[start] + nums[end];
				int tempDiff = Math.abs(temp - target);
				if(tempDiff < diff){
					diff = tempDiff;
					sum = temp;
				}
				if(temp < target){
					start++;
				}else if(temp == target){
					return sum;
				}else{
					end--;
				}

			}
		}
        return sum;
    }
}