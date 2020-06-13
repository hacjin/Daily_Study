package solve_1002;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵_강사님 {						// 백트래킹 방법 - 탐색 1번할때마다 조건을 비교해본 후 진행  ( 완전탐색방식은 다하고 나서 끝에서 조건을 검색한다.) 
	static final int n = 6;	// 팀수
	static final int m = 15;	// 6나라 중 2나라씩 치루는 총 경기의 수 6C2
	static int win[], lose[], draw[];
	static int genWin[], genLose[], genDraw[];
	static int player1[], player2[];
	static boolean feasibility;
	
	// cnt에 해당하는 경기의 두팀에 대해 3가지의 경우로 시도해봄
	// 각 경우가 가능하다면 해당 경우에서 다음 경기로 재귀호출
	static void go(int cnt) {
		if(cnt == m) {
			feasibility = true;
			return;
		}
		int p1 = player1[cnt];
		int p2 = player2[cnt];
		genWin[p1]++;	// player1팀 이기는 처리
		genLose[p2]++;	// player2팀 지는 처리
		
		if(genWin[p1] <= win[p1] && genLose[p2] <= lose[p2]) { // 위에서 처리한 결과값이 기자가
			go(cnt+1);
		}
		genWin[p1]--;
		genLose[p2]--;
		if(feasibility) return;	// 가지치기
		
		genDraw[p1]++;
		genDraw[p2]++;
		if(genDraw[p1] <= draw[p1] && genDraw[p2] <= draw[p2]) { // 위에서 처리한 결과값이 기자가
			go(cnt+1);
		}
		genDraw[p1]--;
		genDraw[p2]--;
		if(feasibility) return;	// 가지치기
		
		genLose[p1]++;	// player1팀 지는 처리
		genWin[p2]++;	// player2팀 이기는 처리
		
		if(genWin[p2] <= win[p2] && genLose[p1] <= lose[p1]) { // 위에서 처리한 결과값이 기자가
			go(cnt+1);
		}
		genLose[p1]--;
		genWin[p2]--;
		if(feasibility) return;	// 가지치기
	}
	public static void main(String[] args) throws IOException {
		win = new int[n];
		draw = new int[n];
		lose = new int[n];
		genWin = new int[n];
		genDraw = new int[n];
		genLose = new int[n];
		player1 = new int[m];
		player2 = new int[m];
		
		for (int i = 0,cnt=0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				player1[cnt] = i;
				player2[cnt] = j;
				cnt++;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L:for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				win[j]= Integer.parseInt(st.nextToken());
				draw[j]= Integer.parseInt(st.nextToken());
				lose[j]= Integer.parseInt(st.nextToken());
				
				if(win[j] + lose[j] + draw[j] != n-1) {	//
					System.out.println("0 ");
					continue L;
				}
			}
			feasibility = false;
			go(0);
			System.out.println(feasibility?"1 ":"0 ");
		}
	}
}
