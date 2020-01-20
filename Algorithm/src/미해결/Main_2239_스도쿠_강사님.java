package 미해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백트랙킹
public class Main_2239_스도쿠_강사님 {

	static final int N = 9;	
	static int map[][];
	static boolean[][] row, col, squ[]; 
	static ArrayList<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		row = new boolean[N][N+1];
		col = new boolean[N][N+1];
		squ = new boolean[3][3][N+1];
		list = new ArrayList<int[]>();
		
		int no = 0;
		for(int i=0; i<N; ++i) {
			char[] line = in.readLine().trim().toCharArray();
			for(int j=0; j<N; ++j) {
				no = map[i][j] = line[j]-'0';
				if(no == 0) {
					list.add(new int[] {i,j});
					continue;
				}
				row[i][no] = true;
				col[j][no] = true;
				squ[i/3][j/3][no] = true;
			}
		}
		go(0);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) sb.append(map[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static boolean go(int index) {
		if(index == list.size()) return true;
		int x = list.get(index)[0];
		int y = list.get(index)[1];
		
		for (int i = 1; i <=N; ++i) {
			if(row[x][i] || col[y][i] || squ[x/3][y/3][i]) continue;
			map[x][y] = i;
			row[x][i] = col[y][i] = squ[x/3][y/3][i] = true;
			if(go(index+1)) return true;
			map[x][y] = 0;
			row[x][i] = col[y][i] = squ[x/3][y/3][i] = false;
		}
		return false;
	}
}