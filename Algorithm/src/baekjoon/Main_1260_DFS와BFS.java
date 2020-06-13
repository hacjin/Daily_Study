package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static int N,M,V;
	static int map[][];
	static boolean visit[];
	static List<Integer> output;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[s][e] = 1;
			map[e][s] = 1;
		}
		List<Integer> tmp = new ArrayList<Integer>();
		visit = new boolean[N+1];
		dfs(V,1,tmp);
		for (Integer integer : tmp) {
			System.out.print(integer+" ");
		}
		System.out.println();
		tmp = new ArrayList<Integer>();
		visit = new boolean[N+1];
		bfs(V,tmp);
		for (Integer integer : tmp) {
			System.out.print(integer+" ");
		}
	}
	private static void bfs(int index, List<Integer> tmp) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(index);
		visit[index]= true;
		tmp.add(index);
		while(!que.isEmpty()) {
			int in = que.poll();
			for (int i = 1; i < N+1; i++) {
				if(!visit[i] && map[in][i]==1) {
					que.add(i);
					tmp.add(i);
					visit[i]=true;
				}
			}
		}
	}
	private static void dfs(int index,int cnt, List<Integer> tmp) {
		visit[index] = true;
		tmp.add(index);
		for (int i = 1; i < N+1; i++) {
			if(!visit[i] && map[index][i]==1) {
				dfs(i,cnt+1,tmp);
			}
		}
	}
}