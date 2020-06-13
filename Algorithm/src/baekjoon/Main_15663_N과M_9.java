package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15663_N과M_9 {
	static int N,M;
	static int arr[];
	static int res[];
	static List<int[]> list = new ArrayList<>();
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[M];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			res[0] = arr[i];
			visit[i] = true;
			combi(i,1);
			visit[i] = false;
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int ti = 0;
				for (int i = 0; i < M; i++) {
					if(o1[i]-o2[i]==0) continue;
					else { ti = i; break; }
				}
				return o1[ti]-o2[ti];
			}
		});
		int tmp[] = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			int tmp2[] = list.get(i);
			for (int j = 0; j < M; j++) {
				if(tmp[j]!=tmp2[j]) {
					for (int k = 0; k < M; k++) {
						System.out.print(tmp[k]+" ");
					}
					System.out.println();
					tmp = Arrays.copyOf(tmp2, M);
				}
			}
		}
		for (int k = 0; k < M; k++) {
			System.out.print(tmp[k]+" ");
		}
	}
	private static void combi(int idx, int cnt) {
		if(cnt==M) {
			int[] tmp = new int[M];
			for (int i = 0; i < M; i++) {
				int t = res[i];
				tmp[i] = t;
			}
			list.add(tmp);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				res[cnt] = arr[i];
				combi(i,cnt+1);
				visit[i] = false;
			}
		}
	}
}
