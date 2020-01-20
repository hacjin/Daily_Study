package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16939_2x2x2큐브 {
	static int arr[];
	static final int N = 24;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[N+1];
		int move[][] = {{1,2,18,20,12,11,15,13}	// 4방향 이동 인덱스
					   ,{1,3,5,7,9,11,24,22}
					   ,{5,6,17,18,21,22,13,14}
					   };
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(check(move)?1:0);
	}

	private static boolean check(int[][] move) {
		boolean bool1 = false;
		boolean bool2 = false;
		int tmap[] = new int[N+1];
		for (int d = 0; d < 6; d++) {
			tmap = swap1(d,move);
			bool1 = right(tmap);
			tmap = swap2(d,move);
			bool2 = right(tmap);
			if(bool1 || bool2) break;
		}
		return (bool1||bool2)?true:false;
	}

	private static boolean right(int tmap[]) {
		boolean bool = true;
		for (int i = 1; i < N ; i+=4) {
			if(tmap[i]!=tmap[i+1] || tmap[i+1]!=tmap[i+2] 
					|| tmap[i+2]!=tmap[i+3] )  bool=false;
		}
		return bool;
	}

	private static int[] swap1(int d,int[][] move) {
		int tmap[] = new int[N+1];
		int val=0;
		for (int i = 1; i <= N; i++) {
			val = arr[i];
			tmap[i] = val;
		}
		int n = move[d].length;
		int tmp = tmap[move[d][n-1]];
		int tmp2 = tmap[move[d][n-2]];
		for (int i = n-3; i >= 0; i--) {
			tmap[move[d][i+2]] = tmap[move[d][i]];
		}
		tmap[move[d][0]] = tmp2;
		tmap[move[d][1]] = tmp;
		return tmap;
	}
	
	private static int[] swap2(int d,int[][] move) {
		int tmap[] = new int[N+1];
		int val=0;
		for (int i = 1; i <= N; i++) {
			val = arr[i];
			tmap[i] = val;
		}
		int n = move[d].length;
		int tmp = tmap[move[d][0]];
		int tmp2 = tmap[move[d][1]];
		for (int i = 0; i < n-2; i++) {
			tmap[move[d][i]] = tmap[move[d][i+2]];
		}
		tmap[move[d][n-1]] = tmp2;
		tmap[move[d][n-2]] = tmp;
		return tmap;
	}
}
