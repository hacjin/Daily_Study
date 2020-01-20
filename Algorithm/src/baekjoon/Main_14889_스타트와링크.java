package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int map[][];
	static int N,R,min=Integer.MAX_VALUE;
	static List<int[]> com;
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = N/2;
		map = new int[N][N];
		com = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int tmp[] = new int[R];
		combi(0,0,tmp);
		int sel[] = new int[R];
		int dsel[] = new int[R];
		for (int i = 0; i < com.size(); i++) {
			visit = new boolean[N];
			for (int j = 0; j < com.get(i).length; j++) {
				visit[com.get(i)[j]] = true;
			}
			int sin=0,din=0;
			for (int j = 0; j < N; j++) {
				if(visit[j]) {
					sel[sin++] = j;
				}else {
					dsel[din++] = j;
				}
			}
			int ssum=0,dsum=0;
			for (int j = 0; j < sel.length-1; j++) {
				for (int k = j+1; k < sel.length; k++) {
					ssum += map[sel[j]][sel[k]] + map[sel[k]][sel[j]];
				}
			}
			for (int j = 0; j < dsel.length-1; j++) {
				for (int k = j+1; k < dsel.length; k++) {
					dsum += map[dsel[j]][dsel[k]] + map[dsel[k]][dsel[j]];
				}
			}
			if(min>Math.abs(ssum-dsum)) min = Math.abs(ssum-dsum);
		}
		System.out.println(min);
	}
	private static void combi(int i, int count, int tmp[]) {
		if(count==R) {
			int val[] = new int[R];
			for (int j = 0; j < R; j++) {
				val[j] = tmp[j];
			}
			com.add(val);
			return;
		}
		for (int j = i; j < N; j++) {
			tmp[count] = j;
			combi(j+1,count+1,tmp);
		}
	}
}
