package graph_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Send_Friend {
	static int N;	// 노드의 갯수
	static int C;	// 간선의 갯수
	static boolean[][] adjMatrix;	// 인접행렬
	static boolean[] visit;
	static int max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		
		adjMatrix = new boolean[N][N];
		visit = new boolean[N];
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = st.nextToken().charAt(0)-'A';
			int to = st.nextToken().charAt(0)-'A';
			
			adjMatrix[from][to] = adjMatrix[to][from] = true;	// from 과 to 는 서로 친구 이기에 둘다 true
		}
		
		send(0,0);	// 0인 A부터 시작
		System.out.println(max);
	}
	private static void send(int index,int cnt) {
		visit[index] = true;
		for (int i = 0; i < N; i++) {
			if(adjMatrix[index][i]) {
				if(!visit[i]) {
					visit[i] = true;
					send(i,cnt+1); 
					}
				visit[index] = false;
			}
		}
		if(max<cnt) max=cnt;
		return;
	}
}
