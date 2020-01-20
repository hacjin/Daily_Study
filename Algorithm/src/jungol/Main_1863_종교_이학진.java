package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1863_종교_이학진 {
	static boolean visit[];
	static int N, M;
	static List<Integer> list[];
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[r].add(c);
			list[c].add(r);

		}
		res = 0;
		for (int r = 1; r < N + 1; r++) {
			if (!visit[r]) {
				bfs(r);
				res++;
			}
		}
		System.out.println(res);
	}

	private static void bfs(int r) {
		visit[r] = true;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(r);
		while (!que.isEmpty()) {
			int qsize = que.size();
			while (qsize-- > 0) {
				int nr = que.remove();
				for (int index = 0; index < list[nr].size(); index++) {
					int nc = list[nr].get(index);
					if (!visit[nc]) {
						visit[nc] = true;
						que.add(nc);
					}
				}
			}
		}
	}
}