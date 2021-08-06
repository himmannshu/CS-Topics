/*

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.
    
Considering there are no zeros

*
    Testcase: 
    
    Input: nums = [2,3,-2,4]
    Output: 6

    Input: nums = [4, 5, -1, 9, 8, 0, 5]
                  [4, 20, -20, 9, 72, 0, 5]
    output: 72
                       
    Input: nums = [1, 2, -3, 4, 5, -6, -7]
                      ^         ^
                  [1, 2, -6, 4, 20, -120, 840]
                   
            nums = [-1, 0, -5, 9]  
    
*/

import java.util.*;
public class MaxProdSubArray {
            
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{0, 0, 9}));
        System.out.println(maxProduct(new int[]{1,2,0,8,9,0,1,5,7,9,0}));
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for(int i = 1; i<nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
      
    }

        
}