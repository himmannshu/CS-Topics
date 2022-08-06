class Solution {
    // 
    public int findCircleNum(int[][] M) {
        int ans = 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(M, i, visited);
                ans++;
            }
        }
        return ans;
    }
    
    private void dfs(int[][] M, int island, boolean[] visited){
        if(visited[island]){
            return;
        }
        visited[island] = true;
        for(int i = 0; i<M[island].length; i++){
            if(M[island][i] == 1){
                dfs(M, i, visited);
            }
        }
    }
}