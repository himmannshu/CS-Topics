class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i<= amount; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for(int amt = 1; amt <= amount; amt++){
            for(int i = 0; i<coins.length; i++){
                if(coins[i] <= amt && dp[amt - coins[i]] != Integer.MAX_VALUE){
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coins[i]]);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}