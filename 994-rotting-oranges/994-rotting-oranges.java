class Solution {
    class Point{
        int x;
        int y;
        public Point(int a, int b){
            x = a;
            y = b;
        }
    }
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        Queue<Point> q = new LinkedList();
        HashSet<Point> set = new HashSet();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == 2) q.add(new Point(i, j));
            }
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while(!q.isEmpty()){
            int size = q.size();
            boolean updated = false;
            for(int i = 0; i<size; i++){
                Point point = q.poll();
                
                int x = point.x;
                int y = point.y;
                visited[x][y] = true;
                if(x + 1 < grid.length && !visited[x + 1][y] && grid[x + 1][y] == 1){
                    grid[x + 1][y] = 2;
                    q.add(new Point(x + 1, y));
                    updated = true;
                }
                if(x - 1 >= 0 && !visited[x - 1][y] && grid[x - 1][y] == 1){
                    grid[x - 1][y] = 2;
                    q.add(new Point(x - 1, y));
                    updated = true;
                }
                if(y + 1 < grid[x].length && !visited[x][y + 1] && grid[x][y + 1] == 1){
                    grid[x][y + 1] = 2;
                    q.add(new Point(x, y + 1));
                    updated = true;
                }
                if(y - 1 >= 0 && !visited[x][y - 1] && grid[x][y - 1] == 1){
                    grid[x][y - 1] = 2;
                    q.add(new Point(x, y - 1));
                    updated = true;
                }
            }
            
            if(updated) ans++;
        }
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++)
            {
                if(grid[i][j] == 1) return -1;
            }
        }

        return ans;
    }
}