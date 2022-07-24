class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                
                if(board[i][j] == word.charAt(0) && dfs(i, j, board, word, 0, new boolean[m][n])){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board, String word, int index, boolean[][] visited){
        if(word.length() == index){
            return true;
        }
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j] || word.charAt(index) != board[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        
        if(dfs(i + 1, j, board, word, index + 1, visited) 
           || dfs(i - 1, j, board, word, index + 1, visited) 
           || dfs(i, j + 1, board, word, index + 1, visited) 
           || dfs(i, j - 1, board, word, index + 1, visited)){
            return true;
        }
        
        visited[i][j] = false;
        
        return false;
    }
}