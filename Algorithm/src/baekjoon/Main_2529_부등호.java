package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2529_부등호 {
	static boolean visit[];
	static long MAX = 0;
	static long MIN = Long.MAX_VALUE;
	static int k;
	static char map[];
	static int res[];
	static String minr,maxr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(br.readLine());
		map = new char[k];
		res = new int[k+1];
		visit = new boolean[10];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			map[i] = st.nextToken().charAt(0);
		}
		
		for (int i = 0; i < 10; i++) {
			res[0] = i;
			visit[i] = true;
			compare(0,0,0);
			visit[i] = false;
		}
		System.out.println(maxr);
		System.out.println(minr);
	}
	private static void compare(int index, int v, int cnt) {
		if(v==10 || index==10) return;
		if(cnt==k) {
			long tmp = Long.parseLong(Arrays.toString(res).replaceAll("[^0-9]",""));
			if(tmp < MIN) {
				MIN = tmp;
				minr = Arrays.toString(res).replaceAll("[^0-9]","");
			}
			if(tmp>MAX) {
				MAX = tmp;
				maxr = Arrays.toString(res).replaceAll("[^0-9]","");
			}
			return;
		}
		switch(map[cnt]) {
			case '>':
				if(!visit[v] && res[index] > v) {
					visit[v] = true;
					res[index+1] = v;
					compare(index+1,0,cnt+1);
					visit[v] = false;
				}
				break;
			case '<':
				if(!visit[v] && res[index] < v) {
					visit[v] = true;
					res[index+1] = v;
					compare(index+1,0,cnt+1);
					visit[v] = false;
				}
				break;
		}
		compare(index,v+1,cnt);
	}
}