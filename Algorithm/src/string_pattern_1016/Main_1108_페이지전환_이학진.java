package string_pattern_1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1108_페이지전환_이학진 {
	static int Node[][];
	static double sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node = new int[N][N];
		int maxn = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int node = Integer.parseInt(st.nextToken());
			if(maxn<node) maxn=node;
			Node[index][node]=1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0 ; j < N; j++) {
				if(i!=j && Node[i][j] == 0) Node[i][j] = 9999;
			}
		}
		for (int k = 1; k <= maxn; k++) {	// 경유지
			for (int i = 1; i <= maxn; i++) {	// 출발지
				if(i==k) continue;		// 경유지와 출발지가 같아질 경우
				for (int j = 1; j <= maxn; j++) {	// 도착지
					if(j==k || j==i) continue;	// 도착지와 경유지가 같아질 경유 || 출발지와 도착지가 같을 경우
					if(Node[i][k]+Node[k][j] < Node[i][j]) Node[i][j] = Node[i][k]+Node[k][j];
				}
			}
		}
		for (int i = 1; i <= maxn; i++) {
			for (int j = 1; j <= maxn; j++) {
				if(i!=j && Node[i][j]>0) sum += Node[i][j];
			}
		}
		sum = sum/((maxn-1)*(maxn));
		System.out.println(String.format("%.3f", sum));
	}
}
