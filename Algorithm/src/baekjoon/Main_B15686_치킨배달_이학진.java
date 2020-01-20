package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B15686_치킨배달_이학진 {
	static int N,M,map[][],dis[][];
	static List<Integer> min;
	static int hs,cs,result=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		List<int[]> home = new ArrayList<int[]>();
		List<int[]> chi = new ArrayList<int[]>();
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) home.add(new int[] { r,c});
				if(map[r][c]==2) chi.add(new int[] { r,c});
			}
		}
		hs = home.size();
		cs = chi.size();
		dis = new int[cs][hs];
		int h[] = new int[2];
		int c[] = new int[2];
		for (int i = 0; i < cs; i++) {
			for (int j = 0; j < hs; j++) {
				c = chi.get(i);
				h = home.get(j);
				dis[i][j] = Math.abs(c[0]-h[0]) + Math.abs(c[1]-h[1]);
			}
		}
		min = new ArrayList<>();
		for (int i = 0; i < cs; i++) {
			int tmp[] = new int[M];
			combi(i,0,tmp);
		}
		
		System.out.println(result);
	}
	private static void combi(int index, int cnt,int[] tmp) {
		tmp[cnt] = index;
		if(cnt==M-1) {
			calc(tmp);
			return;
		}
		for (int i = index+1; i < cs; i++) {
			combi(i,cnt+1,tmp);
		}
	}
	private static void calc(int[] tmp) {
		int arr[] = new int[hs];
		Arrays.fill(arr, Integer.MAX_VALUE);
		for (int i = 0; i < tmp.length; i++) {
			int index = tmp[i];
			for (int j = 0; j < hs; j++) {
				if(dis[index][j] < arr[j]) arr[j] = dis[index][j];
			}
		}
		int sum = 0;
		for (int i = 0; i < hs; i++) {
			sum += arr[i];
		}
		if(result > sum) result = sum;
	}
}
