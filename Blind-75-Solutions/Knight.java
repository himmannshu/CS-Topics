import java.util.*;

/*
Given a square chessboard of N x N size, the position of Knight and position of a target is given. 
We need to find out the minimum steps a Knight will take to reach the target position.
*/

public class Knight {


	public static void main(String[] args) {

		System.out.println("---------------------------------------------------------------");
		System.out.println(" Knight's Position: (0, 0) Target: (1, 2) Steps: " + minSteps(0,0,1,2));
		System.out.println("---------------------------------------------------------------");
		System.out.println(" Knight's Position: (1, 2) Target: (0, 0) Steps: " + minSteps(1,2,0,0));
		System.out.println("---------------------------------------------------------------");
		System.out.println(" Knight's Position: (0, 0) Target: (2, 4) Steps: " + minSteps(0, 0,2, 4));
		System.out.println("---------------------------------------------------------------");
		System.out.println(" Knight's Position: (3, 2) Target: (0, 0) Steps: " + minSteps(3, 2,0, 0));
		System.out.println("---------------------------------------------------------------");
		System.out.println(" Knight's Position: (4, 5) Target: (1, 1) Steps: " + minSteps(4, 5,1, 1));

	}

	/*Perform a BFS instead of DFS
	Tim Complexity : O(N^2) */

	private static int minSteps(int knightX, int knightY, int targetX, int targetY){

		if(knightX == targetX && knightY == targetY){
			return 0;
		}

		int[][] moves = new int[][]{{1,2}, {1, -2}, {2,1}, {2,-1}, {-1,2}, {-1,-2}, {-2, 1}, {-2, -1}};
		boolean[][] visited = new boolean[8][8];

		int steps = 0;
		
		Queue<int[][]> queue = new LinkedList<>();

		queue.add(new int[][]{{knightX, knightY}});
		visited[knightX][knightY] = true;
		while(!queue.isEmpty()){

			int size = queue.size();
			steps += 1;
			while(size-- > 0){
				int[][] pos = queue.poll();

				for(int i = 0; i < moves.length; i++){
					int tempX = pos[0][0] + moves[i][0];
					int tempY = pos[0][1] + moves[i][1];

					if(tempX == targetX && tempY == targetY){
						return steps;
					}

					if(tempX >= 0 && tempY >= 0 && tempX < 8 && tempY < 8 && !visited[tempX][tempY]){
						queue.add(new int[][]{{tempX, tempY}});
						visited[tempX][tempY] = true;
					}
				}
			}

		}

		return steps;

	}

}