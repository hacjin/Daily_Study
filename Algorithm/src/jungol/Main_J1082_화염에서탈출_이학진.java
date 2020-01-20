package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_J1082_화염에서탈출_이학진 {
	static int R,C,result = Integer.MAX_VALUE;
	static int dir[][] = { {-1,0}, {0,1}, {1,0}, {0,-1} }; // 북동남서
	static char map[][];
	static int b[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		b = new int[R][C];
		visit = new boolean[R][C];
		int s[] = new int[2];
		List<int[]> fire = new ArrayList<int[]>();
		
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if(map[r][c]=='*') {
					fire.add(new int[] { r,c });
				}
				if(map[r][c]=='S') {
					s[0] = r;
					s[1] = c;
				}
			}
		}
		for (int i = 0; i < fire.size(); i++) {
			int f[] = fire.get(i);
			burn(f[0],f[1]);
		}
		visit = new boolean[R][C];
		move(s[0],s[1]);
		System.out.println(result==Integer.MAX_VALUE?"impossible":result);
	}
	private static void burn(int i, int j) {
		Queue<int[]> fire = new LinkedList<>();
		fire.add(new int[] {i,j,0});
		while(!fire.isEmpty()) {
			int[] f = fire.poll();
			int r = f[0], c = f[1], cnt = f[2];
			visit[r][c] = true;
			
			int nr,nc;
			for (int d = 0; d < dir.length; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				if(nr>= 0 && nr < R && nc>=0 && nc<C) {
					if(!visit[nr][nc] && map[nr][nc] =='.') {
						visit[nr][nc] = true;
						if(b[nr][nc]==0 || b[nr][nc] > cnt+1) {
							b[nr][nc] = cnt+1;
						}
						fire.add(new int[] {nr,nc,cnt+1});
					}
				}
			}
		}
	}
	private static void move(int i, int j) {		// cnt 는 시간
		Queue<int[]> man = new LinkedList<>();
		man.add(new int[] {i,j,0});
		while(!man.isEmpty()) {
			int[] m = man.poll();
			int r = m[0], c = m[1], cnt = m[2];
			if(map[r][c]!='S' && b[r][c]>0 && b[r][c]<=cnt) {
				continue;
			}
			if(map[r][c] == 'D') {
				if(result > cnt) {
					result = cnt;
				}
				break;
			}
			visit[r][c] = true;
			int nr,nc;
			for (int d = 0; d < dir.length; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];
				if(nr>=0 && nr < R && nc>=0 && nc<C) {
					if(!visit[nr][nc] && map[nr][nc]!='X' && map[nr][nc]!='*') {
						visit[nr][nc] = true;
						man.add(new int[] { nr,nc,cnt+1});
					}
				}
			}
		}
	}
}
