/**
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Input: n = 2
Output: 2

Input: n = 3
Output: 3

# of ways to reach 1st step = 1 
# of ways to reach 2 steps = 2 



Time Complexity: 
Space Compxity:  
 * */

import java.util.*;

public class ClimbingStairs {


	public static void main(String[] args) {
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(5));
		System.out.println(climbStairs(9));
	}


	public static int climbStairs(int n) {
        
        if(n <= 2){
        	return n;
        }

		/*Iterative Approach*/
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
        	dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }


}