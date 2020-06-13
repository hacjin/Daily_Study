package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5648_원자소멸2 {
	static List<Integer[]> list;
	static Integer[] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		int N;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				tmp = new Integer[4];
				st = new StringTokenizer(br.readLine());
				tmp[0] = Integer.parseInt(st.nextToken());
				tmp[1] = Integer.parseInt(st.nextToken());
				tmp[2] = Integer.parseInt(st.nextToken());
				tmp[3] = Integer.parseInt(st.nextToken());
				list.add(tmp);
			}
			
			for (int i = 0; i < N; i++) {
				tmp = new Integer[4];
				tmp = list.get(i);
				for (int j = i+1; j < N; j++) {
					if( tmp[2] == 0 ) {
						if(tmp[2]-list.get(j)[2] == -1) {
							
						}
					}else if(tmp[2] == 1) {
						
					}else if(tmp[2] == 2) {
						
					}else {					// 방향 3일 때
						
					}
				}
			}
		}
	}
}
