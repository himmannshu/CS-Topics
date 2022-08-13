class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        int ans = length;        
        boolean[][] isPalindrome = new boolean[length][length];
        
        for(int i = 0; i<length; i++) isPalindrome[i][i] = true;
        
        for(int i = length - 1; i >= 0; i--){
            for(int j = length - 1; j > i; j--){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i + 1 == 2)
                        isPalindrome[i][j] = true;
                    else if(isPalindrome[i + 1][j - 1])
                        isPalindrome[i][j] = true;
                }
                
                if(isPalindrome[i][j]) ans++;
            }
        }
        
        return ans;
    }
}