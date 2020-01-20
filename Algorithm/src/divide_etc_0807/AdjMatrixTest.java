package divide_etc_0807;

import java.util.Stack;

public class AdjMatrixTest {
	private static int totalV = 7;
	private static int[][] adjMatrix;
	static boolean visited[] = new boolean[totalV];
	public static void dfs() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[totalV];
		
		int current = 0;
		visited[current] = true;
		System.out.printf("%c ",current+65);
		
		while(true) {
			for (int i = 0; i < totalV; i++) {
				if(adjMatrix[current][i]!=0 && !visited[i]) {
					stack.push(current);
					current = i;
					visited[current] = true;
					System.out.printf("%c ",current+65);
					i = -1;
				}
			}
			if(stack.isEmpty()) {break;}
			current = stack.pop();
		}
	}
	
	public static void main(String[] args) {
		adjMatrix  = new int[][] {
			{0,1,1,0,0,0,0},
			{1,0,0,1,1,0,0},
			{1,0,0,0,1,0,0},
			{0,1,0,0,0,1,0},
			{0,1,1,0,0,1,0},
			{0,0,0,1,1,0,1},
			{0,0,0,0,0,1,0}
		};
		
		dfs2(0);
	}
	
	public static void dfs2(int current) {
		visited[current] = true;
		System.out.printf("%c ",current+65);
		
		for (int i = 0; i < totalV; i++) {
			if(adjMatrix[current][i]!=0 && !visited[i]) {
				dfs2(i);
			}
		}
	}
}
