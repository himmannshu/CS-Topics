class Solution {
    private HashSet<Integer> set;
    
    public int countComponents(int n, int[][] edges) {
        set = new HashSet();
        
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i<n; i++) graph[i] = new ArrayList();
        
        for(int i = 0; i<edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(!set.contains(i)){
                dfs(i, graph);
                ans++;
            }
        }
        
        return ans;
    }
    
    private void dfs(int node, List<Integer>[] graph){
        set.add(node);
        for(int i = 0; i<graph[node].size(); i++){
            if(!set.contains(graph[node].get(i))){
                dfs(graph[node].get(i), graph);
            }
        }
    }
}