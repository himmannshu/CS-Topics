/*

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

Input: nums = [5,1,2,3,4]
start = 0 and end = 2
mid = 1
Output: 1
-- [5,4,3]
Input: nums = [2, 4, 5, 6, 7, 0, 1]
==> start = 3 and end = 7 
mid = 5
Output: 0


*/


public class MinimumRotatedArray {
	
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{1,2,3,4}));
		System.out.println(findMin(new int[]{4,3,2,1}));
		System.out.println(findMin(new int[]{2, 4, 5, 6, 7, 0, 1}));
	}

	public static int findMin(int[] nums) {


    }
}
