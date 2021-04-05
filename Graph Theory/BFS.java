import java.util.*;

public class BFS {

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
        bfs(graph, 0);
        sc.close();
    }

    /**
     * Iterative BFS implementation. ()
     * 
     * @param graph
     * @param root
     */
    public static void bfs(int[][] graph, int root) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[graph.length];
        q.add(root);
        while (!q.isEmpty()) {
            int node = q.remove();
            if (visited[node] == 1)
                continue;
            System.out.println(node);
            visited[node] = 1;
            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] == 1 && visited[i] != 1) {
                    q.add(i);
                }
            }
        }
        System.out.println(Arrays.toString(visited));
        // q.add();
        // q.remove();
    }
}
