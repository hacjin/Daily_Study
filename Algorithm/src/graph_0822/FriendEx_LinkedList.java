package graph_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FriendEx_LinkedList {
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		C = Integer.parseInt(in.readLine());
		
		adjList = new Node[N];
		
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = st.nextToken().charAt(0)-'A';
			int to = st.nextToken().charAt(0)-'A';
			
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		
		System.out.println((char)(goMatrix('A'-'A')+65));
	}
	private static int goMatrix(int cur) {
		int MAX=0, MAX_FRIEND=0;
		for (Node curFriend = adjList[cur]; curFriend != null; curFriend = curFriend.next) {
				int count = 0;
				for (Node tmp = adjList[curFriend.vertex]; tmp != null; tmp = tmp.next) {
					count++;
				}
				System.out.println((char)(curFriend.vertex+65)+" 의 친구수 : "+count);
				if(MAX < count) {
					MAX = count;
					MAX_FRIEND = curFriend.vertex;
				}
			}
		return MAX_FRIEND;
	}
}
