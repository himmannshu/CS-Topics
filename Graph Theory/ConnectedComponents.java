
/**
 *  A graph is split into multiple disjoint components.  
 */

import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Nodes: ");
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        System.out.println("Edges");
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        int count = 0;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                dfs(graph, visited, i);
                System.out.println(Arrays.toString(visited));
                count += 1;
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static void dfs(int[][] graph, int[] visited, int root) {
        if (visited[root] == 1)
            return;

        visited[root] = 1;
        for (int i = 0; i < graph[root].length; i++) {
            if (graph[root][i] == 1) {
                dfs(graph, visited, i);
            }
        }
    }
}
