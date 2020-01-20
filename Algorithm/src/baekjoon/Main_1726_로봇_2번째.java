package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇_2번째 {
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};	// 1 : 동 2:서 3:남 4:북
	static int sr,sc,sd,er,ec,ed;
	static boolean chk[][];
	static int N,M,cnt=0,walk=0;
	static int map[][];
	static Queue<Integer> que = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		chk = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		sd = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		er = Integer.parseInt(st.nextToken());
		ec = Integer.parseInt(st.nextToken());
		ed = Integer.parseInt(st.nextToken());
		
		
	}
	
	public static void bfd(int sr, int sc, int sd) {
		int nr=sr,nc=sc,nd=sd;
		chk[nr][nc]=true;	// 자기 자리 방문 여부
		nr = nr+dir[nd][0];	// 바라 보는 방향 
		nc = nc+dir[nd][1];	// 바라 보는 방향
		if(nr>=0 && nr<N && nc>=0 && nc<M) {
			if(nr == er && nc == ec) {
				if(nd == ed) {
					return;
				}else {
					
				}
			}
			if(map[nr][nc]==0 && !chk[nr][nc]) {	// 바라 보는 방향 확인
				if(walk==3) { cnt++; walk=0;}				// 바라 보는 방향으로 3번 갔을경우 cnt 증가 후 걸음 초기화
				walk++;
				que.add(nr*M+nc);
				chk[nr][nc]=true;
			}else {						// 바라 보는 방향에 길이 없으면 결국 회전을 해야 하기때문에 cnt 증가
				cnt++;
				walk=0;					// 걸음 초기화
				switch(nd) {
				case 1:
					nd = 4;	// left
					nd = 3; // right
					break;
				case 2:
					nd = 3;	//left
					nd = 4; // right
					break;
				case 3:
					nd = 1; // left
					nd = 2; //right
					break;
				case 4:
					nd = 2; //left
					nd = 1; //right
					break;
				}
			}
		}else {
			nr = nr - dir[nd][0];
			nc = nc - dir[nd][1];
		}
	}
}
