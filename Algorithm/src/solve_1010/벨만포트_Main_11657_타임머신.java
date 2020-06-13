package solve_1010;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 벨만포트_Main_11657_타임머신 {
	
	static final int INF = Integer.MAX_VALUE;
	static int count, edgeCount;
	static int[] distance;	// 거리배열
	static Edge[] edges;	// 간선배열
	
	static class Edge {
		int from, to ,weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		count = Integer.parseInt(st.nextToken());
		edgeCount = Integer.parseInt(st.nextToken());
		distance = new int[count];
		edges = new Edge[edgeCount];
		for (int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine()," ");
			edges[i] = new Edge(Integer.parseInt(st.nextToken())-1,
								Integer.parseInt(st.nextToken())-1,
								Integer.parseInt(st.nextToken()));
		}
		Arrays.fill(distance, INF);
		distance[0] = 0;
		if(goNegativeCycle()) {
			System.out.println("-1");
		}else {
			for (int i = 1; i < count; i++) {
				System.out.println(distance[i]==INF?-1:distance[i]);
			}
		}
	}
	
	private static boolean goNegativeCycle() {
		//간선리스트를 N-1번 ( 음수싸이클 확인 : N번 ) 반복화며 간선완화 작업
		boolean flag = true;  // 간선완화가 안일어날 경우
		for (int i = 1; i <= count ; i++) {
			for (Edge e : edges) {
				if(distance[e.from] == INF) continue; // 1번 도시에서 from까지 최소비용이 INF면 다음 간선
				if(distance[e.from] + e.weight < distance[e.to]) {
					flag = false;
					distance[e.to] = distance[e.from] + e.weight;
					if(i==count) {
						return true;	// 음수 싸이클
					}
				}
			}
			if(flag) return false;
		}
		return false;
	}
}
