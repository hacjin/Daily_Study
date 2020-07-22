package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_B10989_수정렬하기3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[10000];
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine()); 
			arr[input-1]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < arr[i]; j++) {
				sb.append(i+1+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
