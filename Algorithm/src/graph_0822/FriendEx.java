package graph_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FriendEx {
	static int N,C;
	static boolean[][] adjMatrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		C = Integer.parseInt(in.readLine());
		
		adjMatrix = new boolean[N][N];
		
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = st.nextToken().charAt(0)-'A';
			int to = st.nextToken().charAt(0)-'A';
			
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}
		
		System.out.println((char)(goMatrix('A'-'A')+65));
	}
	private static int goMatrix(int cur) {
		int MAX=0, MAX_FRIEND=0;
		for (int i = 0; i < N; i++) {
			if(adjMatrix[cur][i]) {
				int count = 0;
				for (int j = 0; j < N; j++) {
					if(adjMatrix[i][j]) count++;
				}
				System.out.println((char)(i+65)+" 의 친구수 : "+count);
				if(MAX < count) {
					MAX = count;
					MAX_FRIEND = i;
				}
			}
		}
		return MAX_FRIEND;
	}
}
