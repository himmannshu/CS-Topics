class Solution {
    public int numDecodings(String s) {
        
        return decodings(s, 0, new Integer[s.length()]);
    }
    
    private int decodings(String s, int index, Integer[] dp){
        if(index == s.length()){
            return 1;
        }
        if(s.charAt(index) == '0'){
            return 0;
        }
        if(dp[index] != null) return dp[index];
        int l1 = decodings(s, index + 1, dp);
        
        if(index < s.length()-1 && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index+1) < '7')){
            l1 += decodings(s, index + 2, dp);
        }
        dp[index] = l1;
        return dp[index];
    }
}