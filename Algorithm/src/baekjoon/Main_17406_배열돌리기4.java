package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static int min = Integer.MAX_VALUE;
	static int[][] tmp;
	static int[][] tmp2;
	static int[][] ro;
	static int[][] map;
	static int N,M,K;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		tmp = new int[N+1][M+1];
		tmp2 = new int[N+1][M+1];
		ro = new int[K][3];
		int orderk[] = new int[K];
		visit = new boolean[K];
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < K; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				ro[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		perm(orderk,0);
		System.out.println(min);
	}
	private static void perm(int[] orderk,int cnt) {
		if(cnt==K) { 
			rocal(orderk);
			return;
		}
		for (int k = 0; k < K; k++) {
			if(!visit[k]) {
				visit[k]=true;
				orderk[cnt] = k;
				perm(orderk,cnt+1);
				visit[k]=false;
			}
		}
	}
	private static void rocal(int[] k) {
		int index = 0;
		for (int[] is : map) {
			tmp2[index] = Arrays.copyOf(is, M+1);
			tmp[index++] = Arrays.copyOf(is, M+1);
		}
		for (int i = 0; i < k.length; i++) {
			int sr = ro[k[i]][0]-ro[k[i]][2];
			int sc = ro[k[i]][1]-ro[k[i]][2];
			int er = ro[k[i]][0]+ro[k[i]][2];
			int ec = ro[k[i]][1]+ro[k[i]][2];
			int r,c;
			while(sr<er) {
					r = sr;						// r==sr && c <ec
					for (c = sc; c < ec; c++) {	// 시작r행을 동쪽으로 이동
						tmp2[r][c+1] = tmp[r][c];
					}
					
					c = ec;						// c==ec && r <er
					for (r = sr; r < er; r++) {	// 끝c열을 남쪽으로 이동
						tmp2[r+1][c] = tmp[r][c];
					}
					
					r = er;						// r==er && c >sc
					for (c = ec; c > sc; c--) {	// 끝r행을 서쪽으로 이동
						tmp2[r][c-1] = tmp[r][c];
					}
					c = sc;						// c==sc && r >sr
					for (r = er; r > sr; r--) { // 시작c열 북쪽으로 이동
						tmp2[r-1][c] = tmp[r][c];
					}
				sr++; er--;
				sc++; ec--;
			}
			index=0;
			for (int[] is : tmp2) {
				tmp[index++] = Arrays.copyOf(is, M+1);
			}
		}
		int sum;
		for (int sumr = 1; sumr <= N; sumr++) {
			sum = 0;
			for (int sumc = 1; sumc <= M; sumc++) {
				sum += tmp2[sumr][sumc];
			}
			if(sum<min) {
				min = sum;
			}
		}
	} // rocal 함수 끝
}
