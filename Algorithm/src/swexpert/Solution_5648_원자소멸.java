package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5648_원자소멸 {
	static int map[][]; // 0: x위치 1: y위치 2:방향 3: 에너지량
	static int res;
	static boolean visit[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T, N;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][4];
			visit = new boolean[N];
			res = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
				map[i][2] = Integer.parseInt(st.nextToken());
				map[i][3] = Integer.parseInt(st.nextToken());
			}
			int dx,dy;
			int facemin,facemax;
			int crs[][] = new int[N][N];
			int minj;
			int index=0;
			boolean chk,same;
			int cnt=0;
			int i = 0;
			
			while(true) {
				same = false;
				if(cnt==N) break; 
				else {
					if(i==N-1) i = 0; 
				}
				if(visit[i])  { cnt ++; i++; continue; }
				minj = N;
				facemin = -1001;
				facemax = 1001;
				chk = false;
				for (int j = i + 1; j < N; j++) {
					dx = Math.abs(map[i][0]-map[j][0]);
					dy = Math.abs(map[i][1]-map[j][1]);
					if (map[i][2] == 0) {
						if (map[i][2] - map[j][2] == -1 && !visit[i] && !visit[j]) { // 0(상) 마주보는 상황
							if (map[i][0] == map[j][0] && map[i][1] < map[j][1]) { 
								if(facemax > map[j][1]) {facemax = map[j][1]; minj=j; chk = true;}
							}
						}else if(map[i][2] != map[j][2] && map[i][1] < map[j][1] && !visit[j]) {
							if(dx==dy && map[j][1] < facemax) {
								if((map[i][0]>map[j][0] && map[j][2]==3) || (map[i][0]<map[j][0] && map[j][2]==2)) {
									index = (crs[i][index]!=0?index+1:index);
									crs[i][index] = j;
								}
							}
						}else if(!visit[j] && map[i][2] == map[j][2]) {
							if(map[i][1] < map[j][1] && map[j][1] < facemax &&  map[i][0]==map[j][0]) {
								i = j;
								same=true;
								break;
							}
						}
					}
					else if (map[i][2] == 2) {
						if (map[i][2] - map[j][2] == -1 && !visit[i] && !visit[j]) { // 2(좌) 마주보는 상황
							if (map[i][1] == map[j][1] && map[i][0] > map[j][0]) { 
								if(facemin < map[j][0]) {facemin = map[j][0]; minj=j; chk = true;}
							}
						}else if(map[i][2] != map[j][2] && map[i][0] > map[j][0] && !visit[j]) {
							if(dx==dy && map[j][0] > facemin) {
								if((map[i][1]>map[j][1] && map[j][2]==0) || (map[i][1]<map[j][1] && map[j][2]==1)) {
									index = (crs[i][index]!=0?index+1:index);
									crs[i][index] = j;
								}
							}
						}else if(!visit[j] && map[i][2] == map[j][2]) {
							if(map[i][0] > map[j][0] && map[j][0] > facemin && map[i][1]==map[j][1]) {
								i = j;
								same=true;
								break;
							}
						}
					}
					else if (map[i][2] == 1) {
						if (map[i][2] - map[j][2] == 1 && !visit[i] && !visit[j]) { // 1(하) 마주보는 상황
							if (map[i][0] == map[j][0] && map[i][1] > map[j][1]) { 
								if(facemin < map[j][1]) {facemin = map[j][1]; minj=j; chk = true;}
							}
						}else if(map[i][2] != map[j][2] && map[i][1] > map[j][1] && !visit[j]) {
							if(dx==dy && map[j][1] > facemin) {
								if((map[i][0]>map[j][0] && map[j][2]==3) || (map[i][0]<map[j][0] && map[j][2]==2)) {
									index = (crs[i][index]!=0?index+1:index);
									crs[i][index] = j;
								}
							}
						}else if(!visit[j] && map[i][2] == map[j][2]) {
							if(map[i][1] > map[j][1] && map[j][1] > facemin && map[i][0]==map[j][0]) {
								i = j;
								same=true;
								break;
							}
						}
					}
					else if (map[i][2] == 3) {
						if (map[i][2] - map[j][2] == 1 && !visit[i] && !visit[j]) { // 3(우) 마주보는 상황
							if (map[i][1] == map[j][1] && map[i][0] < map[j][0]) {
								if(facemax > map[j][0]) {facemax = map[j][0]; minj=j; chk = true;}
							}
						}else if(map[i][2] != map[j][2] && map[i][0] < map[j][0] && !visit[j]) {
							if(dx==dy && map[j][0] < facemax) {
								if((map[i][1]>map[j][1] && map[j][2]==0) || (map[i][1]<map[j][1] && map[j][2]==1)) {
									index = (crs[i][index]!=0?index+1:index);
									crs[i][index] = j;
								}
							}
						}else if(!visit[j] && map[i][2] == map[j][2]) {
							if(map[i][0] < map[j][0] && map[j][0] < facemax && map[i][1]==map[j][1]) {
								i = j;
								same=true;
								break;
							}
						}
					}
				}
				if(minj!=N) {
					input(i,minj);
				}
				for (int k = 0; k < N; k++) {
					if(!chk && crs[i][k]!=0) {
						input(i,crs[i][k]);
					}else if(chk && crs[i][k]!=0) {
						dx = Math.abs(map[i][0]-map[crs[i][k]][0]);
						dy = Math.abs(map[i][1]-map[crs[i][k]][1]);
						if(dx==dy) input(i,crs[i][k]);
					}
					
				}
				if(!same) i++;
			} // while문 끝
			System.out.println("#"+t+" "+res);
		} // T 포문 끝
	}

	private static void input(int i, int j) { // 에너지 추가 함수
		if (!visit[i]) {
			res += map[i][3];
			visit[i] = true;
		}
		if (!visit[j]) {
			res += map[j][3];
			visit[j] = true;
		}
	}
}
