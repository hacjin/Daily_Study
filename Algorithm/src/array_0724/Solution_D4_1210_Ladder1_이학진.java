package array_0724;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1_이학진 {
	static int point;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T, N = 100;
		int arr[][];
		int dir[][] = { { -1, 0 }, { 0, -1 }, { 0, 1 } }; // 상 dis : 0 좌  dis : 1 우 dis: 2	
		int strIndex = 0, stcIndex = 0,dirs=0;

		arr = new int[N][N];
		for (int t = 0; t < 10; t++) {
			T = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				if (arr[99][i] == 2) {
					strIndex = 99;
					stcIndex = i;
				}
			}
			ladder(arr, dir, strIndex,stcIndex,dirs);
			System.out.println("#"+T+" "+point);
		}

	}

	public static void ladder(int arr[][], int dir[][], int strIndex,int stcIndex,int dirs) {
		int nr, nc;
		nr = strIndex; nc = stcIndex;
		if(nr==0) point = nc;
		else {
			if (nc + dir[2][1] < 100 && dirs != 1 && arr[nr + dir[2][0]][nc + dir[2][1]] == 1) { // 현재 위치 우 위치의 길 판별
				nc = nc + dir[2][1];
				dirs = 2;
			} 
			if (nc + dir[1][1] >= 0 && dirs != 2 && arr[nr + dir[1][0]][nc + dir[1][1]] == 1) { // 현재 위치 좌 위치의 길 판별
				nc = nc + dir[1][1];
				dirs = 1;
			}
			if (arr[nr + dir[0][0]][nc + dir[0][1]] == 1) { // 현재 위치 상 위치의 길 판별
				nr = nr + dir[0][0];
				dirs = 0;
			}
			ladder(arr, dir, nr, nc, dirs);
		}
		

	}
}
