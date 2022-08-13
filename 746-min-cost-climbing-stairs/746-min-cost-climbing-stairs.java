class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // cost length constraints
        if(cost.length == 0){
            return -1;
        }
        
        int length = cost.length;
        
        for(int i = 2; i<cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        
        return Math.min(cost[length - 1], cost[length - 2]);
    }
}