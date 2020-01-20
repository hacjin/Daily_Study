package graph_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Send_Friend_Linked {
	static class Node {
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
		
	}
	static int N,C;
	static Node[] adjList;
	static Queue<Node> que = new LinkedList<Node>();
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		adjList = new Node[N];
		visit = new boolean[N];
		
		
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = st.nextToken().charAt(0)-'A';
			int to = st.nextToken().charAt(0)-'A';
			
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		
		for (int i = 0; i < N; i++) {
			bfs(i);
		}
	}
	private static void bfs(int index) {
		visit[index] = true;
		que.add(adjList[index]);

		Node tmp = que.remove();
		while(!que.isEmpty()) {
			System.out.println((char)(tmp.vertex+65));
			while(tmp!=null) {
				
				tmp = tmp.next;
				visit[tmp.vertex] = true;
				que.add(adjList[tmp.vertex]);
			}
		}
		bfs(que.peek().vertex);
	}
}
