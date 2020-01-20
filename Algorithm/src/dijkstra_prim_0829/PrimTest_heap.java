package dijkstra_prim_0829;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest_heap {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 인접행렬 생성

		boolean visit[] = new boolean[N];
		int min = Integer.MAX_VALUE, res = 0;
		PriorityQueue<Node> que = new PriorityQueue<Node>();

		// 임의의 시작점
		que.offer(new Node(0, 0));

		Node cur = null;
		int cnt = 0;
		while (!que.isEmpty()) { // 선택한 임의의 정점을 뺀 나머지 정점수만큼 반복
			cur = que.poll();
			if(visit[cur.vertex]) continue;
			visit[cur.vertex] = true;
			res += cur.weight;
			if(++cnt == N) break;

			// cur 기준으로 인접행렬 보며 방문하지 않은 정점 que에 넣기
			for (int j = 0; j < N; j++) {
				if (!visit[j] && input[cur.vertex][j] != 0 && input[cur.vertex][j] < min) {
					que.offer(new Node(j, input[cur.vertex][j]));
				}
			}
		}
		System.out.println(res);
	}

	private static class Node implements Comparable<Node> {
		int vertex, weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.weight, other.weight); // int 범위 overflow 방지
		}

	}

}
