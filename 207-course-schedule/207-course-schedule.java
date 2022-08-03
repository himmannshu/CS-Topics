class Solution {
    HashSet<Integer> set = new HashSet();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] arr = new ArrayList[numCourses];
        
        for(int i = 0; i<numCourses; i++) arr[i] = new ArrayList();
        
        for(int i = 0; i<prerequisites.length; i++){
            arr[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        for(int i = 0; i<numCourses; i++){
            if(!dfs(arr, i)){
                return false;
            }
        }
        
        return true;
        
    }
    
    private boolean dfs(List<Integer>[] graph, int i){
        if(set.contains(i)) return false;
        if(graph[i].size() == 0) return true;
        set.add(i);
        for(int j = 0; j<graph[i].size(); j++){
            if(!dfs(graph, graph[i].get(j)))
                return false;;
        }
        set.remove(i);
        graph[i] = new ArrayList();
        return true;
    }
}