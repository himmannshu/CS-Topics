class Solution {
    /*
        Brute force approach:
            Consider all substring and check if it is a substring or not. Choose the longest one.
            Time Complexity: O(N^3)
    */
    public String longestPalindrome(String s) {
        String ans = "";
        /*
            S[i,j] = true, if palindrome : false, otherwise
            
            Base Case: S[i,i] = true, S[i, i + 1] = (S[i] == S[i + 1])
        *
        /*
                b a b
              b 1 0 1
              a 0 1 0
              b 1 0 1
        */
        int length = s.length();
        int[][] dp = new int[length][length];
        
        for(int i = 0; i<length; i++) dp[i][i] = 1;
        
        for(int i = length - 1; i>=0; i--){
            for(int j = length - 1; j > i; j--){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i + 1 == 2){
                        dp[i][j] = 2;
                    }else if(dp[i + 1][j - 1] != 0){
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                    if(dp[i][j] > ans.length()){
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        
        if(ans.length() == 0){
            return "" + s.charAt(0);
        }
        
        return ans;
        
    }

}