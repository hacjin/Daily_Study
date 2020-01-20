package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16987_계란으로계란치기 {
	static int N,arr[][];
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		combi(0);
		System.out.println(res);
	}
	private static void combi(int idx) {
		if(idx==N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if(arr[i][0]<1) cnt++;
			}
			if(res<cnt) {
				res = cnt;
			}
			return;
		}
		int ct,cw,it,iw;
		ct = arr[idx][0];
		cw = arr[idx][1];
		if(ct<1) {
			combi(idx+1);
			return;
		}
		for (int i = 0; i < N; i++) {
			it = arr[i][0];
			iw = arr[i][1];
			if(idx==N-1 && i==N-1) combi(idx+1);
			if(it<1 || idx==i) continue;
			arr[idx][0] = ct-iw;
			arr[i][0] = it-cw;
			combi(idx+1);
			arr[idx][0] = ct;
			arr[i][0] = it;
		}
	}
}
