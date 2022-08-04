class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i<numCourses; i++) graph[i] = new ArrayList();
        
        for(int i = 0; i<prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        HashSet<Integer> visited = new HashSet();
        List<Integer> ans = new ArrayList();
        for(int i = 0; i<numCourses; i++){
            if(!dfs(graph, i, visited, ans)){
                return new int[0];
            }
        }
        int[] a = new int[numCourses];
        visited = new HashSet();
        int counter = 0;
        for(int i = 0; i<ans.size(); i++){
            if(visited.add(ans.get(i)))
                a[counter++] = ans.get(i);
        }
        
        return a;
        
    }
    
    private boolean dfs(List<Integer>[] graph, int node, HashSet<Integer> set, List<Integer> ans){
        if(set.contains(node)){
            return false;
        }
        
        set.add(node);
        for(int i = 0; i<graph[node].size(); i++){
            if(!dfs(graph, graph[node].get(i), set, ans)){
                return false;
            }
        }
        set.remove(node);
        ans.add(node);
        return true;
    }
}