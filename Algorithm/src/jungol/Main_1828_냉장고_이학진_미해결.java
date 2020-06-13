package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1828_냉장고_이학진_미해결 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken()); 
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[1]-o2[1];
			}
		});
		
		int res = 1;
		for (int i = 0; i < N; i++) {
			int cmax = map[i][1];
			for (int j = i+1; j < N; j++) {
				if(cmax < map[j][0]) {
						res++;
						break;
				}
				i++;
			}
		}
		System.out.println(res);
	}
}
