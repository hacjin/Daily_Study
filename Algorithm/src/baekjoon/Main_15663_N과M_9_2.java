package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15663_N과M_9_2 {
	static int N,M,datas[],nums[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		datas = new int[N];
		nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			datas[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(datas);
		permu(0,0);
		System.out.println(sb);
	}
	

	private static void permu(int index, int flag) {
		if(index==M) {
			for (int i = 0; i < M; ++i) {
				sb.append(nums[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; ++i) {
			if((flag & 1<<i) == 0) {
				if(nums[index] != datas[i]) {
					nums[index] = datas[i];
					permu(index+1, (flag | 1<<i));
				}
			}
		}
		nums[index] = 0;
	}

}
