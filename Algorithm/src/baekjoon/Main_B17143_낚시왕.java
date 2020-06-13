package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B17143_낚시왕 {
	static int dir[][] = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};// 위 아래 오른쪽 왼쪽
	static int R,C,S;
	public static void main(String[] args) throws IOException {
		int s_map[][];
		boolean visit[];
		int result;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		s_map = new int[R][C];
		visit = new boolean[S];
		List<Shark> shark = new ArrayList<Shark>();
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark.add(new Shark(r,c,s,d,z));
			s_map[r][c] = i+1;
		}
		result = 0;
		// 낚시꾼의 위치 열이동
		for (int i = 0; i < C; i++) { // 열
			for (int j = 0; j < R; j++) { // 행
				int is_s = s_map[j][i];
				if(is_s>0) {
					result += shark.get(is_s-1).getZ();
					s_map[j][i] = 0;
					visit[is_s-1] = true;
					break;
				}
			}
			move(shark,s_map,visit);
		}
		System.out.println(result);
	}
	private static void move(List<Shark> shark, int[][] s_map, boolean[] visit) {
		int t_map[][] = new int[R][C];
		for (int i = 0; i < S; i++) {
			if(!visit[i]) {
				Shark tmp = shark.get(i);
				int r = tmp.getR();
				int c = tmp.getC();
				int s = tmp.getS();
				int d = tmp.getD();
				int z = tmp.getZ();
				if(d<3) {
					for (int j = 0; j < s; j++) {
						int nr = r+dir[d][0];
						if(nr<0 || nr>=R) {
							if(d%2==0) d-=1;
							else d += 1;
						}
						r += dir[d][0];
					}
				}else {
					for (int j = 0; j < s; j++) {
						int nc = c + dir[d][1];
						if(nc<0 || nc>=C){
							if(d%2==0) d-=1;
							else d += 1;
						}
						c += dir[d][1];
					}
				}
				tmp.setR(r);
				tmp.setC(c);
				tmp.setD(d);
				if(t_map[r][c]>0) {
					int t_idx = t_map[r][c]-1;
					int nz = shark.get(t_idx).getZ();
					if(z>nz) {
						t_map[r][c] = i+1;
						visit[t_idx] = true;
					}else visit[i] = true;
				}else t_map[r][c] = i+1;
			}
		}
		for (int i = 0; i < t_map.length; i++) {
			System.arraycopy(t_map, 0, s_map, 0, t_map.length);
		}
	}
	static class Shark {
		// r,c는 위치 s는 속력 d는 이동방향 z는 크기
		private int r,c,s,d,z;
		
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getS() {
			return s;
		}
		public void setS(int s) {
			this.s = s;
		}
		public int getD() {
			return d;
		}
		public void setD(int d) {
			this.d = d;
		}
		public int getZ() {
			return z;
		}
		public void setZ(int z) {
			this.z = z;
		}
		public Shark() {}
		public Shark(int r,int c,int s,int d,int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
