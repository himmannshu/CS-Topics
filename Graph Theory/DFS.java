/* Time Complexity: O(V+E) */

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Nodes: ");
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        List<Integer>[] listGraph = new List[n];
        for (int i = 0; i < n; i++)
            listGraph[i] = new ArrayList<Integer>();

        System.out.println("Edges");
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            graph[x][y] = 1;
            graph[y][x] = 1;
            listGraph[x].add(y);
            listGraph[y].add(x);
        }

        System.out.println("Graph: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Adjacency Matrix");
        int[] visited = new int[n];
        dfs(graph, visited, 0);
        System.out.println("List: ");
        int[] new_visited = new int[n];
        dfsAdjacenceyList(listGraph, new_visited, 0);
        System.out.println(Arrays.toString(visited));
        System.out.println(Arrays.toString(new_visited));
        sc.close();
    }

    /* Adjacency Matrix */

    /**
     * 
     * @param graph
     * @param visited
     * @param root
     */
    public static void dfs(int[][] graph, int[] visited, int root) {
        if (visited[root] == 1)
            return;
        visited[root] = 1;
        System.out.println(root);
        for (int i = 0; i < graph[root].length; i++) {
            if (graph[root][i] == 1)
                dfs(graph, visited, i);
        }
    }

    /* Adjacency Matrix */

    /**
     * 
     * @param graph
     * @param visited
     * @param root
     */
    public static void dfsPostOrder(int[][] graph, int[] visited, int root) {
        if (visited[root] == 1)
            return;
        visited[root] = 1;
        for (int i = 0; i < graph[root].length; i++) {
            if (graph[root][i] == 1)
                dfs(graph, visited, i);
        }
        System.out.println(root);
    }

    /* Adjacency List */
    public static void dfsAdjacenceyList(List<Integer>[] graph, int[] visited, int root) {
        if (visited[root] == 1)
            return;
        visited[root] = 1;
        System.out.println(root);
        for (int i = 0; i < graph[root].size(); i++) {
            dfsAdjacenceyList(graph, visited, graph[root].get(i));
        }
    }

}