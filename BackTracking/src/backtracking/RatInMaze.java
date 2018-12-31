package backtracking;

import java.util.Scanner;

public class RatInMaze {

	public static boolean ratInAMaze(int maze[][]) {
		int n = maze.length;
		int path[][] = new int[n][n];
		return solveMaze(maze, 0, 0, path);
	}

	private static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
		int n = maze.length;
		//Check if i, j cell is valid or not
		if (i < 0 || i >=n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
			return false;
		}
		
		//Include current cell in path
		path[i][j] = 1;
		
		//Destination cell
		if (i == (n - 1) && j == (n - 1)) {
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					System.out.print(path[a][b] + " ");
				}
				System.out.println();
			}
			return true;
		}
		
		//Explore in all directions
		//top
		if (solveMaze(maze, i - 1, j, path)) {
			return true;
		}
		
		//right
		if (solveMaze(maze, i, j + 1, path)) {
			return true;
		}
		
		//bottom
		if (solveMaze(maze, i + 1, j, path)) {
			return true;
		}
		
		//left
		if (solveMaze(maze, i, j - 1, path)) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int maze[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = s.nextInt();
			}
		}
		System.out.println(ratInAMaze(maze));
		s.close();
	}
}
